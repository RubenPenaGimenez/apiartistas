package com.pena.API_Producto.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class Artistas { 
    @Id @GeneratedValue
    private Integer idArtista;
    
    private String nombreArtista;
    private String fechaDeRegistro;
    private String estiloMusical;
    private String correo;
    private Integer telefono;
    private Integer numeroOyentes;
    private String nombreAKA;
    private String mensaje;
    private Boolean aceptarTerminos;
}
