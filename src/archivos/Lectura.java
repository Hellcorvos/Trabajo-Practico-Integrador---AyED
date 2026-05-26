package archivos;
import java.io.BufferedReader;
import java.io.FileReader;
import grafo.GrafoMaterias;
import modelo.Materia;


public class Lectura {
    
   /*  public void leerArchivo(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("archivo.txt"));//ruta del archivo a leer
            String linea = "";//linea vacia
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split("\t");
                int id = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                int  anio = Integer.parseInt(partes[2]);

            }
            reader.close();

        }catch(Exception e){
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
        */
       public GrafoMaterias cargarDesdeArchivo(String ruta) {//ruta del archivo a leer
            GrafoMaterias grafoMaterias = null;// Inicializamos el grafo como null para manejar casos de error

            try {
        // Pasada 1: contar materias y cargarlas
                BufferedReader reader = new BufferedReader(new FileReader(ruta));//BufferedReader para leer el archivo
                String linea = "";//linea vacia
                int cant = 0;//contador de materias
                while ((linea = reader.readLine()) != null) {//mientras haya lineas para leer
                    if (!linea.trim().isEmpty()) cant++;// Incrementamos el contador solo si la línea no está vacía
            }
                reader.close();

                grafoMaterias = new GrafoMaterias(cant);// Creamos el grafo con la cantidad de materias contadas

        // Pasada 2: cargar materias y luego correlativas
                reader = new BufferedReader(new FileReader(ruta));//BufferedReader para leer el archivo
                while ((linea = reader.readLine()) != null) {//mientras haya lineas para leer
                    linea = linea.trim();// Eliminar espacios en blanco al inicio y al final de la línea
                    if (linea.isEmpty()) continue;//continuar con la siguiente iteración si la línea está vacía

                        String[] p = linea.split("\t");// Dividir la línea en partes usando tabulaciones como separadores
                        int id = Integer.parseInt(p[0].trim());
                        String nombre = p[1].trim();
                        int anio = Integer.parseInt(p[2].trim());
                        grafoMaterias.agregarMateria(new Materia(id, nombre, anio));// Crear una nueva materia y agregarla al grafo
                }
                reader.close();

        // Pasada 3: cargar correlativas
                reader = new BufferedReader(new FileReader(ruta));//BufferedReader para leer el archivo
                while ((linea = reader.readLine()) != null) {
                    linea = linea.trim();
                    if (linea.isEmpty()) continue;

                    String[] p = linea.split("\t");
                    int idOrigen = Integer.parseInt(p[0].trim());// Obtener el ID de la materia origen

            if (p.length == 4 && !p[3].trim().isEmpty()) {// Verificar que existan correlativas y que no estén vacías
                String[] correlativas = p[3].trim().split("-");// Dividir las correlativas usando guiones como separadores
                for (String corr : correlativas) {// Iterar sobre cada correlativa, : representa cada correlativa individual
                    int idDestino = Integer.parseInt(corr.trim());// Obtener el ID de la materia destino
                    grafoMaterias.agregarCorrelativa(idDestino, idOrigen);// Agregar la correlativa al grafo (idDestino es la materia que debe ser cursada antes que idOrigen)
                }
            }
        }
        reader.close();

        } catch (Exception e) {
        System.err.println("Error al leer: " + e.getMessage());
    }

    return grafoMaterias;
}
}

