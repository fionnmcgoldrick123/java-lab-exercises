package ie.atu.sw;

import static java.util.Objects.*;
import java.util.UUID;

public record User(String id, String name, Grade grade, SecurityLevel securityLevel) {

	public User(String name, Grade grade, SecurityLevel securityLevel) {
		this(UUID.randomUUID().toString(), name, grade, securityLevel);
	}
	
	public User {
		requireNonNull(id);
		requireNonNull(name);
		requireNonNull(grade);
		requireNonNull(securityLevel);
	}
}
