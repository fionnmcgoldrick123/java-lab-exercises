package ie.atu.sw;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class BookSystem {
	
	public record BorrowResult(Member member, Book book, Librarian librarian) {}

	public static BorrowResult borrow(BookOperation.Borrow b) {
		return borrow(b.member(), b.book(), b.librarian());
	}
	
	public static BorrowResult borrow(Member member, Book book, Librarian librarian) {
		// For borrow, decrement count, add to book borrow history, add to member borrowed books
		
		System.out.println("ALERT THE LIBRARIAN FOR APPROVAL: " + librarian.name());

		int newCount = book.availableCopies() - 1;
		
		var newBookBorrowHistory = new HashMap<>(book.borrowingHistory());
		newBookBorrowHistory.put(member, LocalDate.now());
		
		var newMemberBorrowHistory = new ArrayList<Book>(member.borrowedBooks());
		newMemberBorrowHistory.add(book);
		
		book = new Book(book.id(), book.title(), book.author(), book.isbn(), newCount, newBookBorrowHistory);
		member = new Member(member.id(), member.name(), member.email(), newMemberBorrowHistory, member.overdueFines());
		
		
		return new BorrowResult(member, book, librarian);
	}
	
	public static void returnBook(BookOperation.Borrow b) {
		returnBook(b.member(), b.book(), b.librarian());
	}
	
	public static BorrowResult returnBook(Member member, Book book, Librarian librarian) {
		// For return, increment count

		int newCount = book.availableCopies() + 1;
		
		book = new Book(book.id(), book.title(), book.author(), book.isbn(), newCount, book.borrowingHistory());
		
		return new BorrowResult(member, book, librarian);
	}
}
