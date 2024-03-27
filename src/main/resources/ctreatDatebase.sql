create database myApp;

use myApp;

CREATE TABLE users (
                       user_id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(100) UNIQUE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO users (username, password, email) VALUES
                                                  ('user1', 'hashed_password1', 'user1@example.com'),
                                                  ('user2', 'hashed_password2', 'user2@example.com'),
                                                  ('user3', 'hashed_password3', 'user3@example.com'),
                                                  ('user4', 'hashed_password4', 'user4@example.com'),
                                                  ('user5', 'hashed_password5', 'user5@example.com');


select * from users where username = '18474314498';
