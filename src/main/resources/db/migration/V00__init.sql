CREATE SCHEMA IF NOT EXISTS voting;
CREATE SEQUENCE IF NOT EXISTS global_seq START 100000;
CREATE TABLE IF NOT EXISTS users
(
    id    BIGINT PRIMARY KEY,
    email VARCHAR(128) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_role
(
    user_id BIGINT       NOT NULL,
    role    VARCHAR(255) NOT NULL DEFAULT 'USER',
    CONSTRAINT uk_user_role UNIQUE (user_id, role),
    CONSTRAINT fk_user_role_users FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE INDEX IF NOT EXISTS idx_user_role_user_id ON user_role (user_id);

CREATE TABLE IF NOT EXISTS restaurants
(
    id   BIGINT PRIMARY KEY,
    name VARCHAR(128) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS menus
(
    id            BIGINT PRIMARY KEY,
    restaurant_id BIGINT NOT NULL,
    menu_date     DATE   NOT NULL,
    CONSTRAINT fk_menus_restaurants FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE,
    CONSTRAINT uk_menus_restaurant_date UNIQUE (restaurant_id, menu_date)
);
CREATE INDEX IF NOT EXISTS idx_menus_restaurant_id ON menus (restaurant_id);

CREATE TABLE IF NOT EXISTS dishes
(
    id    BIGINT PRIMARY KEY,
    name  VARCHAR(255)   NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS menu_items
(
    id      BIGINT PRIMARY KEY,
    menu_id BIGINT NOT NULL,
    dish_id BIGINT NOT NULL,
    price   NUMERIC(10, 2) NOT NULL CHECK (price > 0),
    CONSTRAINT uk_menu_items_menu_dish UNIQUE (menu_id, dish_id),
    CONSTRAINT fk_menu_items_menus FOREIGN KEY (menu_id) REFERENCES menus (id) ON DELETE CASCADE,
    CONSTRAINT fk_menu_items_dishes FOREIGN KEY (dish_id) REFERENCES dishes (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS votes
(
    id            BIGINT PRIMARY KEY,
    user_id       BIGINT NOT NULL,
    restaurant_id BIGINT NOT NULL,
    vote_date     DATE   NOT NULL,
    CONSTRAINT fk_votes_users FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT fk_votes_restaurants FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE,
    CONSTRAINT uk_votes_user_date UNIQUE (user_id, vote_date)
);
CREATE INDEX IF NOT EXISTS idx_votes_user_date ON votes (user_id, vote_date);