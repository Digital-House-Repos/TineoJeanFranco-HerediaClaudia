CREATE TABLE ODONTOLOGOS  (
    id INT PRIMARY KEY AUTO_INCREMENT,
    numeroMatricula VARCHAR(50) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL
);

INSERT INTO ODONTOLOGOS (numeroMatricula, nombre, apellido) VALUES
('12345', 'Juan', 'Pérez'),
('67890', 'María', 'González'),
('54321', 'Luis', 'Martínez'),
('09876', 'Ana', 'López');
