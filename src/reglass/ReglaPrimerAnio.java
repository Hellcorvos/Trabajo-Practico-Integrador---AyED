//Recoorer todas las correlativas de la materia y verificar que el alumno haya aprobado todas las materias de 
//primer año (año 1) que sean correlativas de la materia que quiere cursar. Si adeuda alguna, se rechaza.
package reglass;

import grafo.GrafoMaterias;
import modelo.Alumno;
import modelo.EstadoAcademico;

public class ReglaPrimerAnio {
    private GrafoMaterias grafoMaterias;
    private String mensaje;
    
    public ReglaPrimerAnio(GrafoMaterias grafoMaterias) {// Inyectamos el grafo de materias al motor de reglas
        this.grafoMaterias = grafoMaterias;
    }

    public boolean cumple(Alumno alumno, int indiceMateria){
        int orden = grafoMaterias.getGrafo().getOrden();

        for(int i = 0; i < orden; i++){
            double valor = (double) grafoMaterias.getGrafo().getMatrizCosto().devolver(i, indiceMateria);

            if(valor != grafoMaterias.getGrafo().getInfinito()){ // si es correlativa ya sea regular a aprobada
                int anio = grafoMaterias.getMateria(i).getAnio();
                
                if( anio == 1){
                    EstadoAcademico estado = alumno.getEstado(i);  //obtenemos el estado academico del alumno para esa materia correlativa
                    if(estado != EstadoAcademico.APROBADA){//si no la tiene aprobada
                        mensaje = "No cumple regla de primer año, adeuda: " + grafoMaterias.getMateria(i).getNombre();
                        return false;

                    }
                }
            }
         } 
        
         mensaje = "Todas las correlativas de primer año aprobadas";
        return true;
    }

    public String getMensaje() { // Método para obtener el mensaje de la regla después de evaluar
        return mensaje; 
    }
}
