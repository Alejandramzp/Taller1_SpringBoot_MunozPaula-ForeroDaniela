<p align= "center"><img  width="70%" src= "https://www.xamai.com/hubfs/Miniaturas%20junio%20%282%29-3.webp"></p>

<h1 align= "center"> 📦 API para la Gestión de Inventarios DP 📦 </h1> 

## Descipción
La API de Gestión de Inventarios DP es una herramienta diseñada para gestionar ítems de productos alimenticios dentro de un sistema de inventarios. 
Esta aplicación permite llevar a cabo operaciones CRUD sobre ítems, categorías e inventarios, facilitando así una administración eficiente y organizada de los productos.

## Características de la API
- Crear, Obtener, Actualizar y Eliminar Ítems en el sistema. 
- Crear, Obtener, Actualizar y Eliminar Categorías en el sistema.
- Crear, Obtener, Actualizar y Eliminar Inventarios en el sistema.

## Diagramas de la BBDD
- [Diagramas BBDD](https://viewer.diagrams.net/?tags=%7B%7D&lightbox=1&target=blank&highlight=0000ff&edit=_blank&layers=1&nav=1&title=Diagramas.drawio#Uhttps%3A%2F%2Fdrive.google.com%2Fuc%3Fid%3D1RjJ4lEj4A9GKeTOaMorOQhtqp8yXFs-G%26export%3Ddownload)

Tablas de la BBDD inventario:
```sql
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
```

## Documentación de la API: 
- [Swaggerhub - API](https://app.swaggerhub.com/apis-docs/PaulaMunoz/Inventario/1.0.0)


## Desarrolladores

- [@Alejandramzp](https://github.com/Alejandramzp)  -- Backend
- [@furekinux](https://github.com/furekinux)  -- Frontend

## Herramientas de Desarrollo
![Logo](https://i.imgur.com/ZqPTaa7.png)
![Logo](https://i.imgur.com/QbMYmHD.png)
![Logo](https://i.imgur.com/Ge8T2tx.png)
![Logo](https://i.imgur.com/diYYBqb.png)
![Logo](https://i.imgur.com/A5cxfad.png)
![Logo](https://i.imgur.com/72NBKRh.png)
