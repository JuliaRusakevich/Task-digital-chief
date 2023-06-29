create schema if not exists sights
    authorization postgres;

drop table sights.cities;

create table sights.cities
(
    id          bigint primary key,
    name        varchar(30),
    country     varchar(30),
    age         int,
    population  decimal(20, 2),
    description text,
    created_at  timestamp
);


create table sights.sights
(
    id          bigint primary key,
    name        varchar(30),
    architect   varchar(50),
    style       varchar(30),
    address     varchar(50),
    description text,
    created_at  timestamp,
    city_id     int,
    foreign key (city_id) references sights.cities
);
