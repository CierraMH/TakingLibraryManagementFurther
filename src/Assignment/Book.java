package Assignment;

import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private int pages;
    private String category;
    private boolean isOnLoan;
    private LocalDate dueDate;

    public Book(String title, String author, int publicationYear, int pages) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.pages = pages;
    }
    public Book(String title, String author, int publicationYear, int pages, String category) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.category = category;
        this.isOnLoan = false;

        
    }
 
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isOnLoan() {
        return isOnLoan;
    }
    public void setIsOnLoan(boolean isOnLoan) {
        this.isOnLoan = isOnLoan;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    @Override
    public String toString(){
        return "Book Information: Title " + title + ", Author " + author + ", Publication year " + publicationYear + ", Number of pages " + pages + ". Is the Book in the Fiction or Non-Fiction category: " + category + ".\n";
    }

}