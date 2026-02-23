package Practica_JosueAlfaroZumbado.service;

import Practica_JosueAlfaroZumbado.domain.Arbol;
import Practica_JosueAlfaroZumbado.repository.ArbolRepository;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArbolService {

    private final ArbolRepository arbolRepository;

    public ArbolService(ArbolRepository arbolRepository) {
        this.arbolRepository = arbolRepository;
    }

    @Transactional
    public List<Arbol> listar() {
        return arbolRepository.findAll();
    }

    @Transactional
    public Arbol obtenerPorId(Long id) {
        return arbolRepository.findById(id).orElse(null);
    }

    @Transactional
    public void eliminar(Long id) {
        arbolRepository.deleteById(id);
    }

    @Transactional
    public void guardarConImagen(Arbol arbol, MultipartFile imagenFile) {
        // Guardar primero para asegurar ID (si es nuevo)
        arbol = arbolRepository.save(arbol);

        if (imagenFile != null && !imagenFile.isEmpty()) {
            try {
                String original = StringUtils.cleanPath(imagenFile.getOriginalFilename());
                String nombreArchivo = arbol.getIdArbol() + "_" + original;

                Path carpeta = Paths.get("src/main/resources/static/img");
                Files.createDirectories(carpeta);

                Path destino = carpeta.resolve(nombreArchivo);
                Files.copy(imagenFile.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);

                arbol.setRutaImagen("/img/" + nombreArchivo);
                arbolRepository.save(arbol);

            } catch (IOException e) {
                throw new RuntimeException("Error guardando la imagen", e);
            }
        }
    }
}