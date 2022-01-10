package org.wecancodeit.com.project.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.com.project.repositories.ContinentRepository;
import org.wecancodeit.com.project.repositories.CountryRepository;
import org.wecancodeit.com.project.repositories.IslandRepository;
import org.wecancodeit.com.project.repositories.OceanRepository;

import javax.annotation.Resource;

@Controller
public class HomeController {
    @Resource
    private ContinentRepository contentRepo;
    @Resource
    private CountryRepository countryRepo;
    @Resource
    private IslandRepository islandRepo;
    @Resource
    private OceanRepository oceanRepo;

    @RequestMapping({"/home", "/", ""})
    public String homeData(Model model){
        model.addAttribute("continentModel", contentRepo.findAll());
        model.addAttribute("countries", countryRepo.findAll());
        model.addAttribute("islands", islandRepo.findAll());
        model.addAttribute("oceans", oceanRepo.findAll());
        return "home";
}
}