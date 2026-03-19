/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemanotas.dao;

import sistemanotas.model.Asignatura;
import sistemanotas.model.Docente;
import sistemanotas.util.RutaArchivos;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que maneja la persistencia de Asignaturas en archivo .txt
 *
 * Formato en archivo asignaturas.txt:
 * codigo|nombre|idDocente
 */

/**
 *
 * @author ALFREDOBAUTISTAROMER
 */
public class AsignaturaDAO {

    private DocenteDAO docenteDAO;

    public AsignaturaDAO() {
        this.docenteDAO = new DocenteDAO();
    }

    /**
     * Guarda una asignatura en el archivo .txt
     */
    public void guardar(Asignatura asignatura) {
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(RutaArchivos.ASIGNATURAS, true))) {
            bw.write(asignatura.aTexto());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar asignatura: " + e.getMessage());
        }
    }

    /**
     * Busca una asignatura por su código.
     * Retorna null si no la encuentra.
     */
    public Asignatura buscarPorCodigo(String codigo) {
        try (BufferedReader br = new BufferedReader(
                new FileReader(RutaArchivos.ASIGNATURAS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] datos = linea.split("\\|");
                if (datos[0].equals(codigo)) {
                    Docente docente = docenteDAO.buscarPorId(datos[2]);
                    return new Asignatura(datos[0], datos[1], docente);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al buscar asignatura: " + e.getMessage());
        }
        return null;
    }

    /**
     * Retorna la lista de todas las asignaturas.
     */
    public List<Asignatura> listarTodas() {
        List<Asignatura> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new FileReader(RutaArchivos.ASIGNATURAS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] datos = linea.split("\\|");
                Docente docente = docenteDAO.buscarPorId(datos[2]);
                lista.add(new Asignatura(datos[0], datos[1], docente));
            }
        } catch (IOException e) {
            System.out.println("Error al listar asignaturas: " + e.getMessage());
        }
        return lista;
    }

    /**
     * Verifica si ya existe una asignatura con ese código.
     */
    public boolean existeCodigo(String codigo) {
        return buscarPorCodigo(codigo) != null;
    }
}
