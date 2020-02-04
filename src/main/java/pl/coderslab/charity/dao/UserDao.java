package pl.coderslab.charity.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import pl.coderslab.charity.model.User;

public interface UserDao extends JpaRepositoryImplementation<User,Long> {
//    @Query("Select u from User u where u.email=?1")
//    User findByName(String name);
    User findByEmail(String email);

}
