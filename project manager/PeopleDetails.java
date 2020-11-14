//This class stores peoples data in a text file

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class PeopleDetails {
	
	public void savePerson(String name, String telephoneNumber, String emailAddress, String physicalAddress) {
		
		try {
			FileWriter writeText = new FileWriter("PeopleFile.txt", true);
			PrintWriter printWriter = new PrintWriter(writeText);
	        printWriter.printf("%s, %s, %s, %s\r\n",name, telephoneNumber, emailAddress, physicalAddress);
	        writeText.close();
	        
	        System.out.println("\nSuccessfully captured information.\n");
			} catch(IOException e) {
				
				System.out.println("An error occured.");
				e.printStackTrace();
			}
		
		
	}

}
