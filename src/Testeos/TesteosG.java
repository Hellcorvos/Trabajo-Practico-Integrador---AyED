package Testeos;
import grafo.GrafoMaterias;
import archivos.Lectura;


public class TesteosG {

    public static void main(String[] args) {
        Lectura lec = new Lectura();
        GrafoMaterias t1 = lec.cargarMaterias("Archivos txt/MateriasdeTUP.txt");
        System.out.println("Materias cargadas:" + t1.getCapacidad());
        for(int i = 0; i < t1.getCapacidad(); i++){
            System.out.println("ID: " + t1.getMateria(i).getId() + "| Materia: " + t1.getMateria(i).getNombre() + "| Año: " + t1.getMateria(i).getAnio());
        }
        
        lec.cargarCorrelativas("Archivos txt/CorrelativasTUP.txt", t1);
        t1.getGrafo().muestraGrafoS();
    }
}
