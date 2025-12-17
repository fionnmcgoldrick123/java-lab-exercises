package ie.atu.sw;

import static java.util.Objects.requireNonNull;
import java.util.List;

import java.util.UUID;

public record Reviewer(String id, String name, String string, List<Application> applications) {
	
	public Reviewer(String name, String string, List<Application> applications) {
		this(UUID.randomUUID().toString(), name, string, applications);
	}
	
	public Reviewer {
		requireNonNull(id);
		requireNonNull(name);
		requireNonNull(string);
		requireNonNull(applications);
	}
}
