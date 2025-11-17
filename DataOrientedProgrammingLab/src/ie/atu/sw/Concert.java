package ie.atu.sw;

import java.time.LocalDateTime;

public record Concert(String id, Artist artist, LocalDateTime date, Venue venue) {

	public Concert{
		
	}
}
