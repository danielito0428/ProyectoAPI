package com.ComponentesProyecto.ProyectoAPI.controller;


import com.ComponentesProyecto.ProyectoAPI.entity.Marca;
import com.ComponentesProyecto.ProyectoAPI.repositories.MarcaRepository;
import com.ComponentesProyecto.ProyectoAPI.service.MarcaService;
import com.ComponentesProyecto.ProyectoAPI.service.MarcaServiceIml;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {


    private final MarcaRepository marcaRepository;

    private final MarcaServiceIml marcaServiceIml;

    public MarcaController(MarcaRepository marcaRepository, MarcaServiceIml marcaServiceIml){
        this.marcaRepository = marcaRepository;
        this.marcaServiceIml = marcaServiceIml;
    }

    @GetMapping
    public ResponseEntity<List<Marca>> getMarcas(){
        return ResponseEntity.ok(this.marcaServiceIml.getMarcasList());

    }
    @PostMapping("/newMarca")
    public ResponseEntity<Marca> saveMarca(@RequestBody Marca marca){
        return ResponseEntity.ok(this.marcaServiceIml.saveMarca(marca));
    }

    @GetMapping("/byName/{marca_nombre}")
    public ResponseEntity<Marca> getMarcaByName(Model model, @PathVariable String marca_nombre){
        return ResponseEntity.ok(this.marcaServiceIml.getMarcaByName(marca_nombre));

    }
    @GetMapping("/byMarcaID/{marca_id}")
    public ResponseEntity<Marca> getMarcaByMarcaID(Model model, @PathVariable String marca_id){
        return ResponseEntity.ok(this.marcaServiceIml.findByMarcaId(marca_id));

    }

    @PutMapping("/updateMarca/{marca_id}")
    public ResponseEntity<Marca> updateMarca(@PathVariable String marca_id, @RequestBody Marca marca){
        return ResponseEntity.ok(this.marcaServiceIml.updateMarca(marca_id,marca));
    }
    @DeleteMapping("/delMarca/{id}")
    public void deleteMarca(@PathVariable String id){
        this.marcaServiceIml.deleteMarca(id);
    }
}
