package ru.borovikov.topjavagraduation.service;

import ru.borovikov.topjavagraduation.model.Menu;
import ru.borovikov.topjavagraduation.model.MenuItem;

import java.util.List;

public interface MenuService {

    Menu createTodayMenu(Long restaurantId, List<MenuItem> items);

    Menu updateTodayMenu(Long restaurantId, List<MenuItem> items);

    List<Menu> getTodayMenus();
}
