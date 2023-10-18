package com.ComponentesProyecto.ProyectoAPI.service;

import com.ComponentesProyecto.ProyectoAPI.entity.Marca;
import com.ComponentesProyecto.ProyectoAPI.repositories.MarcaRepository;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServiceIml implements MarcaService {

    @Autowired
    MarcaRepository marcaRepository;


    @Override
    public List<Marca> getMarcasList() {
        return (List<Marca>) marcaRepository.findAll() ;
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
    public Marca updateMarca(String id, Marca marca) {
         marcaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("La marca no se ha encontrado: " + id));
                marca.setMarca_id(id);
         return marcaRepository.save(marca);
        //Modificar para cambiar fecha de presentacion.
    }

    @Override
    public void deleteMarca(String id) {
        marcaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("La marca no se ha encontrado: " + id));
        marcaRepository.deleteById(id);

    }
}
