/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemanotas.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un Estudiante del sistema.
 *
 * Conceptos POO aplicados:
 * - Herencia: extiende Persona
 * - Implementación de interfaz: IEvaluable
 * - Encapsulamiento: atributos private con getters/setters
 * - Composición: tiene una lista de Nota
 */

/**
 *
 * @author ALFREDOBAUTISTAROMER
 */
public class Estudiante extends Persona implements IEvaluable{
    private String semestre;
    private List<Nota> notas;

    // Constructor
    public Estudiante(String id, String nombre, String correo, String semestre) {
        super(id, nombre, correo); // llama al constructor de Persona
        this.semestre = semestre;
        this.notas = new ArrayList<>();
    }

    // Getters y Setters
    public String getSemestre() { return semestre; }
    public void setSemestre(String semestre) { this.semestre = semestre; }
    public List<Nota> getNotas() { return notas; }

    // Agregar una nota al estudiante
    public void agregarNota(Nota nota) {
        this.notas.add(nota);
    }

    /**
     * Retorna las notas de una asignatura específica.
     */
    public Nota getNotaPorAsignatura(String codigoAsignatura) {
        for (Nota nota : notas) {
            if (nota.getCodigoAsignatura().equals(codigoAsignatura)) {
                return nota;
            }
        }
        return null;
    }

    // ── Implementación de IEvaluable ──────────────────────────
    @Override
    public double calcularNotaFinal() {
        // No aplica directamente en Estudiante
        // La nota final se calcula en cada objeto Nota
        return 0;
    }

    @Override
    public double calcularPromedioGeneral() {
        if (notas.isEmpty()) return 0.0;
        double suma = 0;
        for (Nota nota : notas) {
            suma += nota.calcularNotaFinal();
        }
        return suma / notas.size();
    }

    @Override
    public boolean aprobo() {
        return calcularPromedioGeneral() >= 3.0;
    }

    @Override
    public String obtenerEstado() {
        return aprobo() ? "Aprobado" : "Reprobado";
    }

    // ── Implementación de Persona ─────────────────────────────
    @Override
    public String mostrarInfo() {
        return "Estudiante [" + getId() + "] " + getNombre() +
               " | Semestre: " + semestre +
               " | Correo: " + getCorreo();
    }    
}
