package GodwinE.DAO;

import GodwinE.entities.Books;
import GodwinE.entities.Magazine;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.awt.print.Book;
import java.util.UUID;

public class MagazineDAO {

    private final EntityManager em;

    public MagazineDAO(EntityManager em)
    {
        this.em = em;
    }

    public void save(Magazine magazine){
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(magazine);

        transaction.commit();
        System.out.println("Student saved");
    }

    public Magazine findById(UUID id) {
        return em.find(Magazine.class, id);
    }

    public void findByIdAndDelete(UUID id)
    {
        Magazine found = em.find(Magazine.class, id);
        if(found != null)
        {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();
            System.out.println("The magazine has been deleted");
        }else {
            System.out.println("the magazine with " + id + " was not found");
        }
    }
}
