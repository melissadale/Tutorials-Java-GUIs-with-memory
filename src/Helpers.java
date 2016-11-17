/**
 * This Project is created by Melissa for the purposes of demonstrating
 * how to code a Java GUI with a "memory"
 * 
 * This class is a simple class with helper functions. At this point in time, 
 * it just performs "findMember" which returns a member object given a name and an 
 * ArrayList to look through. 
 * 
 * This was coded November 2016
 */
import java.util.ArrayList;

public class Helpers {
	public Helpers(){
		
	}
	public static CrewMember findMember(String name, ArrayList<CrewMember> theCrew){
		String placeholder = "NA";
		CrewMember tmp = new CrewMember(placeholder, placeholder, placeholder);
		
		for(int i = 0; i<theCrew.size(); i++){
			if(theCrew.get(i).name.equals(name))
				tmp = theCrew.get(i);
		}
		
		
		return tmp;
	}
	
}
