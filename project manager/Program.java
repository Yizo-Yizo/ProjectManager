// The program takes input from the user and call save methods to save information regarding
// a person or a project and generate an invoice if the customer didn't pay full fee charged 
// for the project
package Task7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("Do you want to capture details or update details? Enter (Capture/Update):");
		String action = input.nextLine();
		String upperCaseAction = action.toUpperCase();
		
		if (upperCaseAction.equals("CAPTURE")) {
			
			System.out.println("ENTER PERSONS DETAILS: \n");
				
			System.out.println("Enter your name:");
			String name = input.nextLine();
				
			System.out.println("Enter your contacnt number:");
			String telephoneNumber = input.nextLine();
				
			System.out.println("Enter your email address:");
			String emailAddress = input.nextLine();
				
			System.out.println("Enter your physical address:");
			String physicalAddress = input.nextLine();
				
			PeopleDetails newPerson = new PeopleDetails(name, telephoneNumber, emailAddress, physicalAddress);
			newPerson.savePerson(name, telephoneNumber, emailAddress, physicalAddress);
			
			System.out.println("\nENTER PROJECTS DETAILS: \n");
			
			System.out.println("Enter project name:");
			String projectName = input.nextLine();
			
			System.out.println("Enter fee charged:");
			float feeCharged = Float.parseFloat(input.nextLine());
				
			System.out.println("Enter amount paid:");
			float amountPaid = Float.parseFloat(input.nextLine());
			
			System.out.println("Enter project number:");
			String projectNumber = input.nextLine();
				
				
			System.out.println("Enter building type:");
			String buildingType = input.nextLine();
				
			System.out.println("Enter ERF number:");
			int erfNumber = Integer.parseInt(input.nextLine());
				
			System.out.println("Enter due date of the project:");
			String date1 = input.nextLine();
				
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date date = null;
				
			try {
					
				date = dateFormat.parse(date1);
			}catch (ParseException e) {
					
				e.printStackTrace();
			}
				
			ProjectDetails newProject = new ProjectDetails(projectNumber, projectName, buildingType, erfNumber, feeCharged, amountPaid, date);
			newProject.saveProject(projectNumber, projectName, buildingType, erfNumber, feeCharged, amountPaid, date);
			
			System.out.println("Do you want to finalise the project?(Yes/No):");
			String response = input.nextLine();
			String uppercaseResponse = response.toUpperCase();
			
			if(uppercaseResponse.equals("YES")) {
				
				FinaliseProject finalise = new FinaliseProject(name, telephoneNumber, emailAddress, physicalAddress, feeCharged, amountPaid);
				finalise.completedProject(name, telephoneNumber, emailAddress, physicalAddress, feeCharged, amountPaid);
			}
		}
	
		else if(upperCaseAction.equals("UPDATE")) {
			
			System.out.println("UPDATE PERSONS DETAILS OR PRESS ENTER:\n");
			
			System.out.println("Enter content you want to edit:");
			String currentContent = input.nextLine();
				
			System.out.println("Enter content you want to edit with:");
			String updatedContent = input.nextLine();
				
			Modify update = new Modify();
			update.ModifyPeopleDetails(currentContent, updatedContent);
				
			System.out.println("UPDATE PROJECTS DETAILS OR PRESS ENTER\n");
				
			System.out.println("Enter content you want to edit:");
			String currentContents = input.nextLine();
				
			System.out.println("Enter content you want to edit with:");
			String updatedContents = input.nextLine();
				
			Modify updates = new Modify();
			updates.ModifyProjectDetails(currentContents, updatedContents);
		}
	
		else {
			System.out.println("Incorrect input!!!");
			}	

		input.close();
	}
}


