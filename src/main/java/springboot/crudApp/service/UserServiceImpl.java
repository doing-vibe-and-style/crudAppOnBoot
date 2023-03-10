package springboot.crudApp.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.crudApp.dao.UserDAO;
import springboot.crudApp.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Transactional
    @Override
    public User update(User user) {
        return userDAO.update(user);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        userDAO.remove(id);
    }

    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDAO.listUsers();
    }
}
