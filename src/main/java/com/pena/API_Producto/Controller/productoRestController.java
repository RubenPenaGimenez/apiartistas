package com.pena.API_Producto.Controller;

import com.pena.API_Producto.Modelo.Artistas;
import com.pena.API_Producto.Service.artistaService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class artistaRestController {

    private final artistaService artistService;

    @GetMapping("/artistas/")
    public List<Artistas> ListArtistas() {
        return artistService.listArtistas();
    }
    
    @GetMapping("/artistas/{idArtista}")
    public ResponseEntity<Artistas> obtainArtista(@PathVariable Integer idArtista) {
        try{
            Artistas artistaExistente = artistService.obtainArtistaById(idArtista);
            return ResponseEntity.ok(artistaExistente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/artistas/")
    public void newArtista (@RequestBody Artistas artista) {
        artistService.saveArtista(artista);
    }
    
    @PutMapping("/artistas/{idArtista}")
    public ResponseEntity<?> editArtista(@RequestBody Artistas artista, @PathVariable Integer idArtista) {
        try{
            Artistas artistaExistente = artistService.obtainArtistaById(idArtista);
            artistaExistente.setNombreArtista(artista.getNombreArtista());
            artistaExistente.setFechaDeRegistro(artista.getFechaDeRegistro());
            artistService.saveArtista(artistaExistente);
            return new ResponseEntity<Artistas>(artista, HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<Artistas>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/producto/{idArtista}")
    public void deleteArtista(@PathVariable Integer idArtista) {
        artistService.deleteArtista(idArtista);
    }
}


