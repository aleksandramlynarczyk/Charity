package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.repository.UserRepository;

import java.security.Principal;
import java.util.List;


@Controller
public class HomeController {

    @Autowired
    InstitutionRepository institutionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DonationRepository donationRepository;

    @RequestMapping("/")
    public String homeAction(Model model, Principal principal){
        List<Institution> institutions = institutionRepository.findAll();
        List<Donation> donations = donationRepository.findAll();
        int numberOfDonations = donations.size();
        int numberOfBags = 0;
        for (Donation donation:donations) {
            numberOfBags+=donation.getQuantity();
        }
        model.addAttribute("institutions", institutions);
        model.addAttribute("numberOfBags", numberOfBags);
        model.addAttribute("numberOfDonations", numberOfDonations);

        return "index";
    }
}
