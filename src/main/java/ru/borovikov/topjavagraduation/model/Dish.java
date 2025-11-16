package ru.borovikov.topjavagraduation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dishes")
@Getter
@Setter
public class Dish extends AbstractNamedEntity {

    @Override
    public String toString() {
        return super.toString();
    }
}
