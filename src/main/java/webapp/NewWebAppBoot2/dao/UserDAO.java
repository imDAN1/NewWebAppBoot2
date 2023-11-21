package webapp.NewWebAppBoot2.dao;

import webapp.NewWebAppBoot2.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void createUser(User user);
    void updateUser(User user);
    User readUser(long id);
    void deleteUser(long id);
}