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

import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin(origins = {"https://reactcomponentes.azurewebsites.net", "http://localhost:3000/"})
@RestController
@RequestMapping("/api")
public class MarcaController {


    private final MarcaRepository marcaRepository;

    private final MarcaServiceIml marcaServiceIml;

    public MarcaController(MarcaRepository marcaRepository, MarcaServiceIml marcaServiceIml){
        this.marcaRepository = marcaRepository;
        this.marcaServiceIml = marcaServiceIml;
    }

    @GetMapping("/marcas")
    public ResponseEntity<List<Marca>> getMarcas(){
        return ResponseEntity.ok(this.marcaServiceIml.getMarcasList());

    }
    @PostMapping("/marcas")
    public ResponseEntity<Marca> saveMarca(@RequestBody Marca marca) throws URISyntaxException {
        return ResponseEntity.ok(this.marcaServiceIml.saveMarca(marca));
    }

    @GetMapping("/marcas/{nombre_marca}")
    public ResponseEntity<Marca> getMarcaByName(Model model, @PathVariable String nombre_marca){
        return ResponseEntity.ok(this.marcaServiceIml.getMarcaByName(nombre_marca));

    }
    @GetMapping("/{marca_id}")
    public ResponseEntity<Marca> getMarcaByMarcaID(Model model, @PathVariable String marca_id){
        return ResponseEntity.ok(this.marcaServiceIml.getMarcaById(marca_id));

    }

    @PutMapping("/marcas/{marca_id}")
    public ResponseEntity<Marca> updateMarca(@PathVariable String marca_id, @RequestBody Marca marca){
        return ResponseEntity.ok(this.marcaServiceIml.updateMarca(marca_id,marca));
    }
    @DeleteMapping("/marcas/{id}")
    public void deleteMarca(@PathVariable String id){
        this.marcaServiceIml.deleteMarca(id);
    }
}
