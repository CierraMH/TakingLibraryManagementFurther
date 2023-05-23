package Assignment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Library implements Printable{

    List<Book> bookInfo;
    List<User> users;

    public Library(){
//creates new books
        this.bookInfo = new ArrayList<>();
        this.users = new ArrayList<>();
    }
//add book
    public void addBook(Book book){
        bookInfo.add(book);
    }
//remove book by title
    public void removeBook(String title){
        for(Book book : bookInfo){
            if(book.getTitle().equals(title)){
                bookInfo.remove(book);
            }
        };
    }
//get all books of a certain pubyear
    public void specificYear(int year){
        Stream<Book> streamBook = bookInfo.stream();
        List<Book> pubYear = streamBook
        .filter(bookPubInfo -> bookPubInfo.getPublicationYear() == year)
        .collect(Collectors.toList());
        // System.out.println(pubYear.size());
        pubYear.forEach(System.out :: println);
    }
//get all books of a certain author
public void specificAuthor(String author){
    Stream<Book> streamBook = bookInfo.stream();
    List<Book> certainAuthor = streamBook
    .filter(bookAuthorInfo -> bookAuthorInfo.getAuthor().equals(author))
    .collect(Collectors.toList());
    certainAuthor.forEach(System.out :: println);
}
//get the book with the most pages
public void mostPages(){
    Optional<Book> streamBook = bookInfo.stream()
    .max(Comparator.comparing(Book :: getPages));
    streamBook.ifPresent(book -> System.out.println(book.getPages()));
}
//get the books with a certain number of pages
public void nPages(int n){
    Stream<Book> streamBook = bookInfo.stream();
    List<Book> pages = streamBook
    .filter(bookpages -> bookpages.getPages() >= n )
    .collect(Collectors.toList());
    pages.forEach(System.out :: println);
}
//sorted alphabetically
public void alphabeticallySorted(){
Collections.sort(bookInfo, new Comparator<Book>(){
    public int compare(Book b1, Book b2){
        return b1.getTitle().compareToIgnoreCase(b2.getTitle());
    }
} );
System.out.println(displayBook());
}
//displays book within my arraylist
public List<Book> displayBook(){
    return bookInfo;
}
//book category
public void fictionOrNot(String category){
    Predicate<Book> fictionOrNot = bookInfo -> bookInfo.getCategory().equals(category);
    if(fictionOrNot.equals("Yes")){
        System.out.println("Fiction");
    } else {
        System.out.println("Non-Fiction");
    }
}
//checks if the book is on loan
public void loanBook(User user, Book book){
    if (book.isOnLoan()){
        System.out.println("This book is already on loan.");
    } else {
        book.setIsOnLoan(true);
        user.addBook(book);
        book.setDueDate(LocalDate.now().plusWeeks(2));
        System.out.println( book.getTitle() + " is loaned out to " + user.getName());
    }
}
//checks if the book was returned
public void returnBook(User user, Book book){
    if (user.hasBook(book)){
        user.removeBook(book);
        long daysOverdue = ChronoUnit.DAYS.between(book.getDueDate(), LocalDate.now());
        double lateFee = lateFee(daysOverdue);
        book.setIsOnLoan(false);
        System.out.println( book.getTitle() + " was returned from loan by " + user.getName() + " you are  " + daysOverdue + " -days late and owe: $" + lateFee + ".");
    } else {
        System.out.println("The book is not on loan and can be loaned out.");
    }
}
//register user
public void registerUser(String name, String libraryCardNumber){
    User user = new User(name, libraryCardNumber);
    users.add(user);
    System.out.println( name + "was just registered." );
}
//accruing late fee charge
private double lateFee(long daysOverdue){
    Function<Long, Double> lateFees = (days) -> days * .25; 
    return lateFees.apply(daysOverdue);
}
    @Override
    public void print() {
        System.out.println(toString());
    }
}