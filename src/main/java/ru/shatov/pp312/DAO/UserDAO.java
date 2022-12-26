package ru.shatov.pp312.DAO;

import ru.shatov.pp312.models.User;


import java.util.List;

public interface UserDAO {

    List<User> findAll();

    User findById(int id);

    void saveUser(User user);

    void update(int id, User updatedUser);

    void deleteUser(int id);
}
