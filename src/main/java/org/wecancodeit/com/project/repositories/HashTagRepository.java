package org.wecancodeit.com.project.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.com.project.models.HashTag;

import java.util.Optional;

public interface HashTagRepository extends CrudRepository<HashTag, Long> {
    Optional<HashTag> findByName(String hashTagName);
}
