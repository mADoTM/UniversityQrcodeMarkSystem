CREATE TABLE pair_secret
(
    id      VARCHAR(255) NOT NULL,
    pair_id VARCHAR(255),
    secret  VARCHAR(255),
    CONSTRAINT pk_pairsecret PRIMARY KEY (id)
);