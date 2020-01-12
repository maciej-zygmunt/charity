package pl.coderslab.charity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dao.DonationDao;
import pl.coderslab.charity.dao.InstitutionDao;
import pl.coderslab.charity.model.Institution;

import java.util.List;


@Controller
public class HomeController {

    public HomeController(InstitutionDao institutionDao, DonationDao donationDao) {
        this.institutionDao = institutionDao;
        this.donationDao = donationDao;
    }

    private InstitutionDao institutionDao;

    private DonationDao donationDao;

    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> institutions=institutionDao.findAll();
        model.addAttribute("institutions", institutions);
        long donationsSum = donationDao.donationsSum();
        model.addAttribute("donationsSum",donationsSum);
        long institutionsCount = donationDao.institutionsCount();
        model.addAttribute("institutionsCount",institutionsCount);
        return "index";
    }
}
