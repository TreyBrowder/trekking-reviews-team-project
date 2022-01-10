package org.wecancodeit.com.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.com.project.models.Continent;
import org.wecancodeit.com.project.models.Country;
import org.wecancodeit.com.project.models.Island;
import org.wecancodeit.com.project.models.Ocean;
import org.wecancodeit.com.project.repositories.*;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private ContinentRepository continentRepo;
    @Resource
    private CountryRepository countryRepo;
    @Resource
    private HashTagRepository hashTagRepo;
    @Resource
    private IslandRepository islandRepo;
    @Resource
    private OceanRepository oceanRepo;

    @Override
    public void run(String... args) throws Exception {

        Continent northAmerica = new Continent("North America", "/static/images/northAmerica.jpg");
        Continent SouthAmerica = new Continent("South America", "/static/images/southAmerica.jpg");
        Continent Africa = new Continent("Africa", "/static/images/africa.jpg");
        Continent Asia = new Continent("Asia", "/static/images/asia.jpg");
        Continent Europe = new Continent("Europe", "/static/images/europe.jpg");
        Continent Australia = new Continent("Australia", "/static/images/australia.jpg");
        continentRepo.save(northAmerica);
        continentRepo.save(SouthAmerica);
        continentRepo.save(Africa);
        continentRepo.save(Asia);
        continentRepo.save(Europe);
        continentRepo.save(Australia);

        Country republicFiji = new Country( "Republic of Fiji", "/images/world-map.gif");
        Country italy = new Country("italy", "/static/images/Italy.jpg");
        Country usa = new Country("United States of America", "/static/images/usa.jpg");
        Country venezuela = new Country("Venezuela", "/static/images/venezuela.jpg");
        Country capeVerde = new Country("Cape Verde", "/static/images/CapeVerde.jpg");
        Country thailand = new Country("Thailand", "/static/images/Thailand.jpg");
        countryRepo.save(republicFiji);
        countryRepo.save(italy);
        countryRepo.save(usa);
        countryRepo.save(venezuela);
        countryRepo.save(capeVerde);
        countryRepo.save(thailand);


        Island fiji = new Island("Fiji", "/static/images/Fiji.jpg", "Australia", "Republic of Fiji", "South Pacific Ocean", "Description");
        Island levanzo = new Island("Levanzo", "/static/images/levanzoIsland.jpg", "Europe", "Italy", "Mediterranean Sea", "Levanzo is one of the most beautiful islands in Italy.  Its surrounded by the blue green waters of the Mediterranean Sea.  The island is also characterized by the white limestone rocks and many caves to visit.  There is plenty to do ranging from trekking, beaches, diving, boat tours etc.");
        Island maui = new Island("Maui", "/static/images/mauiIsland.jpg", "North America", "US", "Central Pacific", "Maui, known also as “The Valley Isle,” is the second largest Hawaiian island. The island beloved for its world-famous beaches, the sacred Iao Valley, views of migrating humpback whales (during winter months), farm-to-table cuisine and the magnificent sunrise and sunset from Haleakala.");
        Island laTortuga = new Island("LaTortuga", "/static/images/LaTortuga.jpg", "South America", "Venezuela", "Caribbean Sea", "La Tortuga Island (Spanish: Isla La Tortuga; \"La Tortuga\" means \"the turtle\") is an uninhabited island of Venezuela, the largest in the Federal Dependencies of Venezuela. It is part of a group of islands that include the Tortuguillos and Cayo Herradura");
        Island santiagoIsland = new Island("Santiago Island", "/static/images/santiago.jpg", "Africa", "Cape Verde", "Central Atlantic", "This island consist of two overlapping volcanoes.  Common wildlife that can be seen on or around the island are: fur seals, sea lions, lightfoot crabs, marine iguana, dolphins, rice rats, and sharks.");
        Island similanIslands = new Island("Similan Islands ", "/static/images/similan.jpg", "Asia", "Thailand", "Caribbean Sea", "The Similan Islands are an archipelago of 11 islands in the Andaman Sea 70 kilometers off the coast of southern Thailand's Phang Nga Province, the Similan Islands. The island is best known as a diving and snorkeling destination, but the Similans' scenic moorings have also become popular with the sailing fraternity.");

        islandRepo.save(fiji);
        islandRepo.save(levanzo);
        islandRepo.save(maui);
        islandRepo.save(laTortuga);
        islandRepo.save(santiagoIsland);
        islandRepo.save(similanIslands);

        Ocean atlantic = new Ocean("Atlantic", "imgurl");
        Ocean pacific = new Ocean("Pacific", "imgurl");
        Ocean indian = new Ocean("Indian", "imgurl");
        Ocean arctic = new Ocean("Arctic", "imgurl");
        Ocean antarctic = new Ocean("Antarctic", "imgurl");

        oceanRepo.save(atlantic);
        oceanRepo.save(pacific);
        oceanRepo.save(indian);
        oceanRepo.save(arctic);
        oceanRepo.save(antarctic);




    }
}
