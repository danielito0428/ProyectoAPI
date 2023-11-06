package com.ComponentesProyecto.ProyectoAPI.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "marcas")
@Data

@AllArgsConstructor
@NoArgsConstructor
public class Marca {


    @Id
    private String _id;

    private String nombre_marca;

    private String num_expediente;

    private String fecha_registro;

    private String detalle;

    private String nombre_solicitante;
    private String logo;

    private double clase_niza;




}
