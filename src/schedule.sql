CREATE TABLE SCHEDULE
(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(15) NOT NULL,
    password VARCHAR(30) NOT NULL,
    todo VARCHAR(50) NULL,
    date DATETIME NULL,
    CONSTRAINT SCHEDULE_PK PRIMARY KEY(id)
);