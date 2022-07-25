package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsersList();

    User findById(Long id);

    void deleteUser(Long id);

    void saveUser(User user);
}
