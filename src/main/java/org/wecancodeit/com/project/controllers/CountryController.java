package org.wecancodeit.com.project.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.com.project.repositories.CountryRepository;

import javax.annotation.Resource;

@Controller
public class CountryController {

   @Resource
     private CountryRepository countryRepo;

   @RequestMapping("/countries")
   public String displayCountries(Model model){
       model.addAttribute("countries", countryRepo.findAll());
       return "countriesTemplate";



    }
}
