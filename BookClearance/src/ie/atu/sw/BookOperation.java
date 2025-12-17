package ie.atu.sw;

import static java.util.Objects.*;

import java.util.Arrays;

public interface BookOperation {
	record Borrow(Member member, Book book, Librarian librarian) implements BookOperation {
		
		public Borrow {
			requireNonNull(member);
			requireNonNull(book);
			requireNonNull(librarian);
			
			if (Arrays.stream(member.overdueFines()).sum() >= 20f) {
				throw new IllegalStateException("Overdue fines on account.");
			}
			if (book.availableCopies() <= 0) {
				throw new IllegalStateException("The book is unavailable.");
			}
			if (!librarian.managedBooks().contains(book)) {
				throw new IllegalStateException("The librarian does not manage this book.");
			}
		}
		
	};
	
	record Return(Member member, Book book, Librarian librarian) implements BookOperation {
		public Return {
			requireNonNull(member);
			requireNonNull(book);
			requireNonNull(librarian);
			
			if (!librarian.managedBooks().contains(book)) {
				throw new IllegalStateException("The librarian does not manage this book.");
			}
		}
	};
}
