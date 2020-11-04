//This class modifies used to modify either person or project

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Modify {
	ArrayList<String> lines = new ArrayList<String>();
    String line = null;
    
public void ModifyPeopleDetails(String currentContent, String updatedContent) {
    	
    	try
        {
            File pfile = new File("PeopleFile.txt");
            FileReader contentFile = new FileReader(pfile);
            BufferedReader contents = new BufferedReader(contentFile);
            
            while ((line = contents.readLine()) != null)
            {
                if (line.contains(currentContent))
                    line = line.replace(currentContent, updatedContent);
                lines.add(line);
            }
            contents.close();
            contentFile.close();
            
            FileWriter fileWriter = new FileWriter(pfile);
            BufferedWriter out = new BufferedWriter(fileWriter);
            for(String s: lines) {
            	out.write(s);
            out.flush();
            }
            out.close();
        }
           
        catch (Exception ex)
        {
			System.out.println("Error occured!")
            ex.printStackTrace();
        }
    	
    	try{
			FileReader people = new FileReader("PeopleFile.txt");
			BufferedReader peopleReader = new BufferedReader(people);
			String person="";
			person = peopleReader.readLine();
			System.out.println(person);
			peopleReader.close();
			
			System.out.println("Successfully caputured information.");
			}catch(Exception ex) {
				System.out.println("Error: " + ex);
			} 
    }

	public void ModifyProjectDetails(String currentContents, String updatedContents) {
	
		try
		{
			File pfile = new File("ProjectFile.txt");
			FileReader contentFile = new FileReader(pfile);
			BufferedReader contents = new BufferedReader(contentFile);
        
			while ((line = contents.readLine()) != null)
			{
				if (line.contains(currentContents))
					line = line.replace(currentContents, updatedContents);
				lines.add(line);
			}
			contents.close();
			contentFile.close();
        
			FileWriter fileWriter = new FileWriter(pfile);
			BufferedWriter out = new BufferedWriter(fileWriter);
			for(String s: lines) {
				out.write(s);
				out.flush();
			}
			out.close();
		}
       
		catch (Exception ex)
		{
			System.out.println("Error occured!")
			ex.printStackTrace();
		}
	
		try{
			FileReader people = new FileReader("ProjectFile.txt");
			BufferedReader peopleReader = new BufferedReader(people);
			String person="";
			person = peopleReader.readLine();
			System.out.println(person);
			peopleReader.close();
		
			System.out.println("Successfully updated information.");
			}catch(Exception ex) {
				System.out.println("Error: " + ex);
			} 
		}
}
