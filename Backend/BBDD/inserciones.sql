insert into categoria(nombre) values
("Granos"),
("Verduras"),
("Frutas"),
("Productos lácteos"),
("Proteínas");

insert into item(id_item,nombre,proveedor,id_categoria,precio,imagen) values
(1,"Arvejas","Diana",1,2990,"https://imgur.com/JK8MmOs"),
(2,"Vegetales Frescos","La Huerta",2,8900,"https://imgur.com/BHYStSM"),
(3,"Duraznos en Mitades","La Huerta",3,8900,"https://imgur.com/42bcE4i"),
(4,"Avena","Colanta",4,1200,"https://imgur.com/srain2R"),
(5,"Mortadela Clásica de pollo","Mac Pollo",5,7000,"https://imgur.com/mGVb93c");

insert into inventario(id_inventario,id_item,cantidad,disponibilidad,fecha_vencimiento) values
(1,1,56,true,'2024-12-24'),
(2,2,78,true,'2024-10-02'),
(3,3,48,false,'2024-10-02'),
(4,4,75,true,'2025-03-20'),
(5,5,185,false,'2024-11-01');