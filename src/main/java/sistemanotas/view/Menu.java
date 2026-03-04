/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemanotas.view;
import sistemanotas.model.Estudiante;
import sistemanotas.service.EstudianteService;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que maneja el menú principal del sistema en consola.
 * Se irá ampliando con cada nueva clase que se desarrolle.
 *
 * Conceptos POO aplicados:
 * - Arquitectura en capas: View solo habla con Service
 * - Nunca accede directamente al DAO ni al Model
 */

/**
 *
 * @author ALFREDOBAUTISTAROMER
 */
public class Menu {

    private Scanner scanner;
    private EstudianteService estudianteService;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.estudianteService = new EstudianteService();
    }

    /**
     * Inicia el menú principal del sistema.
     */
    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║   SISTEMA DE NOTAS           ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║  1. Gestion de Estudiantes   ║");
            System.out.println("║  0. Salir                    ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: menuEstudiantes(); break;
                case 0: System.out.println(" Hasta luego!"); break;
                default: System.out.println("️ Opción no valida.");
            }
        } while (opcion != 0);
    }

    // ── Menú Estudiantes ─────────────────────────────────────

    private void menuEstudiantes() {
        int opcion;
        do {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║   GESTIÓN DE ESTUDIANTES     ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║  1. Registrar estudiante     ║");
            System.out.println("║  2. Listar estudiantes       ║");
            System.out.println("║  3. Buscar estudiante        ║");
            System.out.println("║  4. Eliminar estudiante      ║");
            System.out.println("║  0. Volver                   ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: registrarEstudiante(); break;
                case 2: listarEstudiantes(); break;
                case 3: buscarEstudiante(); break;
                case 4: eliminarEstudiante(); break;
                case 0: break;
                default: System.out.println("️ Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void registrarEstudiante() {
        System.out.println("\n── Registrar Estudiante ──");
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        System.out.print("Semestre: ");
        String semestre = scanner.nextLine();

        try {
            estudianteService.registrarEstudiante(id, nombre, correo, semestre);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void listarEstudiantes() {
        System.out.println("\n── Lista de Estudiantes ──");
        List<Estudiante> lista = estudianteService.listarEstudiantes();
        for (Estudiante e : lista) {
            System.out.println("  → " + e.mostrarInfo());
        }
    }

    private void buscarEstudiante() {
        System.out.println("\n── Buscar Estudiante ──");
        System.out.print("Ingrese el ID: ");
        String id = scanner.nextLine();
        try {
            Estudiante e = estudianteService.buscarEstudiante(id);
            System.out.println("  → " + e.mostrarInfo());
        } catch (IllegalArgumentException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    private void eliminarEstudiante() {
        System.out.println("\n── Eliminar Estudiante ──");
        System.out.print("Ingrese el ID: ");
        String id = scanner.nextLine();
        try {
            estudianteService.eliminarEstudiante(id);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
