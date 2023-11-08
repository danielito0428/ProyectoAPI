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

    private String tipo_solicitud;

    private String subtipo_solicitud;

    private String estado;
    private double num_registro;


    public Marca(String nombre_marca, String num_expediente, String fecha_registro, String detalle,
                 String nombre_solicitante, String logo, double clase_niza, String tipo_solicitud, String subtipo_solicitud, String estado, double num_registro) {
        this.nombre_marca = nombre_marca;
        this.num_expediente = num_expediente;
        this.fecha_registro = fecha_registro;
        this.detalle = detalle;
        this.nombre_solicitante = nombre_solicitante;
        this.logo = logo;
        this.clase_niza = clase_niza;
        this.tipo_solicitud = tipo_solicitud;
        this.subtipo_solicitud = subtipo_solicitud;
        this.estado = estado;
        this.num_registro = num_registro;
    }
}
