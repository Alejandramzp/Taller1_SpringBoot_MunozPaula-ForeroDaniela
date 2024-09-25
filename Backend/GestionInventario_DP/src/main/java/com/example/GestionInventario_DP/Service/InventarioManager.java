package com.example.GestionInventario_DP.Service;

import com.example.GestionInventario_DP.Model.Categoria;
import com.example.GestionInventario_DP.Model.Inventario;
import com.example.GestionInventario_DP.Model.Item;
import com.example.GestionInventario_DP.Repository.CategoriaRepository;
import com.example.GestionInventario_DP.Repository.InventarioRepository;
import com.example.GestionInventario_DP.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioManager {

    //--------------------- Item ----------------------
    @Autowired
    private ItemRepository itemRepository;

    //Guardar un item
    public Item saveItem(Item item){
        return itemRepository.save(item);
    }

    //Obtener todos los items
    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    //Obtener un item por ID
    public Optional<Item> getIntemById(Integer id){
        return itemRepository.findById(id);
    }

    //Actualizar un item por ID
    public Item updateItem(Integer id, Item itemDetalles){
        Item item = itemRepository.findById(id).orElseThrow();
        item.setNombre(itemDetalles.getNombre());
        item.setDescripcion((itemDetalles.getDescripcion()));
        item.setProovedor(itemDetalles.getProovedor());
        item.setId_categoria(itemDetalles.getId_categoria());
        item.setPrecio(itemDetalles.getPrecio());
        item.setImagen(itemDetalles.getImagen());
        return itemRepository.save(item);
    }

    //Eliminar un item por ID
    public void deleteItem(Integer id){
        itemRepository.deleteById(id);
    }

    //--------------------- Categoria ----------------------
    @Autowired
    private CategoriaRepository categoriaRepository;

    //Guardar una categoria
    public Categoria saveCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    //Obtener todos las categorias
    public List<Categoria> getAllCategorias(){
        return categoriaRepository.findAll();
    }

    //Obtener una categoria por ID
    public Optional<Categoria> getCategoriaById(Integer id){
        return categoriaRepository.findById(id);
    }

    //Actualizar una categoria por ID
    public Categoria updateCategoria(Integer id, Categoria categoriaDetalles){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow();
        categoria.setNombre(categoriaDetalles.getNombre());
        return categoriaRepository.save(categoria);
    }

    //Eliminar una categoria por ID
    public void deleteCategoria(Integer id){
        categoriaRepository.deleteById(id);
    }

    //--------------------- Inventario ----------------------
    @Autowired
    private InventarioRepository inventarioRepository;

    //Guardar un inventario
    public Inventario saveInventario(Inventario inventario){
        return inventarioRepository.save(inventario);
    }

    //Obtener todos los inventarios
    public List<Inventario> getAllInventarios(){
        return inventarioRepository.findAll();
    }

    //Obtener un inventario por ID
    public Optional<Inventario> getInventarioById(Integer id){
        return inventarioRepository.findById(id);
    }

    //Actualizar un inventario por ID
    public Inventario updateInventario(Integer id, Inventario inventarioDetalles){
        Inventario inventario = inventarioRepository.findById(id).orElseThrow();
        inventario.setId_item(inventarioDetalles.getId_item());
        inventario.setCantidad(inventarioDetalles.getCantidad());
        inventario.setDisponibilidad(inventarioDetalles.isDisponibilidad());
        inventario.setFecha_vencimiento(inventarioDetalles.getFecha_vencimiento());
        return inventarioRepository.save(inventario);
    }

    //Eliminar un inventario por ID
    public void deleteInventario(Integer id){
        inventarioRepository.deleteById(id);
    }
}
