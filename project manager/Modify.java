//This class modifies information of a chosen project

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Modify {
    
public void ModifyDetails(String updatedContent, String projectNumber, int updateNumber, String updatedInfo) {
    	
    	try
        {
			FileInputStream fileStream = new FileInputStream("CompletedProject.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream));
			String line;
			StringBuilder fileContent = new StringBuilder();
            
            while((line = reader.readLine()) != null) {
				
				String info[] = line.split(",");
				
				if(info.length > 0){
					//Getting specific line in a text file and modifying information
					if(info[0].equals(projectNumber)) {
						
						info[updateNumber] = updatedInfo;
						String newLine = info[0] + "," + info[1] + "," + info[2] + "," + info[3] + "," + info[4] + "," + info[5] + "," + info[6] + "," + info[7] 
								+ "," + info[8] + "," + info[9] + "," + info[10] + "," + info[11] + "," + info[12] + "," + info[13]; 
						
						fileContent.append(newLine);
						fileContent.append("\n");
						
					}
					else {
						
						fileContent.append(line);
						fileContent.append("\n");
					}
				}
			}
			//Override with updated content
			FileWriter writer = new FileWriter("CompletedProject.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write(fileContent.toString());
			bufferedWriter.close();
			reader.close();
		}
        catch (Exception ex)
        {
			System.out.println("Error occured!");
            ex.printStackTrace();
        }
	}
}
