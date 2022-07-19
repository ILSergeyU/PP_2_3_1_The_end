package web.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }
}
