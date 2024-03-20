CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE cases (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE events (
    id SERIAL PRIMARY KEY,
    case_id INTEGER REFERENCES cases(id),
    user_id INTEGER REFERENCES users(id),
    date TIMESTAMP NOT NULL,
    description TEXT
);

CREATE TABLE documents (
    id SERIAL PRIMARY KEY,
    event_id INTEGER REFERENCES events(id),
    file_path VARCHAR(255) NOT NULL,
    file_name VARCHAR(255) NOT NULL
);

CREATE TABLE user_case_assignments (
    user_id INTEGER REFERENCES users(id),
    case_id INTEGER REFERENCES cases(id),
    PRIMARY KEY (user_id, case_id)
);
