// The program takes input from the user and call save methods to save information regarding
// a person or a project and generate an invoice if the customer didn't pay full fee charged 
// for the project. It also allows a user to update particular information regarding the projects

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Do you want to capture details, update details or view projects? Enter (Capture/Update/view):");
		String action = input.nextLine();
		
		if (action.equalsIgnoreCase("CAPTURE")) {
			
			System.out.println("ENTER PERSONS DETAILS: \n");
				
			System.out.println("Enter your name:");
			String name = input.nextLine();
				
			System.out.println("Enter your contacnt number:");
			String telephoneNumber = input.nextLine();
				
			System.out.println("Enter your email address:");
			String emailAddress = input.nextLine();
				
			System.out.println("Enter your physical address:");
			String physicalAddress = input.nextLine();
				
			PeopleDetails newPerson = new PeopleDetails();
			newPerson.savePerson(name, telephoneNumber, emailAddress, physicalAddress);
			
			System.out.println("\nENTER PROJECTS DETAILS: \n");
			
			System.out.println("Enter project number:");
			String projectNumber = input.nextLine();
			
			System.out.println("Enter project name:");
			String projectName = input.nextLine();
			
			System.out.println("Enter fee charged:");
			float feeCharged = Float.parseFloat(input.nextLine());
				
			System.out.println("Enter amount paid:");
			float amountPaid = Float.parseFloat(input.nextLine());
				
			System.out.println("Enter building type:");
			String buildingType = input.nextLine();
				
			System.out.println("Enter ERF number:");
			int erfNumber = Integer.parseInt(input.nextLine());
				
			System.out.println("Enter due date of the project (dd-MM-yyyy):");
			String date = input.nextLine();
			
			//Converting the input date into Date type and making sure that the date entered is of correct format
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			LocalDate date2 = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String completionDate = date2.format(formatter);
			String nonCompletionDate = "not complete";
				
			try {
				
				Date dueDate = dateFormat.parse(date);
				System.out.println("Due date : " + dueDate);
			}
			catch (ParseException e) {
				
				System.out.println("Incorrect date format");
					
				e.printStackTrace();
			}
				
			ProjectDetails newProject = new ProjectDetails();
			newProject.saveProject(projectNumber, projectName, buildingType, erfNumber, feeCharged, amountPaid, date);
			
			System.out.println("Is the project finalised?(Yes/No):");
			String response = input.nextLine();
			
			if(response.equalsIgnoreCase("Yes")) {
				
				//Saving all the info entered into a text file
				FinaliseProject finalise = new FinaliseProject();
				
				finalise.completedProject(projectNumber, name, telephoneNumber, emailAddress, physicalAddress, projectName, buildingType,
						erfNumber, feeCharged, amountPaid, response, completionDate, date);
				
				DisplayProjects invoice = new DisplayProjects();
				invoice.displayInvoice(feeCharged, amountPaid, projectNumber);
			}
			else if(response.equalsIgnoreCase("No")) {
				
				FinaliseProject finalise = new FinaliseProject();
				
				finalise.completedProject(projectNumber, name, telephoneNumber, emailAddress, physicalAddress, projectName, buildingType,
						erfNumber, feeCharged, amountPaid, response, nonCompletionDate, date);
			}
			else {
				System.out.println("Incorrect input!");
			}
		}
	
		else if(action.equalsIgnoreCase("Update")) {
			
			DisplayProjects allProjects = new DisplayProjects();
			allProjects.displayAllProjects();
			
			System.out.println("\nEnter project number you want to edit:");
			String projectNumber = input.nextLine();
			
			DisplayProjects chosenProject = new DisplayProjects();
			chosenProject.displayChosenProject(projectNumber);
			
			System.out.println("\nEnter updated information: ");
			String updatedInfo = input.nextLine();
			
			System.out.println("\nEnter a number of what you want to update:");
			int updateNumber = input.nextInt();
	
			Modify update = new Modify();
			update.ModifyDetails(updatedInfo, projectNumber, updateNumber, updatedInfo);
		
		}
		else if(action.equalsIgnoreCase("View")) {
			
			DisplayProjects allProjects = new DisplayProjects();
			allProjects.displayAllProjects();
			
			System.out.println("Do you want to view incomplete projects or projects that are past due date?Enter (incomplete/past): ");
			String view = input.nextLine();
			
			if(view.equalsIgnoreCase("incomplete")) {
				
				DisplayProjects incompleteProjects = new DisplayProjects();
				incompleteProjects.displayIncompleteProjects();
			}
			else if(view.equalsIgnoreCase("past")) {
				
				DisplayProjects pastDueDateProjects = new DisplayProjects();
				pastDueDateProjects.displayPastDueDateProjects();
			}
		}
		else {
			System.out.println("Incorrect input!!!");
			}	

		input.close();
		
		System.out.println("\nHave a nice day.");
		
	}

}


