CREATE TABLE todo (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      content VARCHAR(255) NOT NULL,
                      status VARCHAR(50) NOT NULL,
                      created_at TIMESTAMP NOT NULL,
                      updated_at TIMESTAMP
);
