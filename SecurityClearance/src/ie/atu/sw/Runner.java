package ie.atu.sw;

import java.util.List;

public class Runner {
	public static void main(String[] args) {
	
		var user = new User("Gamer 1", new Grade(1), SecurityLevel.TOP_SECRET); 
		var reviewer = new Reviewer("John", "string", List.of()); 
		
		var application = ClearanceSystem.request(new ClearanceOperation.Request(user, SecurityLevel.CONFIDENTIAL, "reason", reviewer)); 
		
		System.out.println(application);
		
	}
}
