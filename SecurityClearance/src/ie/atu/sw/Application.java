package ie.atu.sw;

import static java.util.Objects.*;
import java.util.UUID;

public record Application(String id, User user, SecurityLevel securityLevel, String reason, Status status, Reviewer reviewer) {
	public Application(User user, SecurityLevel securityLevel, String reason, Status status, Reviewer reviewer) {
		this(UUID.randomUUID().toString(), user, securityLevel, reason, status, reviewer);
	}
	
	public Application {
		requireNonNull(id);
		requireNonNull(user);
		requireNonNull(securityLevel);
		requireNonNull(reason);
		requireNonNull(status);
		requireNonNull(reviewer);
	}
}
