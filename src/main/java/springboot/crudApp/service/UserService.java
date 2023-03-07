package springboot.crudApp.service;


import springboot.crudApp.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);
    User update(User user);
    void remove(Long id);
    User getUser(Long id);
    List<User> listUsers();
}
