package org.wecancodeit.com.project.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.wecancodeit.com.project.repositories.OceanRepository;

import javax.annotation.Resource;

@Controller
public class OceanController {

   @Resource
     private OceanRepository oceanRepo;

   @RequestMapping("/oceans")
   public String displayOceans(Model model){
       model.addAttribute("oceans", oceanRepo.findAll());
       return "oceansTemplate";



    }
}
