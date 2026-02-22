/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Practica_JosueAlfaroZumbado.repository;

import Practica_JosueAlfaroZumbado.domain.Arbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArbolRepository extends JpaRepository<Arbol, Long> {
}
