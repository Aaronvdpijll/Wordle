DROP TABLE IF EXISTS dbo.wordle_devices;
GO

CREATE TABLE dbo.wordle_devices (
    device_id INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    device_ip VARCHAR(40) NOT NULL,
    user_id INT NOT NULL,
    CONSTRAINT FK_wordle_devices_user
        FOREIGN KEY (user_id)
        REFERENCES dbo.wordle_users(user_id)
);
GO

INSERT INTO dbo.wordle_devices (device_ip, user_id)
VALUES ('1231234554155', 1);
GO

SELECT *
FROM dbo.wordle_devices;