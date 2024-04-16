CREATE TABLE note
(
    id         VARCHAR(255) NOT NULL,
    student_id UUID,
    pair_id    UUID,
    marked_at  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_note PRIMARY KEY (id)
);

CREATE TABLE pair
(
    id          VARCHAR(255) NOT NULL,
    lecturer_id UUID,
    started_at  TIMESTAMP WITHOUT TIME ZONE,
    end_at      TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_pair PRIMARY KEY (id)
);