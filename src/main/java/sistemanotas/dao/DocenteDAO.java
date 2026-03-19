/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemanotas.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import sistemanotas.model.Docente;
import sistemanotas.util.RutaArchivos;


/**
 * Clase que maneja la persistencia de Docentes en archivo .txt
 *
 * Formato en archivo docentes.txt:
 * id|nombre|correo|departamento
 */

/**
 *
 * @author ALFREDOBAUTISTAROMER
 */
public class DocenteDAO {

    /**
     * Guarda un docente en el archivo .txt
     */
    public void guardar(Docente docente) {
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(RutaArchivos.DOCENTES, true))) {
            bw.write(docente.getId() + "|" +
                     docente.getNombre() + "|" +
                     docente.getCorreo() + "|" +
                     docente.getDepartamento());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar docente: " + e.getMessage());
        }
    }

    /**
     * Busca un docente por su ID.
     * Retorna null si no lo encuentra.
     */
    public Docente buscarPorId(String id) {
        try (BufferedReader br = new BufferedReader(
                new FileReader(RutaArchivos.DOCENTES))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] datos = linea.split("\\|");
                if (datos[0].equals(id)) {
                    return new Docente(datos[0], datos[1], datos[2], datos[3]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al buscar docente: " + e.getMessage());
        }
        return null;
    }

    /**
     * Retorna la lista de todos los docentes.
     */
    public List<Docente> listarTodos() {
        List<Docente> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new FileReader(RutaArchivos.DOCENTES))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] datos = linea.split("\\|");
                lista.add(new Docente(datos[0], datos[1], datos[2], datos[3]));
            }
        } catch (IOException e) {
            System.out.println("Error al listar docentes: " + e.getMessage());
        }
        return lista;
    }

    /**
     * Verifica si ya existe un docente con ese ID.
     */
    public boolean existeId(String id) {
        return buscarPorId(id) != null;
    }
}
