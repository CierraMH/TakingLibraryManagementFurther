package Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private int releaseYear;
    private int pages;

    public Book(String title, String author, int releaseYear, int pages) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.pages = pages;
    }

    // List<T> bookInfo = Arrays.asList(title, author, releaseYear, pages);
    List<T> bookInfo = new ArrayList<>();
    bookInfo.stream();
 
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

    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }

}