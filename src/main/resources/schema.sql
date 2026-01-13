CREATE TABLE IF NOT EXISTS todo (
    id SERIAL PRIMARY KEY,  -- SERIAL auto-increments like AUTO_INCREMENT in MySQL
    content VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
    );