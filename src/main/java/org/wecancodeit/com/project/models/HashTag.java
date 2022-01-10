package org.wecancodeit.com.project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
public class HashTag {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(mappedBy ="hashTags")
    private Collection<Island> islands;

    public HashTag(){

    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    public Collection<Island> getIslands(){
        return islands;
    }

    public HashTag(String name) {
        this.name = name;
        islands = new ArrayList<>();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashTag hashTag = (HashTag) o;
        return Objects.equals(id, hashTag.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}