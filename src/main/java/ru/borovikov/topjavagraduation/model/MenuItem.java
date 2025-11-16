package ru.borovikov.topjavagraduation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "menu_items", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"menu_id", "dish_id"}, name = "uk_menu_items_menu_dish")
})
public class MenuItem extends AbstractBaseEntity {

    public MenuItem(Menu menu, Dish dish, BigDecimal price) {
        this.menu = menu;
        this.dish = dish;
        this.price = price;
    }

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id", nullable = false)
    private Dish dish;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    @NotNull
    @DecimalMin(value = "0.01", message = "Price must be positive")
    private BigDecimal price;
}
