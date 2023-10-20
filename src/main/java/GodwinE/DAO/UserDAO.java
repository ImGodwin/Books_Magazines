package GodwinE.DAO;


import GodwinE.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.util.UUID;

public class UserDAO {

    private final EntityManager em;

    public UserDAO(EntityManager em)
    {
        this.em = em;
    }

    public void save(User user){
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(user);

        transaction.commit();
        System.out.println("Book saved");
    }

    public User findById(UUID id) {
        return em.find(User.class, id);
    }

    public void findByIdAndDelete(UUID id)
    {
        User found = em.find(User.class, id);
        if(found != null)
        {
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();
            System.out.println("The user has been deleted");
        }else {
            System.out.println("the user with " + id + " was not found");
        }
    }
}
