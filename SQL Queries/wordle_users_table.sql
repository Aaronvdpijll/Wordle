DROP TABLE IF EXISTS wordle_devices;
Drop table if exists wordle_attempt;
DROP TABLE IF EXISTS wordle_users;

GO

CREATE TABLE wordle_users (
    user_id INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    login VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
	group_id int NOT NULL
	CONSTRAINT group_id
    FOREIGN KEY (group_id)
    REFERENCES dbo.wordle_group(group_id)
);
GO

INSERT INTO wordle_users (login, password,group_id)
VALUES ('aaronvdpijll', 'Pizzahut123',1);
GO

SELECT * FROM wordle_users;