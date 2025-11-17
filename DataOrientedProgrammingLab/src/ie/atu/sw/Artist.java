package ie.atu.sw;

public record Artist(String id, String name, Genre genre) {

	enum Genre {BLUES, COUNTRY, FOLK, HIP_HOP,
		JAZZ, METAL, POP, PUNK, ROCK, SOUL}
	
	public Artist {
		
	}
}
