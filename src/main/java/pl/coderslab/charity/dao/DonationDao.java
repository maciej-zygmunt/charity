package pl.coderslab.charity.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import pl.coderslab.charity.model.Donation;

public interface DonationDao extends JpaRepositoryImplementation<Donation,Long> {
    @Query("select sum(d.quantity) as total from Donation d ")
    public Long donationsSum();
    @Query("select distinct count(d.institution) from Donation d")
    public Long institutionsCount();
}
