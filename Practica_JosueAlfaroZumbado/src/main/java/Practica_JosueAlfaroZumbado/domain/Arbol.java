/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica_JosueAlfaroZumbado.domain;
import jakarta.persistence.*;
import java.io.Serializable;
/**
 *
 * @author jalfa
 */
@Entity
@Table(name = "arbol")
public class Arbol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arbol")
    private Long idArbol;

    @Column(name = "nombre_comun", nullable = false, length = 100)
    private String nombreComun;

    @Column(name = "tipo_flor", length = 100)
    private String tipoFlor;

    @Column(name = "dureza_madera", nullable = false)
    private Integer durezaMadera;

    @Column(name = "altura_promedio")
    private Double alturaPromedio;

    @Column(name = "ruta_imagen", length = 1024)
    private String rutaImagen;

    public Arbol() {
    }

    public Arbol(String nombreComun, String tipoFlor, Integer durezaMadera,
                  Double alturaPromedio, String rutaImagen) {
        this.nombreComun = nombreComun;
        this.tipoFlor = tipoFlor;
        this.durezaMadera = durezaMadera;
        this.alturaPromedio = alturaPromedio;
        this.rutaImagen = rutaImagen;
    }

    public Long getIdArbol() {
        return idArbol;
    }

    public void setIdArbol(Long idArbol) {
        this.idArbol = idArbol;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getTipoFlor() {
        return tipoFlor;
    }

    public void setTipoFlor(String tipoFlor) {
        this.tipoFlor = tipoFlor;
    }

    public Integer getDurezaMadera() {
        return durezaMadera;
    }

    public void setDurezaMadera(Integer durezaMadera) {
        this.durezaMadera = durezaMadera;
    }

    public Double getAlturaPromedio() {
        return alturaPromedio;
    }

    public void setAlturaPromedio(Double alturaPromedio) {
        this.alturaPromedio = alturaPromedio;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
