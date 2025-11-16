package ru.borovikov.topjavagraduation.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity {

    public Restaurant(Set<Menu> menus) {
        this.menus = menus;
    }

    @OneToMany(
            mappedBy = "restaurant",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Menu> menus = new HashSet<>();
}
