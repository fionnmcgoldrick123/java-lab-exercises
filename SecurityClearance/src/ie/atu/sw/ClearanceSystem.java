package ie.atu.sw;

import java.util.ArrayList;

public class ClearanceSystem {

	
	public static Application request(ClearanceOperation.Request req) {
		return request(req.user(), req.securityLevel(), req.reason(), req.reviewer());
	}
	
	public static Application request(User user, SecurityLevel securityLevel, String reason, Reviewer reviewer) {
		Application application = new Application(user, securityLevel, reason, Status.PENDING, reviewer);
		
		var temp = new ArrayList<>(reviewer.applications());
		temp.add(application);
		
		// Add new list to reviewer -> same Object id, new list.
		reviewer = new Reviewer(reviewer.id(), reviewer.name(), reviewer.string(), new ArrayList<Application>(temp));
		
		return application;
	}
	
	public static Status process(ClearanceOperation.Process p) {
		Status status = process(p.application(), p.securityLevel(), p.reviewer());
		update(new ClearanceOperation.Update(p.application().user(), p.application().securityLevel()));
		return status;
	}

	public static Status process(Application application, SecurityLevel securityLevel, Reviewer reviewer) {
		// Mock valid reason
		if (application.reason().length() >= 50) {
			return Status.APPROVED;
		}
		return Status.REJECTED;
	}
	
	public static void update(ClearanceOperation.Update u) {
		update(u.user(), u.securityLevel());
	}	
	
	public static void update(User user, SecurityLevel securityLevel) {
		
		// Update user with same id but new security level
		user = new User(user.id(), user.name(), user.grade(), securityLevel);
	}
	
}
