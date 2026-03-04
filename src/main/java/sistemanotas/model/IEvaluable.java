/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemanotas.model;

/**
 * Interfaz que define el contrato de evaluación.
 * La implementa cualquier entidad que pueda ser calificada.
 *
 * Conceptos POO aplicados:
 * - Interfaz: define comportamiento sin implementarlo
 * - Abstracción: establece QUÉ se hace, no CÓMO
 */

/**
 *
 * @author ALFREDOBAUTISTAROMER
 */
public interface IEvaluable {
    /**
     * Calcula la nota final ponderada de una asignatura.
     * Formula: (primerCorte * 0.30) + (segundoCorte * 0.30) + (tercerCorte * 0.40)
     * @return nota final entre 0.0 y 5.0
     */
    double calcularNotaFinal();

    /**
     * Calcula el promedio general de todas las asignaturas.
     * @return promedio entre 0.0 y 5.0
     */
    double calcularPromedioGeneral();

    /**
     * Determina si aprobó (promedio general >= 3.0)
     * @return true si aprobó
     */
    boolean aprobo();

    /**
     * Retorna el estado académico como texto.
     * @return "Aprobado" o "Reprobado"
     */
    String obtenerEstado();    
}
