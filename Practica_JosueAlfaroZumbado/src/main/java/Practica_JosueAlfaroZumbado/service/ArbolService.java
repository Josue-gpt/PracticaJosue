/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica_JosueAlfaroZumbado.service;

import Practica_JosueAlfaroZumbado.domain.Arbol;
import Practica_JosueAlfaroZumbado.repository.ArbolRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArbolService {

    private final ArbolRepository arbolRepository;

    public ArbolService(ArbolRepository arbolRepository) {
        this.arbolRepository = arbolRepository;
    }

    public List<Arbol> listar() {
        return arbolRepository.findAll();
    }

    public Arbol obtenerPorId(Long id) {
        return arbolRepository.findById(id).orElse(null);
    }

    @Transactional
    public void guardar(Arbol arbol) {
        arbolRepository.save(arbol);
    }

    public void eliminar(Long id) {
        arbolRepository.deleteById(id);
    }
}
