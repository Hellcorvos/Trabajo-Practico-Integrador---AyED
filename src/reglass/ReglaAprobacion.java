//Recorrer todas las correlativas de tipo A (valor 2 en la matriz) de la materia que quiere cursar, 
// y contar cuántas NO tiene aprobadas. Si hay más de una, se rechaza.
package reglass;

import grafo.GrafoMaterias;
import modelo.Alumno;
import modelo.EstadoAcademico;

public class ReglaAprobacion {
    private GrafoMaterias grafoMaterias;
    private String mensaje;

    public ReglaAprobacion(GrafoMaterias grafoMaterias) {// Inyectamos el grafo de materias al motor de reglas
        this.grafoMaterias = grafoMaterias;
    }

    public boolean cumple(Alumno alumno, int indiceMateria){
        int orden = grafoMaterias.getGrafo().getOrden();
        int adeudaAprobacion = 0;//contador para correlativas de aprobacion adeudadas

        for(int  i = 0; i < orden; i ++){
            double valor = (double) grafoMaterias.getGrafo().getMatrizCosto().devolver(i, indiceMateria);

            if(valor == 2.0){ //o sea si la materia de indice i es correlativa de aprobacion de la materia que quiere cursar
                EstadoAcademico estado = alumno.getEstado(i);// obetenemos el estado academico del alumno para esa materia correlativa

                if(estado != EstadoAcademico.APROBADA){//si no la tiene aprobada
                    adeudaAprobacion ++;//incremento el contador de correlativas de aprobacion adeudadas
                }
            }

        }
         if (adeudaAprobacion > 1) {
            mensaje = "Adeuda " + adeudaAprobacion + " correlativas de aprobación, solo se permite una";
            return false;
        }
        mensaje = "Cumple regla de aprobación";
        return true;
    }

    public String getMensaje() { 
        return mensaje; 
    }

}
