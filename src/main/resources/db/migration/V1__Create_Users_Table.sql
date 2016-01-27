CREATE TABLE app_users (
  id serial PRIMARY KEY,
  first_name VARCHAR (100) not NULL,
  last_name VARCHAR (100) not NULL,
  email VARCHAR (100) not NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);