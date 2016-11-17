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
