package com.example.GestionInventario_DP.Repository;

import com.example.GestionInventario_DP.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
