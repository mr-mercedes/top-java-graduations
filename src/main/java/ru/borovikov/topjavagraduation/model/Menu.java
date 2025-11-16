package ru.borovikov.topjavagraduation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "menus", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_id", "menu_date"},
        name = "uk_menus_restaurant_date")})
public class Menu extends AbstractBaseEntity {

    public Menu(LocalDate menuDate, Set<MenuItem> items, Restaurant restaurant) {
        this.menuDate = menuDate;
        this.items = items;
        this.restaurant = restaurant;
    }

    @NotNull
    @Column(name = "menu_date", nullable = false)
    private LocalDate menuDate;

    @OneToMany(
            mappedBy = "menu",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<MenuItem> items = new HashSet<>();

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Override
    public String toString() {
        return super.toString() + '(' + menuDate + ')';
    }
}
