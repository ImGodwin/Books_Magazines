package GodwinE.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "magazine")
public class Magazine {

    @Id
    @GeneratedValue
    private UUID id;
    private int isbn;
    private String title;
    private String yearPublished;
    private int pages;
    private Release releaseStyle;

    @ManyToOne
    @JoinColumn(name = "renter_id")
    private Renter renter;

    public Magazine(){}

    public Magazine(int isbn, String title, String yearPublished, int pages, Release releaseStyle) {
        this.isbn = isbn;
        this.title = title;
        this.yearPublished = yearPublished;
        this.pages = pages;
        this.releaseStyle = releaseStyle;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "id=" + id +
                ", isbn=" + isbn +
                ", title='" + title + '\'' +
                ", yearPublished='" + yearPublished + '\'' +
                ", pages=" + pages +
                ", releaseStyle=" + releaseStyle +
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

    public Release getReleaseStyle() {
        return releaseStyle;
    }

    public void setReleaseStyle(Release releaseStyle) {
        this.releaseStyle = releaseStyle;
    }
}
