package pl.coderslab.charity.dao;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import pl.coderslab.charity.model.User;

public interface UserDao extends JpaRepositoryImplementation<User,Long> {
}
