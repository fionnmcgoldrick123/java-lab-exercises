package ie.atu.sw;

import java.util.HashMap;
import java.util.List;

public class Runner {
	public static void main(String[] args) {
	
		var member = new Member("Paul", "john@mail.com", List.of(), new double[]{}); 
		var book = new Book("Title", "author", "1234", 1, new HashMap<>()); 
		var librarian = new Librarian("John", "string", List.of(book)); 
		
		var borrowResult = BookSystem.borrow(new BookOperation.Borrow(member, book, librarian)); 
		
		System.out.println("----- ORIGINALS -----");
		System.out.println(member);
		System.out.println(book);
		System.out.println(librarian);
		
		
		System.out.println("\n\n----- AFTER BORROW -----");
		System.out.println(borrowResult.member());
		System.out.println(borrowResult.book());
		System.out.println(borrowResult.librarian());
		
	}
}
