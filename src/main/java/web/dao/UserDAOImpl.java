package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public List<User> getUsers(){
         return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User getUser(int id) {
        String HQL = "SELECT u FROM User u WHERE u.id =: userId";
        return entityManager.createQuery(HQL, User.class)
                .setParameter("userId", id)
                .getSingleResult();
    }

    @Override
    public void save(User user){
        entityManager.persist(user);
    }

    @Override
    public void update(User updatedUser){
        entityManager.merge(updatedUser);
    }

    @Override
    public void delete (Integer id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
