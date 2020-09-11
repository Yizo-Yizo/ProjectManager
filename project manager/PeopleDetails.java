//This class stores peoples data in a text file
package Task7;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class PeopleDetails {
	
	String name;
	String telephoneNumber;
	String emailAddress;
	String physicalAddress;
	
	public PeopleDetails(String name, String telephoneNumber, String emailAddress,
			String physicalAddress) {
		
		this.name = name;
		this.telephoneNumber = telephoneNumber;
		this.emailAddress = emailAddress;
		this.physicalAddress = physicalAddress;
		
	}
	
	public void savePerson(String name, String telephoneNumber, String emailAddress, String physicalAddress) {
		
		try {
			FileWriter writeText = new FileWriter("PeopleFile.txt");
			PrintWriter printWriter = new PrintWriter(writeText);
	        printWriter.printf("%s, %s, %s, %s",name, telephoneNumber, emailAddress, physicalAddress);
	        writeText.close();
	        
	        System.out.println("\nSuccessfully captured information.\n");
			} catch(IOException e) {
				
				System.out.println("An error occured.");
				e.printStackTrace();
			}
		
		
	}

}
