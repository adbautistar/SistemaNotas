/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemanotas.view;
import sistemanotas.model.Estudiante;
import sistemanotas.service.EstudianteService;
import sistemanotas.model.Docente;
import sistemanotas.service.DocenteService;
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
    private DocenteService docenteService;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.estudianteService = new EstudianteService();
        this.docenteService = new DocenteService(); 
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
            System.out.println("║  2. Gestión de Docentes      ║");
            System.out.println("║  0. Salir                    ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: menuEstudiantes(); break;
                case 2: menuDocentes(); break;
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
    
    // ── Menú Docentes ─────────────────────────────────────

    private void menuDocentes() {
        int opcion;
        do {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║   GESTIÓN DE DOCENTES        ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║  1. Registrar docente        ║");
            System.out.println("║  2. Listar docentes          ║");
            System.out.println("║  3. Buscar docente           ║");
            System.out.println("║  4. Registrar nota           ║");
            System.out.println("║  0. Volver                   ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: registrarDocente(); break;
                case 2: listarDocentes(); break;
                case 3: buscarDocente(); break;
                case 4: registrarNota(); break;
                case 0: break;
                default: System.out.println(" Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void registrarDocente() {
        System.out.println("\n── Registrar Docente ──");
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        System.out.print("Departamento: ");
        String departamento = scanner.nextLine();

        try {
            docenteService.registrarDocente(id, nombre, correo, departamento);
        } catch (IllegalArgumentException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    private void listarDocentes() {
        System.out.println("\n── Lista de Docentes ──");
        List<Docente> lista = docenteService.listarDocentes();
        for (Docente d : lista) {
            System.out.println("  → " + d.mostrarInfo());
        }
    }

    private void buscarDocente() {
        System.out.println("\n── Buscar Docente ──");
        System.out.print("Ingrese el ID: ");
        String id = scanner.nextLine();
        try {
            Docente d = docenteService.buscarDocente(id);
            System.out.println("  → " + d.mostrarInfo());
        } catch (IllegalArgumentException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    private void registrarNota() {
        System.out.println("\n── Registrar Nota ──");
        System.out.print("ID del estudiante: ");
        String idEstudiante = scanner.nextLine();
        System.out.print("Código de asignatura: ");
        String codigoAsignatura = scanner.nextLine();
        System.out.print("Primer corte (30%): ");
        double primerCorte = scanner.nextDouble();
        System.out.print("Segundo corte (30%): ");
        double segundoCorte = scanner.nextDouble();
        System.out.print("Tercer corte (40%): ");
        double tercerCorte = scanner.nextDouble();
        scanner.nextLine();

        try {
            docenteService.registrarNota(idEstudiante, codigoAsignatura,
                                         primerCorte, segundoCorte, tercerCorte);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

