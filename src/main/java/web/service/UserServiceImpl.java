package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> getUsersList() {
        return userDao.getUsers();
    }

    @Override
    @Transactional
    public void saveUser(String name, String lastName) {
        userDao.saveUser(new User(name, lastName));
    }

    @Override
    @Transactional
    public User findById(Long id) {
        User user;
        if(id==0) user = new User();
        else user = userDao.findById(id);
        return user;
    }

}
