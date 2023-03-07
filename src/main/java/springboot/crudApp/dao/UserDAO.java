package springboot.crudApp.dao;

import springboot.crudApp.entity.User;

import java.util.List;

public interface UserDAO {
    void add(User user);
    User update(User user);
    void remove(Long id);
    User getUser (Long id);
    List<User> listUsers();

}
