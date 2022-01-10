package org.wecancodeit.com.project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Continent {
    @Id
    @GeneratedValue

    private Long id;
    private String name;
    private String imageUrl;
    @OneToMany(mappedBy = "continent")
    private Collection<Island> islands;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Island> getIslands() {
        return islands;
    }

    public Continent(){

    }

    public Continent(String name, String imageUrl){
        this.name = name;
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Continent continent = (Continent)  o;
        return Objects.equals(id, continent.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}