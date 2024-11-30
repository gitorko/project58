drop table if exists customer;

CREATE TABLE customer
(
    id           UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name         VARCHAR(255) NOT NULL,
    age          INTEGER      NOT NULL
);