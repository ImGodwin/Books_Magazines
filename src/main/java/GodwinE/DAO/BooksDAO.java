package GodwinE.DAO;


import GodwinE.entities.Books;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.awt.print.Book;
import java.util.UUID;

public class BooksDAO {

    private final EntityManager em;

    public BooksDAO(EntityManager em)
    {
        this.em = em;
    }

    public void save(Books book){
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
        Books found = em.find(Books.class, id);
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
