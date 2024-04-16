ALTER TABLE pair
    DROP COLUMN lecturer_id;

ALTER TABLE pair
    ADD lecturer_id VARCHAR(255);

ALTER TABLE note
    DROP COLUMN pair_id;

ALTER TABLE note
    DROP COLUMN student_id;

ALTER TABLE note
    ADD pair_id VARCHAR(255);

ALTER TABLE note
    ADD student_id VARCHAR(255);