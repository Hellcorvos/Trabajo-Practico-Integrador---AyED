package Testeos;

import archivos.Lectura;
import grafo.GrafoMaterias;
import modelo.Alumno;
import grafo.contenedores.ListaDoubleLinkedL;
import reglass.Dictamen;
import reglass.MotorReglas;

public class Test {

    public static void main(String[] args) {
        System.out.println(new java.io.File(".").getAbsolutePath());
        // ─── 1. CARGAR PLAN DE ESTUDIOS ───────────────────────────────
        Lectura lectura = new Lectura();
        GrafoMaterias grafo = lectura.cargarMaterias("Archivos_txt/MateriasdeTUP.txt");
        lectura.cargarCorrelativas("Archivos_txt/CorrelativasTUP.txt", grafo);

        System.out.println("=== PLAN DE ESTUDIOS ===");
        grafo.mostrarPlanEstudios();
        System.out.println();

        // ─── 2. CARGAR ALUMNOS ────────────────────────────────────────
        ListaDoubleLinkedL alumnos = lectura.cargarAlumnos("Archivos_txt/AlumnosTup.txt", grafo);

        System.out.println("=== ALUMNOS CARGADOS ===");
        for (int i = 0; i < alumnos.tamanio(); i++) {// Recorremos la lista de alumnos
            Alumno a = (Alumno) alumnos.devolver(i);// Obtenemos el alumno en la posición i
            System.out.println(a);// Imprimimos el alumno (toString)
        }
        System.out.println();

        // ─── 3. CARGAR HISTORIALES ────────────────────────────────────
        Alumno juan   = (Alumno) alumnos.devolver(0);
        Alumno maria  = (Alumno) alumnos.devolver(1);
        Alumno carlos = (Alumno) alumnos.devolver(2);

        lectura.cargarHistorial("Archivos_txt/HistorialJuan.txt", juan, grafo);
        lectura.cargarHistorial("Archivos_txt/HistorialMaria.txt", maria, grafo);
        lectura.cargarHistorial("Archivos_txt/HistorialCarlos.txt", carlos, grafo);

        // ─── 4. ANALIZAR SOLICITUDES ──────────────────────────────────
        MotorReglas motor = new MotorReglas(grafo);

        System.out.println("=== DICTAMENES ===");

        // Caso 1: Juan quiere cursar AYED (id 7), tiene 1,2,3,4,5 aprobadas
        // Debería APROBARSE
        Dictamen d1 = motor.analizar(juan, 7);
        System.out.println("Juan - AYED (7): " + d1);

        // Caso 2: Maria quiere cursar AYED (id 7), tiene materias libres
        // Debería RECHAZARSE
        Dictamen d2 = motor.analizar(maria, 7);
        System.out.println("Maria - AYED (7): " + d2);

        // Caso 3: Carlos quiere cursar Programacion (id 5), recien arranca
        // Debería APROBARSE (no tiene correlativas)
        Dictamen d3 = motor.analizar(carlos, 5);
        System.out.println("Carlos - Programacion (5): " + d3);

        // Caso 4: Juan quiere cursar Paradigmas (id 10), necesita 7 y 8
        // Debería RECHAZARSE, no tiene 7 y 8
        Dictamen d4 = motor.analizar(juan, 10);
        System.out.println("Juan - Paradigmas (10): " + d4);

        System.out.println();

        // ─── 5. VERIFICAR ESTADOS ─────────────────────────────────────
        System.out.println("=== ESTADO DE JUAN ===");
        for (int i = 0; i < grafo.getCapacidad(); i++) {
            System.out.println(grafo.getMateria(i).getNombre() 
                + " -> " + juan.getEstado(i));
        }
    }
}