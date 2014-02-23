--liquibase formatted sql

--changeset aMasset:1

create table user (
    id integer NOT NULL AUTO_INCREMENT,
    id_groupe integer NOT NULL DEFAULT '1',
    passwd varchar(40) NOT NULL,
    email varchar(100) NOT NULL,
    nickname varchar(25) NOT NULL,
    subscription_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    is_active integer NOT NULL DEFAULT '0',
    is_deleted integer NOT NULL DEFAULT '0',
    PRIMARY KEY (id)
) ENGINE=InnoDB;


--changeset aMasset:2

create table user_group (
    id integer not null primary key auto_increment,
    group_name varchar(50) not null,
    is_deleted integer not null DEFAULT '0'
) engine = innodb;


--changeset aMasset:3

create table movie (
    id integer not null primary key auto_increment,
    title varchar(150) not null,
    web_link varchar(150),
    is_deleted integer not null DEFAULT '0'
) engine = innodb;


-- changeset aMasset:4

ALTER DATABASE wihtow CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE movie CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE user CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE user_group CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;


-- changeset aMasset:5

ALTER TABLE user DROP COLUMN id_groupe;
ALTER TABLE user ADD group_name varchar(30);
DROP TABLE user_group;


-- changeset aMasset:6

create table genre (
    id integer not null primary key auto_increment,
    libelle varchar(150) not null,
    is_deleted integer not null DEFAULT 0,
    CONSTRAINT chk_genre_deleted CHECK (is_deleted IN (0,1))
) engine = innodb;

create table movie_genre (
    id_movie integer not null,
    id_genre integer not null,
    INDEX idx_movie (id_movie),
    INDEX idx_genre (id_genre),
    CONSTRAINT fk_movie FOREIGN KEY (id_movie) REFERENCES movie(id),
    CONSTRAINT fk_genre FOREIGN KEY (id_genre) REFERENCES genre(id),
    CONSTRAINT uc_movie_genre UNIQUE (id_movie,id_genre)
) engine = innodb;

ALTER TABLE movie ADD CONSTRAINT chk_movie_delete CHECK (is_deleted IN (0,1));
ALTER TABLE user ADD CONSTRAINT chk_user_delete CHECK (is_deleted IN (0,1));
ALTER TABLE user ADD CONSTRAINT chk_user_active CHECK (is_active IN (0,1));
ALTER TABLE genre CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;