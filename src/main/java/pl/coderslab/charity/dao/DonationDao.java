package pl.coderslab.charity.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import pl.coderslab.charity.model.Donation;

public interface DonationDao extends JpaRepositoryImplementation<Donation,Long> {
    @Query("select sum(d.quantity) as total from Donation d ")
    Long donationsSum();
    @Query("select  count(distinct d.institution) from Donation d")
    Long institutionsCount();
}
