package springboot.crudApp.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import springboot.crudApp.entity.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public User update(User user) {
        return entityManager.merge(user);
    }

    @Override
    public void remove(Long id) {
        entityManager.createNativeQuery("delete from User where ID = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public User getUser (Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }
}
