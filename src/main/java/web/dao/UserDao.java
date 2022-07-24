package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;
@Repository
public interface UserDao {
    List<User> getUsers();

    void saveUser(User user);
    void deleteUser(Long id);
    User findById(Long id);
}
