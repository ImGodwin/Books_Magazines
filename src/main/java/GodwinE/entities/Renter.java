package GodwinE.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("renter")
public class Renter extends User {

    private User user;
    private String itemREnted;
    private LocalDate dateRented;
    private LocalDate returnDate;
    private LocalDate dateReturned;

    public Renter(){}

    public Renter(String name, String surname, String dateOfBirth, String cardNum, User user,
                  String itemREnted, LocalDate dateRented, LocalDate returnDate, LocalDate dateReturned) {
        super(name, surname, dateOfBirth, cardNum);
        this.user = user;
        this.itemREnted = itemREnted;
        this.dateRented = dateRented;
        this.returnDate = returnDate;
        this.dateReturned = dateReturned;
    }

    @Override
    public String toString() {
        return "Renter{" +
                "user=" + user +
                ", itemREnted='" + itemREnted + '\'' +
                ", dateRented=" + dateRented +
                ", returnDate=" + returnDate +
                ", dateReturned=" + dateReturned +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getItemREnted() {
        return itemREnted;
    }

    public void setItemREnted(String itemREnted) {
        this.itemREnted = itemREnted;
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
