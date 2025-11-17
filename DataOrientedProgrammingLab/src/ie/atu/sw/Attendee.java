package ie.atu.sw;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.UUID;

public record Attendee(String id, String name, String email, List<Ticket> tickets) {
	
	public Attendee(String name, String email, List<Ticket> tickets) {
		this(UUID.randomUUID().toString(), name, email, tickets);
	}
	
	public Attendee {
		requireNonNull(id);
		requireNonNull(name);
		requireNonNull(email);
	}
}
