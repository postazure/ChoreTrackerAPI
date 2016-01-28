CREATE TABLE app_users (
  id serial PRIMARY KEY,
  first_name VARCHAR (100) not NULL,
  last_name VARCHAR (100) not NULL,
  email VARCHAR (100) not NULL,
  created_at TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
  password VARCHAR(255) not NULL,
  token VARCHAR(255)
);