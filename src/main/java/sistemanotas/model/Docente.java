/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemanotas.model;

/**
 * Clase que representa un Docente del sistema.
 *
 * Conceptos POO aplicados:
 * - Herencia: extiende Persona
 * - Polimorfismo: implementa mostrarInfo() a su manera
 * - Encapsulamiento: atributos private con getters/setters
 */

/**
 *
 * @author ALFREDOBAUTISTAROMER
 */
public class Docente extends Persona {

    private String departamento;

    // Constructor
    public Docente(String id, String nombre, String correo, String departamento) {
        super(id, nombre, correo); // llama al constructor de Persona
        this.departamento = departamento;
    }

    // Getter y Setter
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    // ── Implementación de Persona ─────────────────────────────

    @Override
    public String mostrarInfo() {
        return "Docente [" + getId() + "] " + getNombre() +
               " | Departamento: " + departamento +
               " | Correo: " + getCorreo();
    }
}
