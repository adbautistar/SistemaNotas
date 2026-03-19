/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemanotas.model;

/**
 * Clase que representa una Asignatura del sistema.
 *
 * Conceptos POO aplicados:
 * - Encapsulamiento: atributos private con getters/setters
 * - Asociación: tiene una referencia a Docente
 */

/**
 *
 * @author ALFREDOBAUTISTAROMER
 */

public class Asignatura {

    private String codigo;
    private String nombre;
    private Docente docente;

    // Constructor
    public Asignatura(String codigo, String nombre, Docente docente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.docente = docente;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Docente getDocente() { return docente; }
    public void setDocente(Docente docente) { this.docente = docente; }

    public String mostrarInfo() {
        return "Asignatura [" + codigo + "] " + nombre +
               " | Docente: " + docente.getNombre();
    }

    /**
     * Formato para guardar en archivo .txt
     * codigo|nombre|idDocente
     */
    public String aTexto() {
        return codigo + "|" + nombre + "|" + docente.getId();
    }
}