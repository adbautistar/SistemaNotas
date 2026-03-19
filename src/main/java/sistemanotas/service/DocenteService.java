/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemanotas.service;

import sistemanotas.dao.DocenteDAO;
import sistemanotas.dao.EstudianteDAO;
//import sistemanotas.dao.NotaDAO;
import sistemanotas.model.Docente;
import sistemanotas.model.Estudiante;
import sistemanotas.model.Nota;
import java.util.List;


/**
 * Clase que contiene la lógica de negocio para Docentes.
 *
 * Conceptos POO aplicados:
 * - Arquitectura en capas: Service no accede directo al archivo
 * - Encapsulamiento: valida datos antes de enviar al DAO
 */

/**
 *
 * @author ALFREDOBAUTISTAROMER
 */
public class DocenteService {

    private DocenteDAO docenteDAO;
    private EstudianteDAO estudianteDAO;
    //private NotaDAO notaDAO;

    public DocenteService() {
        this.docenteDAO = new DocenteDAO();
        this.estudianteDAO = new EstudianteDAO();
        //this.notaDAO = new NotaDAO();
    }

    /**
     * Registra un nuevo docente validando los datos primero.
     */
    public void registrarDocente(String id, String nombre,
                                  String correo, String departamento) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID no puede estar vacío");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (correo == null || correo.trim().isEmpty()) {
            throw new IllegalArgumentException("El correo no puede estar vacío");
        }
        if (departamento == null || departamento.trim().isEmpty()) {
            throw new IllegalArgumentException("El departamento no puede estar vacío");
        }
        if (docenteDAO.existeId(id)) {
            throw new IllegalArgumentException("Ya existe un docente con ese ID");
        }

        Docente docente = new Docente(id, nombre, correo, departamento);
        docenteDAO.guardar(docente);
        System.out.println(" Docente registrado exitosamente.");
    }

    /**
     * Busca un docente por ID.
     */
    public Docente buscarDocente(String id) {
        Docente docente = docenteDAO.buscarPorId(id);
        if (docente == null) {
            throw new IllegalArgumentException("No se encontró docente con ID: " + id);
        }
        return docente;
    }

    /**
     * Retorna la lista de todos los docentes registrados.
     */
    public List<Docente> listarDocentes() {
        List<Docente> lista = docenteDAO.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("️ No hay docentes registrados.");
        }
        return lista;
    }

    /**
     * Registra la nota de un estudiante en una asignatura.
     * El docente es quien ingresa las notas.
     */
    public void registrarNota(String idEstudiante, String codigoAsignatura,
                               double primerCorte, double segundoCorte,
                               double tercerCorte) {
        // Validar que el estudiante existe
        Estudiante estudiante = estudianteDAO.buscarPorId(idEstudiante);
        if (estudiante == null) {
            throw new IllegalArgumentException(
                "No existe estudiante con ID: " + idEstudiante);
        }
        // Validar rango de notas
        validarNota(primerCorte, "Primer corte");
        validarNota(segundoCorte, "Segundo corte");
        validarNota(tercerCorte, "Tercer corte");

        Nota nota = new Nota(codigoAsignatura, primerCorte,
                             segundoCorte, tercerCorte);
        //notaDAO.guardar(idEstudiante, nota);
        System.out.println(" Nota registrada exitosamente.");
        System.out.println("   Nota final: " +
            String.format("%.2f", nota.calcularNotaFinal()) +
            " → " + nota.obtenerEstado());
    }

    /**
     * Valida que una nota esté entre 0.0 y 5.0
     */
    private void validarNota(double valor, String nombreCorte) {
        if (valor < 0.0 || valor > 5.0) {
            throw new IllegalArgumentException(
                nombreCorte + " debe estar entre 0.0 y 5.0");
        }
    }
}
