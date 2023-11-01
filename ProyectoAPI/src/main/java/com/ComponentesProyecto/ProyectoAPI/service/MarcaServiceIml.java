package com.ComponentesProyecto.ProyectoAPI.service;

import com.ComponentesProyecto.ProyectoAPI.entity.Marca;
import com.ComponentesProyecto.ProyectoAPI.repositories.MarcaRepository;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MarcaServiceIml implements MarcaService {

    private final MarcaRepository marcaRepository;

    public MarcaServiceIml(MarcaRepository marcaRepository){
        this.marcaRepository = marcaRepository;
    }


    @Override
    public List<Marca> getMarcasList() {
        return (List<Marca>) this.marcaRepository.findAll() ;
    }

    @Override
    public Marca saveMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public Marca getMarcaById(String id) {
        return marcaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("La marca no se ha encontrado: " + id));
    }

    @Override
    public Marca updateMarca(String id, @RequestBody Marca marca) {
         marcaRepository.findById(id) .orElseThrow(()-> new ResourceNotFoundException("La marca no se ha encontrado: " + id));
         return marcaRepository.save(marca);
        //Modificar para cambiar fecha de presentacion.
    }

    @Override
    public void deleteMarca(String id) {
        marcaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("La marca no se ha encontrado: " + id));
        marcaRepository.deleteById(id);

    }

    @Override
    public Marca getMarcaByName(String marca_nombre) {

        return marcaRepository.findMarcaByName(marca_nombre);
    }

    @Override
    public Marca findByMarcaId(String marca_id) {
        return marcaRepository.findByMarcaId(marca_id);
    }


}
