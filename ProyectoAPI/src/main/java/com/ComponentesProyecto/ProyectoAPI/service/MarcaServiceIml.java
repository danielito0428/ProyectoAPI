package com.ComponentesProyecto.ProyectoAPI.service;

import com.ComponentesProyecto.ProyectoAPI.entity.Marca;
import com.ComponentesProyecto.ProyectoAPI.repositories.MarcaRepository;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class MarcaServiceIml implements MarcaService {

    Date date = new Date();
    Calendar cal = new GregorianCalendar();





    private final MarcaRepository marcaRepository;

    public MarcaServiceIml(MarcaRepository marcaRepository){
        this.marcaRepository = marcaRepository;
    }


    @Override
    public List<Marca> getMarcasList() {
        return (List<Marca>) this.marcaRepository.findAll() ;
    }


    @Override
    public Marca saveMarca(Marca marca)  {
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
                Marca _marca = marcaRepository.save(new Marca( marca.getNombre_marca(), String.valueOf(year) + "-" +Math.floor(Math.random()*99999) ,
                 marca.getFecha_registro(), marca.getDetalle(), marca.getNombre_solicitante(),marca.getLogo(),
                 marca.getClase_niza(),marca.getTipo_solicitud(), marca.getSubtipo_solicitud(), "Solicitado", Math.floor(Math.random()*999999)));

         return _marca;
    }



    @Override
    public Marca getMarcaById(String id) {
        return marcaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("La marca no se ha encontrado: " + id));
    }

    @Override
    public Marca updateMarca(String id, @RequestBody Marca marca) {
        Marca currentMarca = marcaRepository.findById(id) .orElseThrow(()-> new ResourceNotFoundException("La marca no se ha encontrado: " + id));
        currentMarca.setNombre_marca(marca.getNombre_marca());
        currentMarca.setNombre_solicitante(marca.getNombre_solicitante());
        currentMarca.setClase_niza(marca.getClase_niza());
        currentMarca.setDetalle(marca.getDetalle());
        currentMarca.setLogo(marca.getLogo());

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
