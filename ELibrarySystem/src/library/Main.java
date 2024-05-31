package library;

import java.util.*;

public class Main {
    private static LibrarySystem librarySystem = new LibrarySystem();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Add Book");
            System.out.println("4. Search Books");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Add Digital Copy");
            System.out.println("8. Access Digital Copy");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    register();
                    break;
                case "2":
                    login();
                    break;
                case "3":
                    addBook();
                    break;
                case "4":
                    searchBooks();
                    break;
                case "5":
                    borrowBook();
                    break;
                case "6":
                    returnBook();
                    break;
                case "7":
                    addDigitalCopy();
                    break;
                case "8":
                    accessDigitalCopy();
                    break;
                case "9":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.println(librarySystem.register(username, password));
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.println(librarySystem.login(username, password));
    }

    private static void addBook() {
        System.out.print("Enter book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book category: ");
        String category = scanner.nextLine();
        System.out.println(librarySystem.addBook(bookId, title, author, category));
    }

    private static void searchBooks() {
        System.out.print("Enter search query: ");
        String query = scanner.nextLine();
        List<Book> results = librarySystem.searchBooks(query);
        for (Book book : results) {
            System.out.println("ID: " + book.getBookId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Category: " + book.getCategory());
        }
    }

    private static void borrowBook() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter book ID: ");
        String bookId = scanner.nextLine();
        System.out.println(librarySystem.borrowBook(username, bookId));
    }

    private static void returnBook() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter book ID: ");
        String bookId = scanner.nextLine();
        System.out.println(librarySystem.returnBook(username, bookId));
    }

    private static void addDigitalCopy() {
        System.out.print("Enter book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter digital copy (link or file): ");
        String digitalCopy = scanner.nextLine();
        System.out.println(librarySystem.addDigitalCopy(bookId, digitalCopy));
    }

    private static void accessDigitalCopy() {
        System.out.print("Enter book ID: ");
        String bookId = scanner.nextLine();
        System.out.println(librarySystem.accessDigitalCopy(bookId));
    }
}
