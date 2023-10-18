package com.ComponentesProyecto.ProyectoAPI.repositories;

import com.ComponentesProyecto.ProyectoAPI.entity.Marca;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableScan
public interface MarcaRepository extends CrudRepository<Marca,String> {
}
