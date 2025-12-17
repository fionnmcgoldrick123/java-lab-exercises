package ie.atu.sw;

import static java.util.Objects.*;

public interface ClearanceOperation {
	record Request(User user, SecurityLevel securityLevel, String reason, Reviewer reviewer) implements ClearanceOperation {
		
		public Request {
			requireNonNull(user);
			requireNonNull(securityLevel);
			requireNonNull(reason);
			requireNonNull(reviewer);
			
			if (user.securityLevel() == securityLevel) {
				throw new IllegalStateException("The user already has the requested security level.");
			}
			
			switch (securityLevel) {
				case CONFIDENTIAL:
					if (user.securityLevel() == SecurityLevel.SECRET || user.securityLevel() == SecurityLevel.TOP_SECRET) {
						throw new IllegalStateException("The requested security level must be greater than current level.");
					}
					break;
				case SECRET:
					if (user.securityLevel() == SecurityLevel.CONFIDENTIAL) {
						throw new IllegalStateException("The requested security level must be greater than current level.");
					}
					break;
				case TOP_SECRET:
					if (user.securityLevel() == SecurityLevel.CONFIDENTIAL || user.securityLevel() == SecurityLevel.SECRET) {
						throw new IllegalStateException("The requested security level must be greater than current level.");
					}
					break;
				default:
					break;
			}
		}
		
	};
	
	record Process(Application application, SecurityLevel securityLevel, Reviewer reviewer) implements ClearanceOperation {
		public Process {
			requireNonNull(application);
			requireNonNull(securityLevel);
			requireNonNull(reviewer);
			
			if (application.status() != Status.PENDING) {
				throw new IllegalStateException("The must be pending for processing.");
			}
		}
	};
	
	record Update(User user, SecurityLevel securityLevel) implements ClearanceOperation {
		public Update {
			requireNonNull(user);
			requireNonNull(securityLevel);
		}
	};
}
