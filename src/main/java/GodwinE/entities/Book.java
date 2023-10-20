package GodwinE.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue
    private UUID id;
    private int isbn;
    private String title;
    private String yearPublished;
    private int pages;
    private String author;
    private String genre;

    @ManyToOne
    @JoinColumn(name = "renter_id")
    private Renter renter;


    public Book(){}
    public Book(int isbn, String title, String yearPublished, int pages, String author, String genre) {
        this.isbn = isbn;
        this.title = title;
        this.yearPublished = yearPublished;
        this.pages = pages;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", isbn=" + isbn +
                ", title='" + title + '\'' +
                ", yearPublished='" + yearPublished + '\'' +
                ", pages=" + pages +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
