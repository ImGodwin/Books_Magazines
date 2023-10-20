package GodwinE;

import GodwinE.DAO.UserDAO;
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

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("book_magazine");
    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);

        LocalDate today = LocalDate.now();

        LocalDate yesterday = today.minusDays(0);
        LocalDate returnDate
                = today.plusDays(30);

        LocalDate cumpolsoryReturnDate = today.plusDays(30).minusDays(yesterday.compareTo(returnDate));

        Random rndmNum = new Random();
        try {
            UserDAO user = new UserDAO(em);



            Renter renter1 = new Renter(faker.name().firstName(), faker.name().lastName(), "13-05-1970",
                    "3klkge04ì4", faker.book().title(), yesterday, returnDate, cumpolsoryReturnDate);

            Renter renter2 = new Renter(faker.name().firstName(), faker.name().lastName(), "13-05-1970",
                    "3ejfhewrh", faker.book().title(), yesterday, returnDate, cumpolsoryReturnDate);

            user.save(renter1);



        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            em.close();
            emf.close();
        }

    }
}
