CREATE TABLE user_account (
    id BIGSERIAL PRIMARY KEY,
    cpf VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    wallet_id BIGINT UNIQUE,
    status_user VARCHAR(50),
    user_role VARCHAR(50),
    
    FOREIGN KEY (wallet_id) REFERENCES wallet(id)
);