package com.example.GestionInventario_DP.Repository;

import com.example.GestionInventario_DP.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
