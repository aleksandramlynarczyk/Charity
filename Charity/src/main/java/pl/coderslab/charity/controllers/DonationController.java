package pl.coderslab.charity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.repository.UserRepository;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/donation")
public class DonationController {

    @Autowired
    InstitutionRepository institutionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DonationRepository donationRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/new-donation")
    public String showDonationForm(Model model) {
        Donation donation = new Donation();
        List<Category> categories = categoryRepository.findAll();
        List<Institution> institutions = institutionRepository.findAll();

        model.addAttribute("donation", donation);
        model.addAttribute("categories", categories);
        model.addAttribute("institutions", institutions);
        return "donation-form";
    }

    @PostMapping("/new-donation")
    public String performDonationForm(@Valid Donation donation, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return "donation-form";
        }
        donationRepository.save(donation);
        return "donation-form-confirmation";
    }


}
