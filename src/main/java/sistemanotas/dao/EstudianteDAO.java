/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemanotas.dao;

import sistemanotas.model.Estudiante;
import sistemanotas.model.Nota;
import sistemanotas.util.RutaArchivos;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que maneja la persistencia de Estudiantes en archivo .txt
 *
 * Formato en archivo estudiantes.txt:
 * id|nombre|correo|semestre
 *
 * Formato en archivo notas.txt:
 * idEstudiante|codigoAsignatura|primerCorte|segundoCorte|tercerCorte
 */

/**
 *
 * @author ALFREDOBAUTISTAROMER
 */
public class EstudianteDAO {

    /**
     * Guarda un estudiante en el archivo .txt
     * @param estudiante
     */
    public void guardar(Estudiante estudiante) {
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(RutaArchivos.ESTUDIANTES, true))) {
            bw.write(estudiante.getId() + "|" +
                     estudiante.getNombre() + "|" +
                     estudiante.getCorreo() + "|" +
                     estudiante.getSemestre());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar estudiante: " + e.getMessage());
        }
    }

    /**
     * Busca un estudiante por su ID.
     * Retorna null si no lo encuentra.
     */
    public Estudiante buscarPorId(String id) {
        try (BufferedReader br = new BufferedReader(
                new FileReader(RutaArchivos.ESTUDIANTES))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] datos = linea.split("\\|");
                if (datos[0].equals(id)) {
                    return new Estudiante(datos[0], datos[1], datos[2], datos[3]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al buscar estudiante: " + e.getMessage());
        }
        return null;
    }

    /**
     * Retorna la lista de todos los estudiantes.
     */
    public List<Estudiante> listarTodos() {
        List<Estudiante> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new FileReader(RutaArchivos.ESTUDIANTES))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] datos = linea.split("\\|");
                lista.add(new Estudiante(datos[0], datos[1], datos[2], datos[3]));
            }
        } catch (IOException e) {
            System.out.println("Error al listar estudiantes: " + e.getMessage());
        }
        return lista;
    }

    /**
     * Elimina un estudiante por su ID reescribiendo el archivo.
     */
    public void eliminar(String id) {
        List<Estudiante> lista = listarTodos();
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(RutaArchivos.ESTUDIANTES, false))) {
            for (Estudiante e : lista) {
                if (!e.getId().equals(id)) {
                    bw.write(e.getId() + "|" + e.getNombre() + "|" +
                             e.getCorreo() + "|" + e.getSemestre());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al eliminar estudiante: " + e.getMessage());
        }
    }

    /**
     * Verifica si ya existe un estudiante con ese ID.
     */
    public boolean existeId(String id) {
        return buscarPorId(id) != null;
    }
}
