package com.ComponentesProyecto.ProyectoAPI.service;

import com.ComponentesProyecto.ProyectoAPI.entity.Marca;

import java.util.List;

public interface MarcaService {
    List<Marca> getMarcasList();
    Marca saveMarca(Marca marca);
    Marca getMarcaById(String id);
    Marca updateMarca(String id, Marca marca);
    void deleteMarca(String id);
}
