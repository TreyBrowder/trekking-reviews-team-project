package org.wecancodeit.com.project.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.com.project.models.Country;
import org.wecancodeit.com.project.models.Island;


@Repository
public interface IslandRepository extends CrudRepository<Island, Long> {

    Country findIslandByCountry(String Country);

}