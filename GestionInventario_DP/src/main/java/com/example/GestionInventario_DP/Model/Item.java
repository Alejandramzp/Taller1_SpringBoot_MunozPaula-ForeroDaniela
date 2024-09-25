package com.example.GestionInventario_DP.Model;

import jakarta.persistence.*;

@Entity
@Table(name="item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_item;

    private String nombre;
    private String descripcion;
    private String proovedor;
    private int id_categoria;
    private double precio;
    private String imagen;

    public Item() {
    }

    public int getId_item() {
        return id_item;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProovedor() {
        return proovedor;
    }
    public void setProovedor(String proovedor) {
        this.proovedor = proovedor;
    }

    public int getId_categoria() {
        return id_categoria;
    }
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
