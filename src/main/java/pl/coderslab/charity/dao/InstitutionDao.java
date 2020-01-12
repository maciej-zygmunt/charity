package pl.coderslab.charity.dao;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import pl.coderslab.charity.model.Institution;

public interface InstitutionDao extends JpaRepositoryImplementation<Institution,Long> {
}
