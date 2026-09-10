DROP TABLE IF EXISTS wordle_devices;
DROP TABLE IF EXISTS wordle_users;
GO

CREATE TABLE wordle_users (
    user_id INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    login VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL
);
GO

INSERT INTO wordle_users (login, password)
VALUES ('aaronvdpijll', 'Pizzahut123');
GO

SELECT *
FROM wordle_users;