package GodwinE.DAO;

import GodwinE.entities.Book;
import GodwinE.entities.Magazine;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;
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
        System.out.println("Magazine saved");
    }



    //delete with ISBN
    public void findByisbnAndDelete(int num)
    {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query queryISBN = em.createQuery("DELETE FROM Magazine m WHERE m.isbn = :num");
        queryISBN.setParameter("num", num);

        int queryToDelete = queryISBN.executeUpdate();

        transaction.commit();
        if (queryToDelete > 0) {
            System.out.println("This magazine has been deleted: " + queryToDelete);
        } else {
            System.out.println(queryToDelete + " not found");
        }

    }

    //Search publication year
    public List<Magazine> searchYearPublished(String date)
    {
        TypedQuery<Magazine> requestYearPublished = em.createQuery("SELECT Magazine FROM Magazine WHERE Magazine.yearpublished = :date", Magazine.class);
        requestYearPublished.setParameter("date", date);
        return requestYearPublished.getResultList();

    }

    //Search by title

}
