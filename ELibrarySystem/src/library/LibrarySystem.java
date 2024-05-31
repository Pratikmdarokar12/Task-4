package library;

import java.util.*;

public class LibrarySystem {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Book> books = new HashMap<>();
    private Map<String, String> digitalResources = new HashMap<>();

    // User Authentication
    public String register(String username, String password) {
        if (users.containsKey(username)) {
            return "Username already exists.";
        }
        users.put(username, new User(username, password));
        return "User registered successfully.";
    }

    public String login(String username, String password) {
        if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
            return "Login successful.";
        }
        return "Invalid username or password.";
    }

    // Book Management
    public String addBook(String bookId, String title, String author, String category) {
        if (books.containsKey(bookId)) {
            return "Book ID already exists.";
        }
        books.put(bookId, new Book(bookId, title, author, category));
        return "Book added successfully.";
    }

    public List<Book> searchBooks(String query) {
        List<Book> results = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) || 
                book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    // Borrowing and Returning Books
    public String borrowBook(String username, String bookId) {
        if (!books.containsKey(bookId)) {
            return "Book ID does not exist.";
        }
        Book book = books.get(bookId);
        if (book.isBorrowed()) {
            return "Book is already borrowed.";
        }
        book.setBorrowed(true);
        book.setBorrower(username);
        return "Book borrowed successfully.";
    }

    public String returnBook(String username, String bookId) {
        if (!books.containsKey(bookId)) {
            return "Book ID does not exist.";
        }
        Book book = books.get(bookId);
        if (!book.isBorrowed()) {
            return "Book is not borrowed.";
        }
        if (!book.getBorrower().equals(username)) {
            return "This book was not borrowed by you.";
        }
        book.setBorrowed(false);
        book.setBorrower(null);
        return "Book returned successfully.";
    }

    // Managing Digital Resources
    public String addDigitalCopy(String bookId, String digitalCopy) {
        if (!books.containsKey(bookId)) {
            return "Book ID does not exist.";
        }
        digitalResources.put(bookId, digitalCopy);
        return "Digital copy added successfully.";
    }

    public String accessDigitalCopy(String bookId) {
        if (!digitalResources.containsKey(bookId)) {
            return "No digital copy available.";
        }
        return digitalResources.get(bookId);
    }
}
