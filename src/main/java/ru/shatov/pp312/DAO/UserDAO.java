package ru.shatov.pp312.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.shatov.pp312.models.User;

import java.util.List;


@Repository
@Transactional
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("select u from User u", User.class).getResultList();
    }

    public User findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(User.class, id);
    }

    @Transactional
    public void saveUser(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(user);
    }

    @Transactional
    public void update(int id, User updatedUser) {
        Session session = entityManager.unwrap(Session.class);
        User curUser = session.get(User.class, id);
        curUser.setAge(updatedUser.getAge());
        curUser.setName(updatedUser.getName());
        curUser.setSurname(updatedUser.getSurname());
    }

    @Transactional
    public void deleteUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        session.remove(session.get(User.class, id));
    }
}
