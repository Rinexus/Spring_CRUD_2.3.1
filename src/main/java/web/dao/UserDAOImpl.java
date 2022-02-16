package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO{
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public List<User> index(){
         return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User show(int id) {
        String HQL = "SELECT u FROM User u WHERE u.id =: userId";
       return  entityManager.createQuery(HQL, User.class)
                .setParameter("userId", id)
                .getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void save(User user){
        entityManager.persist(user);
    }

    @Override
    public void update(Integer id,User updatedUser){
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setEmail(updatedUser.getEmail());
        entityManager.persist(userToBeUpdated);
    }

    @Override
    public void delete (Integer id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
