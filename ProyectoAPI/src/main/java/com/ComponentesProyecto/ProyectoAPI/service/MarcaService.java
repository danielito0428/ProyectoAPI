package com.ComponentesProyecto.ProyectoAPI.service;

import com.ComponentesProyecto.ProyectoAPI.entity.Marca;

import java.net.URISyntaxException;
import java.util.List;

public interface MarcaService {
    List<Marca> getMarcasList();
    Marca saveMarca(Marca marca) throws URISyntaxException;
    Marca getMarcaById(String id);
    Marca updateMarca(String marca_id, Marca marca);
    void deleteMarca(String id);
    Marca getMarcaByName(String marca_nombre);
    Marca findByMarcaId(String marca_id);
}
