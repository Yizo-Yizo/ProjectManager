//This class stores projects data in a text file
package Task7;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ProjectDetails {
		
		String projectNumber;
		String projectName;
		String buildingType;
		int erfNumber;
		float feeCharged;
		float amountPaid;
		Date date;
		
		public ProjectDetails(String projectNumber, String projectName, String buildingType, int erfNumber, 
				float feeCharged, float amountPaid, Date date) {
			
			this.projectNumber = projectNumber;
			this.projectName = projectName;
			this.buildingType = buildingType;
			this.erfNumber = erfNumber;
			this.feeCharged = feeCharged;
			this.amountPaid	= amountPaid;
			this.date = date;
			
		}
		
		public void saveProject(String projectNumber, String projectName, String buildingType, int erfNumber, float feeCharged, float amountPaid, Date date) {
			
			try {
				FileWriter writeText = new FileWriter("ProjectFile.txt");
				PrintWriter printWriter = new PrintWriter(writeText);
		        printWriter.printf("%s, %s, %s, %s, %s, %s, %s",projectNumber, projectName, buildingType, erfNumber, feeCharged, amountPaid, date);
		        writeText.close();
		        
		        System.out.println("\nSuccessfully caputured information.\n");
				} catch(IOException e) {
					
					System.out.println("An error occured.");
					e.printStackTrace();
				}
			
		}
		
	}

