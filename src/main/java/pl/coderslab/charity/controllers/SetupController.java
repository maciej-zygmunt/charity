package pl.coderslab.charity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.dao.DonationDao;
import pl.coderslab.charity.dao.InstitutionDao;
import pl.coderslab.charity.dao.RoleDao;
import pl.coderslab.charity.factories.InitialDataFactory;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.Role;

import java.util.List;

@Controller
public class SetupController {
    @Autowired
    DonationDao donationDao;
    @Autowired
    RoleDao roleDao;
    @GetMapping(path = "/setup")
    @ResponseBody
    public String setup() {
        Role role = new Role();
        role.setName("ROLE_USER");
        roleDao.save(role);
        List<Donation> donations=InitialDataFactory.createDonations();
        donations= donationDao.saveAll(donations);
        return donations.toString();
    }
}
