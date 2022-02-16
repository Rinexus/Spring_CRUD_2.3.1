package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUser(int id);
    void save(User user);
    void update(User user);
    void delete(Integer id);
}
