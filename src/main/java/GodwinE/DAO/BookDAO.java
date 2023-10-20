package GodwinE.DAO;


import GodwinE.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.util.UUID;

public class BookDAO {

    private final EntityManager em;

    public BookDAO(EntityManager em)
    {
        this.em = em;
    }

    public void save(Book book){
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(book);

        transaction.commit();
        System.out.println("Student saved");
    }

    public Book findById(UUID id) {
        return em.find(Book.class, id);
    }

    public void findByIdAndDelete(UUID id)
    {
        Book found = em.find(Book.class, id);
        if(found != null)
        {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();
            System.out.println("The book has been deleted");
        }else {
            System.out.println("the book with " + id + " was not found");
        }
    }
}