package org.wecancodeit.com.project.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import org.wecancodeit.com.project.models.Ocean;


@Repository
public interface OceanRepository extends CrudRepository<Ocean, Long> {



}