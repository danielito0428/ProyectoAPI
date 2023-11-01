package com.ComponentesProyecto.ProyectoAPI.util;

import com.ComponentesProyecto.ProyectoAPI.entity.Marca;
import com.ComponentesProyecto.ProyectoAPI.repositories.MarcaRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final MarcaRepository marcaRepository;

    public AppStartupEvent(MarcaRepository marcaRepository){
        this.marcaRepository = marcaRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Marca> marcas = marcaRepository.findAll();
        marcas.forEach(System.out::println);

    }
}
