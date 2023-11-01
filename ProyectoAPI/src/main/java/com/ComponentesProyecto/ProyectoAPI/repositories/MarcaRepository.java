package com.ComponentesProyecto.ProyectoAPI.repositories;

import com.ComponentesProyecto.ProyectoAPI.entity.Marca;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MarcaRepository extends MongoRepository<Marca,String> {

    @Query("{nombre_marca: '?0'}")
    Marca findMarcaByName(String name);

    @Query("{marca_id: '?0'}")
    Marca findByMarcaId(String marca_id);



}
