package org.wecancodeit.com.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.com.project.repositories.ContinentRepository;

import javax.annotation.Resource;

@Controller
public class ContinentController {

    @Resource
    private ContinentRepository continentRepo;

    @RequestMapping("/Continents")
    public String findAllContinents(Model model){
        model.addAttribute("continentsModel", continentRepo.findAll());
        return "continentsTemplate";
    }
}
