package ru.borovikov.topjavagraduation.service;

import ru.borovikov.topjavagraduation.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant create(Restaurant restaurant);

    Restaurant update(Long id, Restaurant restaurant);

    void delete(Long id);

    List<Restaurant> getAll();
}
