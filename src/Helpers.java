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
