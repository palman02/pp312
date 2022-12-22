package ru.shatov.pp312.service;

import ru.shatov.pp312.models.User;
import java.util.List;

public interface ServiceUser {

    List<User> findAll();

    User findOne(int id);

    void saveUser(User user);

    void update(int id, User updatedUser);

    void deleteUser(int id);



}
