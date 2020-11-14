//This class contains methods that allows a user to display relevant information
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class DisplayProjects {
	
	public DisplayProjects() {
		
	}
	
	public void displayAllProjects() {
		
		try{
			
			FileReader projectFile = new FileReader("CompletedProject.txt");
			BufferedReader projectReader = new BufferedReader(projectFile);
			String line="";
			line = projectReader.readLine();
			while(line != null) {
				String[] info = line.split(",");
				System.out.printf("\nProject Number		: %s\n"
		        		+ "Customer Name		:%s\n"
		        		+ "Telephone Number	:%s\n"
		        		+ "Email Address		:%s\n"
		        		+ "Physical Address	:%s\n"
		        		+ "Building Type		:%s\n"
		        		+ "Fee charged 		: R%s\n", info[0], info[1], info[2], info[3], info[4], info[5], info[8]);
				line = projectReader.readLine();
			}
			projectReader.close();
			}catch(Exception ex) {
				System.out.println("Error: " + ex);
			}
	}
	 //Generating an invoice 
	public void displayInvoice(float feeCharged, float amountPaid, String projectNumber) {
		
		System.out.println("\nINVOICE:\n");
		
		if(amountPaid <= feeCharged) {
			File file = new File("CompletedProject.txt");
			Scanner scanner = null;
			try {
				scanner = new Scanner(file);
				while(scanner.hasNext()) {
					String line = scanner.nextLine();
					String[] info = line.split(",");
					int projectNum = Integer.parseInt(projectNumber);
					int index = Integer.parseInt(info[0]);
					if(index == projectNum) {
						
						System.out.printf("\nName				:%s\n"
					        		+ "Telephone Number		:%s\n"
					        		+ "Email Address			:%s\n"
					        		+ "Physical Address		:%s\n"
					        		+ "Outstanding Amount		: R%s\n", info[1], info[2], info[3], info[4], info[10]);
					}
				}
			}
			catch(Exception ex) {
				System.out.println("Error: " + ex);
			}
		}
		else if(amountPaid == feeCharged) {
			
			System.out.println("Amount is fully paid.");
		}
		else {
			System.out.println("Incosistent amounts entered");
		}
		
	}
	public void displayPastDueDateProjects(){
		
		try {
			File file = new File("CompletedProject.txt");
			Scanner scanner = null;
			scanner = new Scanner(file);
			
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dateNow = date.format(formatter);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date todaysDate = dateFormat.parse(dateNow);
			
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] info = line.split(",");
				Date dueDate = dateFormat.parse(info[13]);
				
				if(todaysDate.after(dueDate)) {
					System.out.printf("\nProject Number		: %s\n"
							+ "Customer name		:%s\n"
				        		+ "Telephone Number	:%s\n"
				        		+ "Email Address		:%s\n"
				        		+ "Physical Address	:%s\n"
				        		+ "Project name		:%s\n"
				        		+ "Building type		:%s\n"
				        		+ "ERF number		:%s\n"
				        		+ "Fee charged		: R%s\n"
				        		+ "Amount Paid		: R%s\n"
				        		+ "Outstanding Amount	: R%s\n", info[0], info[1], info[2], info[3], info[4], info[5], info[6],
				        		info[7], info[8], info[9], info[10]);
				}
			}
			scanner.close();
		}catch(Exception e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
		
	}
	
	public void displayIncompleteProjects(){
		
		try {
			File file = new File("CompletedProject.txt");
			Scanner scanner = null;
			scanner = new Scanner(file);
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				if(line.contains("no")) {
					String[] info = line.split(",");
					System.out.printf("\nProject Number		: %s\n"
							+ "Customer name		:%s\n"
				        		+ "Telephone Number	:%s\n"
				        		+ "Email Address		:%s\n"
				        		+ "Physical Address	:%s\n"
				        		+ "Project name		:%s\n"
				        		+ "Building type		:%s\n"
				        		+ "ERF number		:%s\n"
				        		+ "Fee charged		: R%s\n"
				        		+ "Amount Paid		: R%s\n"
				        		+ "Outstanding Amount	: R%s\n", info[0], info[1], info[2], info[3], info[4], info[5], info[6],
				        		info[7], info[8], info[9], info[10]);
				}
			}
			scanner.close();
		}catch(Exception e) {
			
		System.out.println("An error occured.");
		e.printStackTrace();
		}
	}
	
	public void displayChosenProject(String projectNumber) {
		
		File file = new File("CompletedProject.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] info = line.split(",");
				int projectNum = Integer.parseInt(projectNumber);
				int index = Integer.parseInt(info[0]);
				if(index == projectNum) {
					
					System.out.printf("\n1 - Customer name	:%s\n"
				        		+ "2 - Telephone Number	:%s\n"
				        		+ "3 - Email Address	:%s\n"
				        		+ "4 - Physical Address	:%s\n"
				        		+ "5 - Project name	:%s\n"
				        		+ "6 - Building type	:%s\n"
				        		+ "7 - ERF number		:%s\n"
				        		+ "8 - Fee charged		: R%s\n"
				        		+ "9 - Amount Paid		: R%s\n"
				        		+ "10 - Outstanding Amount	: R%s\n", info[1], info[2], info[3], info[4], info[5], info[6],
				        		info[7], info[8], info[9], info[10]);
				}
			}
		}
		catch(Exception ex) {
			System.out.println("Error: " + ex);
		}
	
	}

}
