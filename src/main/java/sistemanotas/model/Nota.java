/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemanotas.model;

/**
 * Clase que representa las calificaciones de un Estudiante
 * en una Asignatura específica.
 *
 * Conceptos POO aplicados:
 * - Encapsulamiento: atributos private con getters/setters
 * - Implementación de IEvaluable: calcula la nota final ponderada
 */

/**
 *
 * @author ALFREDOBAUTISTAROMER
 */


public class Nota implements IEvaluable {

    private String codigoAsignatura;
    private double primerCorte;   // 30%
    private double segundoCorte;  // 30%
    private double tercerCorte;   // 40%

    // Constructor
    public Nota(String codigoAsignatura, double primerCorte,
                double segundoCorte, double tercerCorte) {
        this.codigoAsignatura = codigoAsignatura;
        this.primerCorte = primerCorte;
        this.segundoCorte = segundoCorte;
        this.tercerCorte = tercerCorte;
    }

    // Getters
    public String getCodigoAsignatura() { return codigoAsignatura; }
    public double getPrimerCorte() { return primerCorte; }
    public double getSegundoCorte() { return segundoCorte; }
    public double getTercerCorte() { return tercerCorte; }

    // Setters
    public void setCodigoAsignatura(String codigoAsignatura) {
        this.codigoAsignatura = codigoAsignatura;
    }
    public void setPrimerCorte(double primerCorte) {
        this.primerCorte = primerCorte;
    }
    public void setSegundoCorte(double segundoCorte) {
        this.segundoCorte = segundoCorte;
    }
    public void setTercerCorte(double tercerCorte) {
        this.tercerCorte = tercerCorte;
    }

    // ── Implementación de IEvaluable ──────────────────────────

    @Override
    public double calcularNotaFinal() {
        return (primerCorte * 0.30) + (segundoCorte * 0.30) + (tercerCorte * 0.40);
    }

    @Override
    public double calcularPromedioGeneral() {
        // En Nota no aplica, el promedio general es del Estudiante
        return calcularNotaFinal();
    }

    @Override
    public boolean aprobo() {
        return calcularNotaFinal() >= 3.0;
    }

    @Override
    public String obtenerEstado() {
        return aprobo() ? "Aprobado" : "Reprobado";
    }

    // ── Representación en texto (para guardar en archivo) ─────
    public String mostrarInfo() {
        return "Asignatura: " + codigoAsignatura +
               " | 1er Corte: " + primerCorte +
               " | 2do Corte: " + segundoCorte +
               " | 3er Corte: " + tercerCorte +
               " | Nota Final: " + String.format("%.2f", calcularNotaFinal()) +
               " | Estado: " + obtenerEstado();
    }

    /**
     * Formato para guardar en archivo .txt
     * codigoAsignatura|primerCorte|segundoCorte|tercerCorte
     */
    public String aTexto() {
        return codigoAsignatura + "|" + primerCorte + "|" +
               segundoCorte + "|" + tercerCorte;
    }
}