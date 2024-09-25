CREATE DATABASE inventario;

USE inventario;

CREATE TABLE categoria(
	id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(35) NOT NULL
);

CREATE TABLE item(
	id_item INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    proveedor VARCHAR(70) NOT NULL,
    id_categoria INT NOT NULL,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria),
    precio DECIMAL(10,2) NOT NULL,
    imagen TEXT
);

CREATE TABLE inventario(
	id_inventario INT AUTO_INCREMENT PRIMARY KEY,
    id_item INT NOT NULL,
    FOREIGN KEY (id_item) REFERENCES item(id_item),
    cantidad INT NOT NULL,
    disponibilidad TINYINT(1) NOT NULL,
    fecha_vencimiento DATE NOT NULL
);

SHOW TABLES;