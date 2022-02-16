package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();
    User getUser(int id);
    void save(User user);
    void update(User updatedUser);
    void delete(Integer id);
}
