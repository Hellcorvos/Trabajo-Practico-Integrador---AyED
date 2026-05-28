//Recorrer todas las correlativas de tipo R (valor 1 en la matriz) de la materia que quiere cursar, 
// y verificar que el alumno tenga estado REGULAR o APROBADA en cada una.

package reglass;
import grafo.GrafoMaterias;
import modelo.Alumno;
import modelo.EstadoAcademico;

public class ReglaCorrelativasR {
    private GrafoMaterias grafoMaterias;
    private String mensaje;

    public ReglaCorrelativasR(GrafoMaterias grafoMaterias) {// Inyectamos el grafo de materias al motor de reglas
        this.grafoMaterias = grafoMaterias;
    }

    public boolean cumple(Alumno alumno, int indiceMateria){
        int orden = grafoMaterias.getGrafo().getOrden();// Obtenemos el orden del grafo para iterar sobre las correlativas

          for (int i = 0; i < orden; i++) {//recorro todas las materias pare verificar si son correlativas regulares de la materia solicitada
            double valor = (double) grafoMaterias.getGrafo().getMatrizCosto().devolver(i, indiceMateria);

            if (valor == 1.0) { // es correlativa Regular
                EstadoAcademico estado = alumno.getEstado(i);// obtenemos el estado académico del alumno para esa materia correlativa

                if (estado != EstadoAcademico.REGULAR && estado != EstadoAcademico.APROBADA &&  estado != EstadoAcademico.CURSANDO) {
                    mensaje = "No cumple correlativa regular: " + grafoMaterias.getMateria(i).getNombre();
                    return false;
                }
            }
        }

        mensaje = "Todas las correlativas regulares cumplidas";
        return true;
    }

    public String getMensaje() { 
        return mensaje; 
    }

    }


