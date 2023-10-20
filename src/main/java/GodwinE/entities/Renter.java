package GodwinE.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("renter")
public class Renter extends User {


    private String itemRented;
    private LocalDate dateRented;
    private LocalDate returnDate;
    private LocalDate dateReturned;

    @OneToMany(mappedBy = "renter")
    @OrderBy("title ASC")
    private List<Book> book;

    @OneToMany(mappedBy = "renter")
    @OrderBy("title ASC")
    private List<Magazine> magazine;

    public Renter(String s, String string, Date birthday, int i, String title, LocalDate yesterday, LocalDate value){}

    public Renter(String name, String surname, String dateOfBirth, String cardNum,
                  String itemRented, LocalDate dateRented, LocalDate returnDate, LocalDate dateReturned) {
        super(name, surname, dateOfBirth, cardNum);
        this.itemRented = itemRented;
        this.dateRented = dateRented;
        this.returnDate = returnDate;
        this.dateReturned = dateReturned;
    }

    @Override
    public String toString() {
        return "Renter{" +
                ", itemRented='" + itemRented + '\'' +
                ", dateRented=" + dateRented +
                ", returnDate=" + returnDate +
                ", dateReturned=" + dateReturned +
                '}';
    }


    public String getitemRented() {
        return itemRented;
    }

    public void setitemRented(String itemRented) {
        this.itemRented = itemRented;
    }

    public LocalDate getDateRented() {
        return dateRented;
    }

    public void setDateRented(LocalDate dateRented) {
        this.dateRented = dateRented;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(LocalDate dateReturned) {
        this.dateReturned = dateReturned;
    }
}
