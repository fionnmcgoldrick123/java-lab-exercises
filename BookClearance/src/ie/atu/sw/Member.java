package ie.atu.sw;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.UUID;

public record Member(String id, String name, String email, List<Book> borrowedBooks, double[] overdueFines) {

	public Member(String name, String email, List<Book> borrowedBooks, double[] overdueFines) {
		this(UUID.randomUUID().toString(), name, email, borrowedBooks, overdueFines);
	}
	
	public Member {
		requireNonNull(id);
		requireNonNull(name);
		requireNonNull(email);
		requireNonNull(borrowedBooks);
		requireNonNull(overdueFines);
	}
	
}
