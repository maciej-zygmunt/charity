package pl.coderslab.charity.dao;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.Category;
@Repository
public interface CategoryDao extends JpaRepositoryImplementation<Category,Long> {

}
