//This class stores projects data in a text file

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProjectDetails {
		
		public void saveProject(String projectNumber, String projectName, String buildingType, int erfNumber, float feeCharged, 
		float amountPaid, String date) {
			
			try {
				FileWriter writeText = new FileWriter("ProjectFile.txt", true);
				PrintWriter printWriter = new PrintWriter(writeText);
		        printWriter.printf("%s, %s, %s, %s, %s, %s, %s\r\n",projectNumber, projectName, buildingType, erfNumber, feeCharged, amountPaid, date);
		        writeText.close();
		        
		        System.out.println("\nSuccessfully caputured information.\n");
				} catch(IOException e) {
					
					System.out.println("An error occured.");
					e.printStackTrace();
				}
			
		}
		
	}

