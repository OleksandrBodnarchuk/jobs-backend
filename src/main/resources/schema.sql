CREATE TABLE companies
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    description   TEXT         NOT NULL,
    contact_email VARCHAR(255) NOT NULL,
    contact_phone VARCHAR(20)  NOT NULL
);

CREATE TABLE jobs
(
    id          SERIAL PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    type        VARCHAR(50)  NOT NULL,
    description TEXT         NOT NULL,
    location    VARCHAR(255) NOT NULL,
    salary      VARCHAR(50)  NOT NULL,
    company_id  INT          NOT NULL,
    FOREIGN KEY (company_id) REFERENCES companies (id)
);

-- Insert data into companies
INSERT INTO companies (name, description, contact_email, contact_phone)
VALUES ('NewTek Solutions',
        'NewTek Solutions is a leading technology company specializing in web development and digital solutions. We pride ourselves on delivering high-quality products and services to our clients while fostering a collaborative and innovative work environment.',
        'contact@teksolutions.com', '555-555-5555'),
       ('Veneer Solutions',
        'Veneer Solutions is a creative agency specializing in digital design and development. Our team is dedicated to pushing the boundaries of creativity and innovation to deliver exceptional results for our clients.',
        'contact@loremipsum.com', '555-555-5555'),
       ('Dolor Cloud',
        'Dolor Cloud is a leading technology company specializing in digital solutions for businesses of all sizes. With a focus on innovation and customer satisfaction, we are committed to delivering cutting-edge products and services.',
        'contact@dolorsitamet.com', '555-555-5555'),
       ('Alpha Elite',
        'Alpha Elite is a dynamic startup specializing in digital marketing and web development. We are committed to fostering a diverse and inclusive workplace where creativity and innovation thrive.',
        'contact@adipisicingelit.com', '555-555-5555'),
       ('Browning Technologies',
        'Browning Technologies is a rapidly growing technology company specializing in e-commerce solutions. We offer a dynamic and collaborative work environment where employees are encouraged to think creatively and innovate.',
        'contact@consecteturadipisicing.com', '555-555-5555'),
       ('Port Solutions INC',
        'Port Solutions is a leading technology company specializing in software development and digital marketing. We are committed to providing our clients with cutting-edge solutions and our employees with a supportive and rewarding work environment.',
        'contact@ipsumlorem.com', '555-555-5555');

-- Insert data into jobs
INSERT INTO jobs (title, type, description, location, salary, company_id)
VALUES ('Senior React Developer', 'Full-Time', 'We are seeking a talented Front-End Developer to join our team in Boston, MA. The ideal candidate will have strong skills in HTML, CSS, and JavaScript, with experience working with modern JavaScript frameworks such as React or Angular.', 'Boston, MA', '$70K - $80K', (SELECT id FROM companies WHERE name = 'NewTek Solutions')),
       ('Front-End Engineer (React & Redux)', 'Full-Time', 'Join our team as a Front-End Developer in sunny Miami, FL. We are looking for a motivated individual with a passion for crafting beautiful and responsive web applications. Experience with UI/UX design principles and a strong attention to detail are highly desirable.', 'Miami, FL', '$70K - $80K', (SELECT id FROM companies WHERE name = 'Veneer Solutions')),
       ('React.js Dev', 'Full-Time', 'Are you passionate about front-end development? Join our team in vibrant Brooklyn, NY, and work on exciting projects that make a difference. We offer competitive compensation and a collaborative work environment where your ideas are valued.', 'Brooklyn, NY', '$70K - $80K', (SELECT id FROM companies WHERE name = 'Dolor Cloud')),
       ('React Front-End Developer', 'Part-Time', 'Join our team as a Part-Time Front-End Developer in beautiful Pheonix, AZ. We are looking for a self-motivated individual with a passion for creating engaging user experiences. This position offers flexible hours and the opportunity to work remotely.', 'Pheonix, AZ', '$60K - $70K', (SELECT id FROM companies WHERE name = 'Alpha Elite')),
       ('Full Stack React Developer', 'Full-Time', 'Exciting opportunity for a Full-Time Front-End Developer in bustling Atlanta, GA. We are seeking a talented individual with a passion for building elegant and scalable web applications. Join our team and make an impact!', 'Atlanta, GA', '$90K - $100K', (SELECT id FROM companies WHERE name = 'Browning Technologies')),
       ('React Native Developer', 'Full-Time', 'Join our team as a Front-End Developer in beautiful Portland, OR. We are looking for a skilled and enthusiastic individual to help us create innovative web solutions. Competitive salary and great benefits package available.', 'Portland, OR', '$100K - $110K', (SELECT id FROM companies WHERE name = 'Port Solutions INC'));
