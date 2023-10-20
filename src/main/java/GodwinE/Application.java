package GodwinE;

import GodwinE.DAO.BookDAO;
import GodwinE.DAO.MagazineDAO;
import GodwinE.DAO.UserDAO;
import GodwinE.entities.Book;
import GodwinE.entities.Magazine;
import GodwinE.entities.Release;
import GodwinE.entities.Renter;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Locale;
import java.util.Random;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("book_magazine");
    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);
        /*Supplier<Book> bookSupplier = () -> {
            return new Book(faker.book().publisher(), faker.book().title(), faker.random().nextDouble(), faker.number().numberBetween(100, 300),
                    faker.book().author(), faker.book().genre());
        };*/

        LocalDate today = LocalDate.now();

        LocalDate yesterday = today.minusDays(0);
        LocalDate returnDate
                = today.plusDays(30);

        LocalDate cumpolsoryReturnDate = today.plusDays(30).minusDays(yesterday.compareTo(returnDate));
        //DAO's

        UserDAO user = new UserDAO(em);
        BookDAO bookDAO = new BookDAO(em);
        MagazineDAO magDAO = new MagazineDAO(em);

        Random rndmNum = new Random();

        //BOOKs and MAGS
        Magazine newMag = new Magazine(23344, "fashion", "1993", 98, Release.WEEKLY);
        Magazine newMag2 = new Magazine(275894, "engineer", "1994", 89, Release.WEEKLY);
        Magazine newMag3 = new Magazine(945775, "Good book", "1995", 67, Release.YEARLY);
        Magazine newMag4 = new Magazine(75890, "Playboy", "1991", 78, Release.MONTHLY);
        Magazine newMag5 = new Magazine(34644, "women", "1973", 98, Release.WEEKLY);
        Magazine newMag6 = new Magazine(98776, "pilot", "1983", 98, Release.WEEKLY);
        Magazine newMag7 = new Magazine(78907, "Stories", "1963", 98, Release.YEARLY);

        //<<<<<<<<<<<<<<<<<<<<

        Book book1 = new Book(77599, "fathers book", "1986", 400, "Mr James", "Romance");
        Book book2 = new Book(57847, "Health book", "1982", 200, "Mr Mike", "Health");
        Book book3 = new Book(50967, "Love book", "1983", 300, "Mr John", "Romance");
        Book book4 = new Book(58579, "Marriage book", "1984", 500, "Mr Williams", "Growth");
        Book book5 = new Book(50869, "Kids book", "1985", 600, "Mr John", "Parenting");
        Book book6 = new Book(96894, "Cook book", "1987", 100, "Mr Wright", "Cook");


        //try catch
        try {

            /*magDAO.save(newMag);
            magDAO.save(newMag2);
            magDAO.save(newMag3);
            magDAO.save(newMag4);
            magDAO.save(newMag5);
            magDAO.save(newMag6);*/
            //
            /*bookDAO.save(book2);
            bookDAO.save(book3);
            bookDAO.save(book4);
            bookDAO.save(book5);
            bookDAO.save(book6);*/

            //<<<<<<<<<<<<<<<<Remove element>>>>>>>>>>>>>>>>
            //magDAO.findByisbnAndDelete(75890);


            //<<<<<<<<<<<<get via year published>>>>>>>>>>>>>

            //this method is not functioning
            //magDAO.searchYearPublished("1995").forEach(year -> System.out.println(year));


            //<<<<<<<<<get author by name >>>>>>>>>>>>>>
           /* bookDAO.getAuthor("Mr Mike").forEach(authors -> System.out.println(authors));*/

            //<<<<<<<<<get book by title>>>>>>>>>>>>
            bookDAO.getByTitle("fathers book").forEach(book -> System.out.println(book));

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            em.close();
            emf.close();
        }

    }
}
