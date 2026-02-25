package Practica_JosueAlfaroZumbado.service;

import Practica_JosueAlfaroZumbado.domain.Arbol;
import Practica_JosueAlfaroZumbado.repository.ArbolRepository;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArbolService {

    private final ArbolRepository arbolRepository;
    private final FireBaseStorageService fireBaseStorageService;

    public ArbolService(ArbolRepository arbolRepository,
                        FireBaseStorageService fireBaseStorageService) {
        this.arbolRepository = arbolRepository;
        this.fireBaseStorageService = fireBaseStorageService;
    }

    @Transactional(readOnly = true)
    public List<Arbol> listar() {
        return arbolRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Arbol obtenerPorId(Long id) {
        return arbolRepository.findById(id).orElse(null);
    }

    @Transactional
    public void eliminar(Long id) {
        arbolRepository.deleteById(id);
    }

    @Transactional
public void save(Arbol arbol, MultipartFile imagenFile) {

    // Si es edición y no viene rutaImagen en el form por alguna razón,
    // recuperar el valor actual de BD.
    if (arbol.getIdArbol() != null) {
        Arbol actual = arbolRepository.findById(arbol.getIdArbol()).orElse(null);
        if (actual != null) {
            if (arbol.getRutaImagen() == null || arbol.getRutaImagen().isBlank()) {
                arbol.setRutaImagen(actual.getRutaImagen());
            }
        }
    }

    // Guardar cambios (nombre, flor, etc.)
    arbol = arbolRepository.save(arbol);

    // Si viene imagen nueva, subir y reemplazar URL
    if (imagenFile != null && !imagenFile.isEmpty()) {
        try {
            String url = fireBaseStorageService.uploadImage(imagenFile, "arbol", arbol.getIdArbol());
            arbol.setRutaImagen(url);
            arbolRepository.save(arbol);
        } catch (IOException e) {
            throw new RuntimeException("Error subiendo imagen a Firebase", e);
        }
    }
}
}