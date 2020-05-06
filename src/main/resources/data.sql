DROP TABLE IF EXISTS books;

CREATE TABLE books (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  Author VARCHAR(250) NOT NULL
);

INSERT INTO books (name, Author) VALUES
  ('book1', 'Author1'),
  ('Book2', 'author2');