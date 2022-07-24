package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

@Service
public interface UserService {
    List<User> getUsersList();

    User findById(Long id);

    void deleteUser(Long id);

    void saveUser(User user);
}
