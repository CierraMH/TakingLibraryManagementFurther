package Assignment;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String libraryCardNumber;
    List<Book> bookOnLoan;
    
    public User(String name, String libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.bookOnLoan = new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    public String libraryCardNumber(){
        return libraryCardNumber;
    }
    public void addBook(Book book){
        bookOnLoan.add(book);
    }
    public void removeBook(Book book){
        bookOnLoan.remove(book);
    }
    public boolean hasBook(Book book){
        return bookOnLoan.contains(book);
    }
}