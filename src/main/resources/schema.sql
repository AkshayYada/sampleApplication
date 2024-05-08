DROP TABLE IF EXISTS customerDetails;
CREATE TABLE customerDetails (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       firstName VARCHAR(255) NOT NULL,
                       lastName VARCHAR(255) NOT NULL UNIQUE,
                       dateOfBirth DATE NOT NULL
);