package com.example.GestionInventario_DP.Controller;

import com.example.GestionInventario_DP.Model.Categoria;
import com.example.GestionInventario_DP.Model.Inventario;
import com.example.GestionInventario_DP.Model.Item;
import com.example.GestionInventario_DP.Service.InventarioManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GestionManager {

    @Autowired
    private InventarioManager inventarioManager;

    //--------------------- Item ----------------------
    //Guardar un item
    //localhost:8080/api/items con verbo POST
    @PostMapping("/items")
    public Item saveItem(@RequestBody Item item){
        return inventarioManager.saveItem(item);
    }

    //Obtener todos los items
    //localhost:8080/api/items con verbo GET
    @GetMapping("/items")
    public List<Item> getAllItems(){
        return inventarioManager.getAllItems();
    }

    //Obtener un item por ID
    //localhost:8080/api/items/id con verbo GET
    @GetMapping("/items/{id}")
    public Item getItemById(@PathVariable Integer id){
        return inventarioManager.getIntemById(id).orElseThrow();
    }

    //Actualizar un item por ID
    //localhost:8080/api/items/id con verbo PUT
    @PutMapping("/items/{id}")
    public Item updateItem(@PathVariable Integer id, @RequestBody Item item){
        return inventarioManager.updateItem(id, item);
    }

    //Eliminar un item por ID
    //localhost:8080/api/items/id con verbo DELETE
    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Integer id){
        inventarioManager.deleteItem(id);
    }

    //--------------------- Categoria ----------------------
    //Guardar una categoria
    //localhost:8080/api/categorias con verbo POST
    @PostMapping("/categorias")
    public Categoria saveCategoria(@RequestBody Categoria categoria){
        return inventarioManager.saveCategoria(categoria);
    }

    //Obtener todos las categorias
    //localhost:8080/api/categorias con verbo GET
    @GetMapping("/categorias")
    public List<Categoria> getAllCategorias(){
        return inventarioManager.getAllCategorias();
    }

    //Obtener una categoria por ID
    //localhost:8080/api/categorias/id con verbo GET
    @GetMapping("/categorias/{id}")
    public Categoria getCategoriaById(@PathVariable Integer id){
        return inventarioManager.getCategoriaById(id).orElseThrow();
    }

    //Actualizar una categoria por ID
    //localhost:8080/api/categorias/id con verbo PUT
    @PutMapping("/categorias/{id}")
    public Categoria updateCategoria(@PathVariable Integer id, @RequestBody Categoria categoria){
        return inventarioManager.updateCategoria(id, categoria);
    }

    //Eliminar una categoria por ID
    //localhost:8080/api/categorias/id con verbo DELETE
    @DeleteMapping("/categorias/{id}")
    public void deleteCategoria(@PathVariable Integer id){
        inventarioManager.deleteCategoria(id);
    }

    //--------------------- Inventario ----------------------
    //Guardar un inventario
    //localhost:8080/api/inventario con verbo POST
    @PostMapping("/inventarios")
    public Inventario saveInventario(@RequestBody Inventario inventario){
        return inventarioManager.saveInventario(inventario);
    }

    //Obtener todos los inventarios
    //localhost:8080/api/inventarios con verbo GET
    @GetMapping("/inventarios")
    public List<Inventario> getAllInventarios(){
        return inventarioManager.getAllInventarios();
    }

    //Obtener un inventario por ID
    //localhost:8080/api/inventarios/id con verbo GET
    @GetMapping("/inventarios/{id}")
    public Inventario getInventarioById(@PathVariable Integer id){
        return inventarioManager.getInventarioById(id).orElseThrow();
    }

    //Actualizar un inventario por ID
    //localhost:8080/api/inventarios/id con verbo PUT
    @PutMapping("/inventarios/{id}")
    public Inventario updateInventario(@PathVariable Integer id, @RequestBody Inventario inventario){
        return inventarioManager.updateInventario(id, inventario);
    }

    //Eliminar un inventario por ID
    //localhost:8080/api/inventarios/id con verbo DELETE
    @DeleteMapping("/inventarios/{id}")
    public void deleteInventario(@PathVariable Integer id){
        inventarioManager.deleteInventario(id);
    }
}
