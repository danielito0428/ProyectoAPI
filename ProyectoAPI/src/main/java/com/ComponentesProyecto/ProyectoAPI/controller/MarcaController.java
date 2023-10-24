package com.ComponentesProyecto.ProyectoAPI.controller;


import com.ComponentesProyecto.ProyectoAPI.entity.Marca;
import com.ComponentesProyecto.ProyectoAPI.service.MarcaService;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/marcas")
public class MarcaController {

    @Autowired
    MarcaService marcaService;


    @PostMapping("/newMarca")
    public ResponseEntity<Marca> saveMarca(@RequestBody Marca marca){
        return ResponseEntity.ok(marcaService.saveMarca(marca));
    }

    @GetMapping("/test")
    public String test(){
        return "Test";
    }

    @GetMapping("/marca/{id}")
    public ResponseEntity<Marca> getMarcabyId(@PathVariable String id){
        return ResponseEntity.ok(marcaService.getMarcaById(id));
    }

    @GetMapping("/getMarcas")
    public ResponseEntity<List<Marca>> getMarcasList(){
        return ResponseEntity.ok(marcaService.getMarcasList());

    }

    @PutMapping("/updateMarca/{id}")
    public ResponseEntity<Marca> updateMarca(@PathVariable String id,@RequestBody Marca marca){
        return ResponseEntity.ok(marcaService.updateMarca(id,marca));

    }

    @DeleteMapping("/delMarca/{id}")
    public void deleteMarca(@PathVariable String id){
         marcaService.deleteMarca(id);
    }

}
