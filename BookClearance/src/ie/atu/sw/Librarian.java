package ie.atu.sw;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.UUID;

public record Librarian(String id, String name, String email, List<Book> managedBooks) {

	public Librarian(String name, String email, List<Book> managedBooks) {
		this(UUID.randomUUID().toString(), name, email, managedBooks);
	}
	
	public Librarian {
		requireNonNull(id);
		requireNonNull(name);
		requireNonNull(email);
		requireNonNull(managedBooks);
	}
}
