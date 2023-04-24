package com.pena.API_Producto.Repository;

import com.pena.API_Producto.Modelo.Artistas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface artistaRepository  extends JpaRepository<Artistas, Integer>{
    
}
