package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dao.CategoryDao;
import pl.coderslab.charity.dao.DonationDao;
import pl.coderslab.charity.dao.InstitutionDao;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;

import java.util.List;

@Controller
@RequestMapping(path="/donation")
public class DonationController {
    private final DonationDao donationDao;
    private final CategoryDao categoryDao;
    private final InstitutionDao institutionDao;

    public DonationController(DonationDao donationDao, CategoryDao categoryDao, InstitutionDao institutionDao) {
        this.donationDao = donationDao;
        this.categoryDao = categoryDao;
        this.institutionDao=institutionDao;
    }

    @GetMapping(path = "/add")
    public String getDonation(Model model) {
        Donation donation= new Donation();
        model.addAttribute("donation",donation);
        model.addAttribute("rwCategories", donation.getCategories());
        return "form";
    }
    @PostMapping(path="/add")
    public String saveDonation(@ModelAttribute Donation donation) {
        donationDao.save(donation);
        return "form-confirmation";
    }
    @ModelAttribute("categoriesList")
    public List<Category> listCategories() {
        return categoryDao.findAll();
    }
    @ModelAttribute("institutionsList")
    public List<Institution> listInstitutions() {
        return institutionDao.findAll();
    }
}
