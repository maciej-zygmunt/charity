package pl.coderslab.charity.dao;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;

public interface RoleDao extends JpaRepositoryImplementation<Role,Long> {
    Role findByName(String role_user);
}
