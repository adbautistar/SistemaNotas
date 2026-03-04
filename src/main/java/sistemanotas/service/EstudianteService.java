/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemanotas.service;

import sistemanotas.dao.EstudianteDAO;
import sistemanotas.model.Estudiante;
import sistemanotas.model.Nota;
import java.util.List;

/**
 * Clase que contiene la lógica de negocio para Estudiantes.
 * Es el intermediario entre la Vista y el DAO.
 *
 * Conceptos POO aplicados:
 * - Arquitectura en capas: Service no accede directo al archivo
 * - Encapsulamiento: valida datos antes de enviar al DAO

/**
 *
 * @author ALFREDOBAUTISTAROMER
 */
public class EstudianteService {

    private EstudianteDAO estudianteDAO;

    public EstudianteService() {
        this.estudianteDAO = new EstudianteDAO();
    }

    /**
     * Registra un nuevo estudiante validando los datos primero.
     */
    public void registrarEstudiante(String id, String nombre,
                                    String correo, String semestre) {
        // Validaciones de negocio
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID no puede estar vacío");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (correo == null || correo.trim().isEmpty()) {
            throw new IllegalArgumentException("El correo no puede estar vacío");
        }
        if (semestre == null || semestre.trim().isEmpty()) {
            throw new IllegalArgumentException("El semestre no puede estar vacío");
        }
        if (estudianteDAO.existeId(id)) {
            throw new IllegalArgumentException("Ya existe un estudiante con ese ID");
        }

        Estudiante estudiante = new Estudiante(id, nombre, correo, semestre);
        estudianteDAO.guardar(estudiante);
        System.out.println("✅ Estudiante registrado exitosamente.");
    }

    /**
     * Busca un estudiante por ID y carga sus notas.
     */
    public Estudiante buscarEstudiante(String id) {
        Estudiante estudiante = estudianteDAO.buscarPorId(id);
        if (estudiante == null) {
            throw new IllegalArgumentException("No se encontró estudiante con ID: " + id);
        }
        return estudiante;
    }

    /**
     * Retorna la lista de todos los estudiantes registrados.
     */
    public List<Estudiante> listarEstudiantes() {
        List<Estudiante> lista = estudianteDAO.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("⚠️ No hay estudiantes registrados.");
        }
        return lista;
    }

    /**
     * Elimina un estudiante por su ID.
     */
    public void eliminarEstudiante(String id) {
        if (!estudianteDAO.existeId(id)) {
            throw new IllegalArgumentException("No existe estudiante con ID: " + id);
        }
        estudianteDAO.eliminar(id);
        System.out.println("✅ Estudiante eliminado exitosamente.");
    }
}
