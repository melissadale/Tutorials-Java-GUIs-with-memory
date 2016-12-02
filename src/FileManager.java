/**
 * This Project is created by Melissa for the purposes of demonstrating
 * how to code a Java GUI with a "memory"
 * 
 * This class reads from and writes to our data file. 
 * 
 * This was coded November 2016
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
	// This is the path to our data file - This is as close to "relative" path 
	// Java has to offer, this *may* cause issues for you. If so, review
	// absolute vs relative paths 
	static String path = System.getProperty("user.dir")+ "\\src\\Records.txt "; 
	


	public FileManager(){
		
	}
	
	public static ArrayList<CrewMember> initList() throws IOException{
		// This is the important part of the whole program - THE LIST OF EMPLOYEES
		ArrayList <CrewMember> theCrew = new ArrayList<CrewMember>();
		
		BufferedReader br = new BufferedReader(new FileReader(path));
		
		try {
		    // For each line in the data file, read the line to string "line",
			// continue until the end of the file,
			// increment by proceeding to the next line
		    for(String line = br.readLine(); line != null; line = br.readLine()) {
		    	
		    	// each variable is separated by a comma, so let's split the line on that
		        String[] member = line.split(", ");
		        
		        // member is now a list with 3, variables: name, shirt, rank
		        CrewMember tmp = new CrewMember(member[0], member[1], member[2]);
		        theCrew.add(tmp);
		    }
		} finally {
		    br.close();
		}
		
		return theCrew;
	}
	
	public static void saveList(ArrayList<CrewMember> nMembers) throws IOException{
		FileWriter writer = new FileWriter(path); 
		for(int i = 0; i < nMembers.size(); i ++) {
			// we format the member information to a string with comma separated values 
			// (EXACTLY the same format that we read in)
			String line_out = nMembers.get(i).name + ", " + nMembers.get(i).shirt + ", " + nMembers.get(i).title + "\n";
			  writer.write(line_out);
			}
			writer.close();
	}	


	
}
