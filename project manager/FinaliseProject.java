//This class generate an invoice if the fee charged is not fully paid and displays it
//with customers details

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FinaliseProject {

	public void completedProject(String projectNumber, String name, String telephoneNumber, String emailAddress,
			String physicalAddress, String projectName, String buildingType, int erfNumber, float feeCharged, 
			float amountPaid, String response, String completionDate, String date) {
		
			
		double outstandingAmount = feeCharged - amountPaid;
			
		try {
			FileWriter writeText = new FileWriter("CompletedProject.txt", true);
			PrintWriter printWriter = new PrintWriter(writeText);
			printWriter.printf("%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s , %s, %s, %s\r\n", projectNumber, name, telephoneNumber, 
					emailAddress, physicalAddress, projectName, buildingType, erfNumber, feeCharged, amountPaid, outstandingAmount, 
					response, completionDate, date );
		       writeText.close();
			} 
			catch(IOException e) {
					
				System.out.println("An error occured.");
				e.printStackTrace();
			}	
	}
}
