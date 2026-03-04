/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemanotas.model;
/**
 * Clase abstracta que representa cualquier persona del sistema.
 * Es la clase padre de Estudiante y Docente.
 *
 * Conceptos POO aplicados:
 * - Abstracción: no se puede instanciar directamente
 * - Encapsulamiento: atributos private con getters/setters
 * - Polimorfismo: mostrarInfo() es abstracto, cada hijo lo implementa
 */

/**
 *
 * @author ALFREDOBAUTISTAROMER
 */
public abstract class Persona {
    //atributos para la super clase persona
    private String id;
    private String nombre;
    private String correo;
    
    //constructor
    public Persona(String id, String nombre, String correo){
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;   
    }
    
    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCorreo(String correo) { this.correo = correo; }

    //Método abstracto: cada subclase lo implementa a su manera.
    public abstract String mostrarInfo();
    
}
