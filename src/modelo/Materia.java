package modelo;
//objeto que representa a una materia, con su id, nombre y año
public class Materia {
    
    //Atributos
    private int id;
    private String nombre;
    private int anio;
    
    //constructor
    public Materia(int id, String nombre, int anio) {
        this.id = id;
        this.nombre = nombre;
        this.anio = anio;
    }
    //getters && setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) { 
        this.id = id;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

//funcion toString para mostrar la materia en el comboBox, comboBox es un componente grafico que permite 
// seleccionar una opcion de una lista desplegable, en este caso se mostrara el id y el nombre de la materia
    @Override
    public String toString() {
        return id + " - " + nombre;
    }
    
}
