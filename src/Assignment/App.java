package Assignment;

import java.io.ObjectInputStream.GetField;
import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {
        Library library = new Library();

        Book newBook = new Book("Green Eggs and Ham", "Dr.Seuss", 1960, 36, "Fiction");
        library.bookInfo.add(newBook);
        Book newBook1 = new Book("One Fish, Two Fish, Red Fish, Blue Fish", "Dr.Seuss", 1960, 73, "Fiction");
        library.bookInfo.add(newBook1);
        Book newBook2 = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997, 223, "Fiction");
        library.bookInfo.add(newBook2);
        User newUser = new User("Cierra", "1234");
        User newUser1 = new User("Tommy", "2345");

        library.specificYear(1960);
        library.specificAuthor("Dr.Seuss");
        library.mostPages();
        library.nPages(40);
        library.alphabeticallySorted();
        System.out.println("");
        library.fictionOrNot("No");
        library.loanBook(newUser, newBook);
        library.loanBook(newUser1, newBook1);
        System.out.println("");
        library.returnBook(newUser, newBook);
    }
}
