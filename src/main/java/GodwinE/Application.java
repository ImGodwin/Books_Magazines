package GodwinE;

import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Locale;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("book_magazine");
    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);

        try {

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            em.close();
            emf.close();
        }

    }
}
