package com.example.GestionInventario_DP.Repository;

import com.example.GestionInventario_DP.Model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
}
