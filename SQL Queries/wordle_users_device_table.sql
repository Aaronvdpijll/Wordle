DROP TABLE IF EXISTS dbo.wordle_devices;
GO

CREATE TABLE dbo.wordle_devices (
    device_ip CHAR(12) PRIMARY KEY NOT NULL,
    user_id INT NOT NULL,
    CONSTRAINT FK_wordle_devices
    FOREIGN KEY (user_id)
    REFERENCES dbo.wordle_users(user_id)
);
GO

INSERT INTO dbo.wordle_devices (device_ip, user_id)
VALUES ('001A2B3C4D5E', 1);
GO

SELECT *
FROM dbo.wordle_devices;