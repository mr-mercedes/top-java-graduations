package ru.borovikov.topjavagraduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.borovikov.topjavagraduation.model.Menu;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Optional<Menu> findByRestaurantIdAndMenuDate(Long restaurantId, LocalDate menuDate);

    List<Menu> findAllByMenuDate(LocalDate menuDate);
}
