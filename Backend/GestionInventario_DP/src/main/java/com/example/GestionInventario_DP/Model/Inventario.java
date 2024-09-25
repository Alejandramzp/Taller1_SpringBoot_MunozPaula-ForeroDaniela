package com.example.GestionInventario_DP.Model;

import jakarta.persistence.*;

@Entity
@Table(name="inventario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_inventario;

    private int id_item;
    private int cantidad;
    private boolean disponibilidad;
    private String fecha_vencimiento;

    public Inventario() {
    }

    public Inventario(int id_inventario, int id_item, int cantidad, boolean disponibilidad, String fecha_vencimiento) {
        this.id_inventario = id_inventario;
        this.id_item = id_item;
        this.cantidad = cantidad;
        this.disponibilidad = disponibilidad;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getId_inventario() {
        return id_inventario;
    }

    public int getId_item() {
        return id_item;
    }
    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }
    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }
}
