package GodwinE.DAO;

import GodwinE.entities.Book;
import GodwinE.entities.Magazine;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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

    public Magazine deleteWithISBN(Magazine id) {
        return em.find(Magazine.class, id);
    }

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






        /*Magazine found = em.find(Magazine.class, id);
        if(found != null)
        {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();
            System.out.println("The magazine has been deleted");
        }else {
            System.out.println("the magazine with " + id + " was not found");
        }*/
    }
}
