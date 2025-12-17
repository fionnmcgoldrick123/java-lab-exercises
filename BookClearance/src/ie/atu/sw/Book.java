package ie.atu.sw;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

public record Book(String id, String title, String author, String isbn, int availableCopies, Map<Member, LocalDate> borrowingHistory) {
	
	public Book(String title, String author, String isbn, int availableCopies, Map<Member, LocalDate> borrowingHistory) {
		this(UUID.randomUUID().toString(), title, author, isbn, availableCopies, borrowingHistory);
	}
	
	public Book {
		requireNonNull(id);
		requireNonNull(title);
		requireNonNull(author);
		requireNonNull(isbn);
		requireNonNull(availableCopies);
		requireNonNull(borrowingHistory);
	}
	
	
	
}
