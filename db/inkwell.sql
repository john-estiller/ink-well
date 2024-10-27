-- Create the User table
CREATE TABLE User (
    user_id INTEGER PRIMARY KEY AUTOINCREMENT,
    username VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
    -- Add other user attributes as needed (e.g., first_name, last_name)
);

-- Create the Category table
CREATE TABLE Category (
    category_id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(255) UNIQUE NOT NULL
);

-- Create the Post table
CREATE TABLE Post (
    post_id INTEGER PRIMARY KEY AUTOINCREMENT,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    author_id INTEGER NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (author_id) REFERENCES User(user_id)
    -- Add other post attributes as needed (e.g., status, featured_image)
);

-- Create the Comment table
CREATE TABLE Comment (
    comment_id INTEGER PRIMARY KEY AUTOINCREMENT,
    post_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,  -- Foreign key to link comment to the user
    content TEXT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES Post(post_id),
    FOREIGN KEY (user_id) REFERENCES User(user_id)
);

-- Create the PostCategory table (for the many-to-many relationship)
CREATE TABLE PostCategory (
    post_id INTEGER NOT NULL,
    category_id INTEGER NOT NULL,
    PRIMARY KEY (post_id, category_id),
    FOREIGN KEY (post_id) REFERENCES Post(post_id),
    FOREIGN KEY (category_id) REFERENCES Category(category_id)
);

-- Insert default data for Category
INSERT INTO Category (name) VALUES
('Technology'),
('Travel'),
('Food'),
('Personal Finance'),
('Health and Fitness');

-- Insert default data in User Posts
INSERT INTO User (username, email, password) VALUES ('john_doe', 'john.doe@example.com', 'password123');
INSERT INTO User (username, email, password) VALUES ('jane_smith', 'jane.smith@example.com', 'password123');
INSERT INTO User (username, email, password) VALUES ('adobo_pusit', 'adobo.pusit@example.com', 'password123');
INSERT INTO User (username, email, password) VALUES ('water_jug', 'water.jug@example.com', 'password123');