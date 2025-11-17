package ie.atu.sw;

import java.util.List;

public record Attendee(String id, String name, String email, List<Ticket> tickets) {
	public Attendee {
		
	}
}
