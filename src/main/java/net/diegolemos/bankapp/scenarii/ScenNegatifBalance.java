package net.diegolemos.bankapp.scenarii;

import org.junit.Test;

import bibliotheque.ExcelFileRead;
import bibliotheque.ReadConfFile;
import bibliotheque.Report;
import bibliotheque.VerifElement;
import net.codestory.simplelenium.SeleniumTest;
import net.diegolemos.bankapp.account.Account;
import net.diegolemos.bankapp.all.MenuHeader;
import net.diegolemos.bankapp.client.Client;

public class ScenNegatifBalance extends SeleniumTest {
	
	private static  Report rapport=new Report();
	private   String idCase="ScenNegatifBalance";
	
	
	 @Test
	  public void check_page() throws Exception {
		  String idReport = "0";
			try {
                    /////////////////////////////Initialisation ///////////////////////////////////////////////////////////////
					String[] Param_Server = ReadConfFile.Get_Info("1");	
					String Url = Param_Server[0];
					
					
					idReport = rapport.setCreateReport( "e", idCase);
					rapport.setMessageResultat(idCase);
					String[][] tabExcel = ExcelFileRead.read("Data/ScenNegatifBalance.xls", 8, 8);
					////////////////////////////////////////////////////// Déclaration des variables/////////////////////////////////
					String commentaire = "";
					String actionExcel = "";
					String nameClient = "";
					
					String amount = "";
					String type = "";
					String valueBalance = "";
					boolean resultatObtenuMsg = true;
					
					/////////////////////////////////////////////////////Lancement Scenario ////////////////////////////////////////////
					goTo(Url);
					MenuHeader menu = new MenuHeader();
					VerifElement verification = new VerifElement();
					Account account = new Account();
					Client client = new Client();
					
					for(int i=2; i<tabExcel.length; i++)
					{
						commentaire =  tabExcel[i][0] + " - " + tabExcel[i][1];
						System.out.println(commentaire);
						rapport.setMessageResultat(commentaire);
						rapport.setCreateStep(idReport, commentaire, "p", "");
						actionExcel = tabExcel[i][2];
						
						switch (actionExcel) 
						{
							
							case "GoToClient":
								menu.clickClients();
								break;
								
							case "AddClient":
								menu.clickClients();
								nameClient = tabExcel[i][5];
								client.addNewClient(nameClient);
								resultatObtenuMsg = verification.VerifierMessage_Existe(nameClient);
								verification.ValidResultat_obtenu_attendu(resultatObtenuMsg, true,rapport, nameClient);
								Thread.sleep(2000L);
								break;
								
							case "GoToAccount":
								menu.clickAccounts();
								break;
								
							case "searchClient":
								nameClient = tabExcel[i][5];
								account.searchClient(nameClient, rapport);
								Thread.sleep(2000L);
								break;	
								
							case "AddAccount":
								amount = tabExcel[i][6];
								type = tabExcel[i][7];
								int NB = account.getNBTransaction() + 1;
								account.addNewTransaction(amount, type, Integer.toString(NB));
								Thread.sleep(2000L);
								break;
							case "verificationValueBalance":
								valueBalance = tabExcel[i][3];
								account.verificationValueBalance(valueBalance, rapport);
								break;	
						}
					}
			
			}
			 catch (Exception  e) {
				 System.out.println(e.getMessage());
				 rapport.setMessageResultat(e.getMessage());	
				 rapport.setStatutResultatFailed();
			 }finally{
					System.out.println( "end Scenarii1");
					rapport.setMessageResultat("end Scenarii1");	
					Report(rapport);
				}
		  
	  }

	 
	 
	 
	 //Generation  report
	 public void Report(Report rapport) throws Exception 
		{
		 	System.out.println(rapport.getStatutResultat());
			System.out.println(rapport.getMessageResultat());
			
			String  status= rapport.getStatutResultat();
			String Message = rapport.getMessageResultat();
			Message = Message.replace("'", " ");
			Message = Message.replace("\"", " ");
			
			String idReport = rapport.getIdResultat();
			rapport.sendPostUpdateReport(idReport,status,Message );
			rapport.cloturerReport(idCase);
		}
	@Override
	protected String getDefaultBaseUrl() {
		// TODO Auto-generated method stub
		return null;
	}

}
