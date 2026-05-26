package grafo;

import grafo.contenedores.ListaDoubleLinkedL;
import grafo.dirigido.GrafoDirigido;
import modelo.Materia;

public class GrafoMaterias {

    private GrafoDirigido grafo;
    private ListaDoubleLinkedL materias;

    public GrafoMaterias(int cantMaterias) {
        this.grafo    = new GrafoDirigido(cantMaterias);
        this.materias = new ListaDoubleLinkedL();
    }

    public void agregarMateria(Materia m) {
        materias.insertar(m, materias.tamanio());
    }

    public int buscarIndicePorId(int id) {
        for (int i = 0; i < materias.tamanio(); i++) {
            Materia m = (Materia) materias.devolver(i);
            if (m.getId() == id) return i;
        }
        return -1;
    }

    public void agregarCorrelativa(int idOrigen, int idDestino) {
        int i = buscarIndicePorId(idOrigen);
        int j = buscarIndicePorId(idDestino);
        if (i == -1 || j == -1) {
            System.err.println("Id no encontrado: " + idOrigen + " → " + idDestino);
            return;
        }
        grafo.getMatrizCosto().actualizar(1.0, i, j);
    }

    public Materia getMateria(int indice) {
        return (Materia) materias.devolver(indice);
    }

    public GrafoDirigido getGrafo()         { return grafo; }
    public ListaDoubleLinkedL getMaterias() { return materias; }
}

