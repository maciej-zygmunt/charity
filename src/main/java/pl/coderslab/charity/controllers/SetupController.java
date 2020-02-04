package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.dao.DonationDao;
import pl.coderslab.charity.dao.RoleDao;
import pl.coderslab.charity.factories.InitialDataFactory;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Role;

import java.util.List;

@Controller
public class SetupController {

    private final DonationDao donationDao;

    private final RoleDao roleDao;

    public SetupController(DonationDao donationDao, RoleDao roleDao) {
        this.donationDao = donationDao;
        this.roleDao = roleDao;
    }

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
