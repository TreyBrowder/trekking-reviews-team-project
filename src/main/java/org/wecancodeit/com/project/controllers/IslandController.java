package org.wecancodeit.com.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.com.project.models.HashTag;
import org.wecancodeit.com.project.models.Island;
import org.wecancodeit.com.project.repositories.HashTagRepository;
import org.wecancodeit.com.project.repositories.IslandRepository;

import javax.annotation.Resource;
import java.util.Optional;

@Controller
public class IslandController {

    @Resource
    private IslandRepository islandRepo;
    @Resource
    private HashTagRepository hashTagRepo;



    @RequestMapping("/islands")
    public String displayAllIslands(Model model) {
        model.addAttribute("islandsModel", islandRepo.findAll());
        return "islandsTemplate";
    }

    @RequestMapping("islands/{id}")
    public String displaySingleIsland(@PathVariable long id, Model model){
        Optional<Island> retrievedIsland = islandRepo.findById(id);
        Island foundIsland = retrievedIsland.get();
        model.addAttribute("island", foundIsland);
        return "islandTemplate";
    }

    @PostMapping("/islands/{id}/add-hashtag")
    public String addHashTagToIsland(@RequestParam String hashTagName, @PathVariable long id){
        HashTag hashTagToAddToIsland;

        Optional<HashTag> hashTagToAddOpt = hashTagRepo.findByName(hashTagName);
            if(hashTagToAddOpt.isEmpty()){
                hashTagToAddToIsland = new HashTag(hashTagName);
                hashTagRepo.save(hashTagToAddToIsland);
            } else {
                hashTagToAddToIsland = hashTagToAddOpt.get();
            }
            Optional<Island> retrievedIsland = islandRepo.findById(id);
            Island foundIsland = retrievedIsland.get();
            foundIsland.addHashTag(hashTagToAddToIsland);
            islandRepo.save(foundIsland);
            return "redirect:/islands" + id;
    }
        @PostMapping("/islands/{id}/delete-hashtag/{hashTagId}")
        public String deleteHashTag(@PathVariable Long id, @PathVariable Long hashTagId){
            Optional<HashTag> hashTagToRemoveOpt = hashTagRepo.findById(hashTagId);
            HashTag hashTagToRemove = hashTagToRemoveOpt.get();

            for(Island island: hashTagToRemove.getIslands()){
                island.deleteHashTag(hashTagToRemove);
                islandRepo.save(island);
            }

            Optional<Island> islandToRemoveHashTagFromOpt = islandRepo.findById(id);
            Island islandToRemoveHashTagFrom = islandToRemoveHashTagFromOpt.get();
            islandToRemoveHashTagFrom.deleteHashTag(hashTagToRemove);
            islandRepo.save(islandToRemoveHashTagFrom);
            hashTagRepo.delete(hashTagToRemove);
            return "redirect:/islands/" + id;
        }
}


