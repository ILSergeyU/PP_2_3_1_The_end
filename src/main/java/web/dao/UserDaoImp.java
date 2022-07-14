package web.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private final EntityManager entityManager;

    @Autowired
    public UserDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        for (long a = 1; a < 10; a++) {
            users.add(new User(a, "Name " + a, "lastName " + a));
            System.out.print("_"+a);
        }
        System.out.println();
        //TypedQuery<User> query = entityManager.createQuery("FROM User", User.class);
        return users;
    }
}
