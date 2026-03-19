

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemanotas.service;

import sistemanotas.dao.AsignaturaDAO;
import sistemanotas.dao.DocenteDAO;
import sistemanotas.model.Asignatura;
import sistemanotas.model.Docente;
import java.util.List;


/**
 * Clase que contiene la lógica de negocio para Asignaturas.
 *
 * Conceptos POO aplicados:
 * - Arquitectura en capas: Service no accede directo al archivo
 * - Encapsulamiento: valida datos antes de enviar al DAO
 */

/**
 *
 * @author ALFREDOBAUTISTAROMER
 */


public class AsignaturaService {

    private AsignaturaDAO asignaturaDAO;
    private DocenteDAO docenteDAO;

    public AsignaturaService() {
        this.asignaturaDAO = new AsignaturaDAO();
        this.docenteDAO = new DocenteDAO();
    }

    /**
     * Registra una nueva asignatura validando los datos primero.
     */
    public void registrarAsignatura(String codigo, String nombre,
                                     String idDocente) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede estar vacío");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (idDocente == null || idDocente.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del docente no puede estar vacío");
        }
        if (asignaturaDAO.existeCodigo(codigo)) {
            throw new IllegalArgumentException("Ya existe una asignatura con ese código");
        }

        // Verificar que el docente existe
        Docente docente = docenteDAO.buscarPorId(idDocente);
        if (docente == null) {
            throw new IllegalArgumentException("No existe docente con ID: " + idDocente);
        }

        Asignatura asignatura = new Asignatura(codigo, nombre, docente);
        asignaturaDAO.guardar(asignatura);
        System.out.println("✅ Asignatura registrada exitosamente.");
    }

    /**
     * Busca una asignatura por su código.
     */
    public Asignatura buscarAsignatura(String codigo) {
        Asignatura asignatura = asignaturaDAO.buscarPorCodigo(codigo);
        if (asignatura == null) {
            throw new IllegalArgumentException(
                "No se encontró asignatura con código: " + codigo);
        }
        return asignatura;
    }

    /**
     * Retorna la lista de todas las asignaturas registradas.
     */
    public List<Asignatura> listarAsignaturas() {
        List<Asignatura> lista = asignaturaDAO.listarTodas();
        if (lista.isEmpty()) {
            System.out.println("⚠️ No hay asignaturas registradas.");
        }
        return lista;
    }
}