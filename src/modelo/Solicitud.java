package modelo;

public class Solicitud {

    private Alumno alumno;
    private Materia materiaSolicitada;
    private String fecha;
    private String observaciones;

    Solicitud(Alumno alumno, Materia materiaSolicitada, String fecha, String observaciones) {
        this.alumno = alumno;
        this.materiaSolicitada = materiaSolicitada;
        this.fecha = fecha;
        this.observaciones = observaciones;
    }

    public Alumno getAlumno() {
        return this.alumno;
    }

    public void setAlumno(Alumno alumno){
        this.alumno = alumno;
    }

    public Materia getMateriaSolicitada(){
        return this.materiaSolicitada;
    }

    public void setMateriaSolicitada(Materia MateriaSolicitada){
        this.materiaSolicitada = MateriaSolicitada;
    }

    public String getFecha(){
        return this.fecha;
    }

    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    public String getObservaciones(){
        return this.observaciones;
    }

    public void setObservaciones(String observaciones){
        this.observaciones = observaciones;
    }
    

}

//solicitud es para ver la materia que quiere pedir condicionalidad.