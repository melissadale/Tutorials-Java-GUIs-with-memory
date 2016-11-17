/**
 * This Project is created by Melissa for the purposes of demonstrating
 * how to code a Java GUI with a "memory"
 * 
 * This class is test box to examine the methods in FileManager.java
 * and CrewMember.java - or really any classes.  
 * 
 * This was coded November 2016
 */
import java.io.IOException;
import java.util.ArrayList;

public class Driver {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CrewMember test1 = new CrewMember("Me", "Blue", "Admiral");
		System.out.println(test1.name);
		
		FileManager testReader = new FileManager();
		ArrayList<CrewMember> testCrews = testReader.initList();
		System.out.println(testCrews.get(0).name);
		
		CrewMember found = Helpers.findMember("Spock", testCrews);
		System.out.println(found.shirt);
	}

		
}
