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
	static ArrayList <CrewMember> theCrew = new ArrayList<CrewMember>();
	static String path = System.getProperty("user.dir")+ "\\src\\Records.txt ";

	public FileManager(){
		
	}
	
	private static void readRecords() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(path));
		try {
		    //break loop if the end of the file, or if there is a blank line
		    for(String line = br.readLine(); line != null; line = br.readLine()) {
		        String[] member = line.split(", ");
		        
		        CrewMember tmp = new CrewMember(member[0], member[1], member[2]);
		        theCrew.add(tmp);
		    }
		} finally {
		    br.close();
		}
	}
	
	public static void saveList(ArrayList<CrewMember> nMembers) throws IOException{
		FileWriter writer = new FileWriter(path); 
		for(int i = 0; i < nMembers.size(); i ++) {
			String str = nMembers.get(i).name + ", " + nMembers.get(i).shirt + ", " + nMembers.get(i).title + "\n";
			  writer.write(str);
			}
			writer.close();
		
		
	}
	
	
	public static ArrayList<CrewMember> initList() throws IOException{
		readRecords();
		return theCrew;
		
	}
	
	


	
}
