package com.pena.API_Producto.Service;

import com.pena.API_Producto.Modelo.Artistas;
import com.pena.API_Producto.Repository.artistaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class artistaService {

    @Autowired

    private artistaRepository repository;

    public List<Artistas> listArtistas() {
        return repository.findAll();
    }

    public void saveArtista(Artistas artista) {
        repository.save(artista);
    }

    public Artistas obtainArtistaById(Integer idArtista) {
        return repository.findById(idArtista).get();
    }

    public void deleteArtista(Integer idArtista) {
        repository.deleteById(idArtista);
    }
}
