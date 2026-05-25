package grafo.recursos;

public class Connection {
    protected int vertexI, vertexJ;
	protected double connectionCost;
	
	public Connection(int vertexI, int vertexJ, double connectionCost){
		this.vertexI=vertexI;
		this.vertexJ=vertexJ;
		this.connectionCost=connectionCost;
	}
	
	public int getVertexI(){
		return this.vertexI;
	}
	
	public int getVertexJ(){
		return this.vertexJ;
	}
	
	public double getConnectionCost(){
		return this.connectionCost;
	}	

//@Override
   public int compareTo(Connection c){

	return Double.compare(this.connectionCost,c.connectionCost);
   }
}

//Connection es una clase que representa una conexion entre dos vertices de un grafo, con un costo asociado a esa conexion. }
// La clase tiene tres atributos: vertexI, vertexJ y connectionCost, que representan el vertice de origen, el vertice de destino
//  y el costo de la conexion, respectivamente. La clase tiene un constructor para inicializar estos atributos 
// y tres metodos getter para acceder a ellos. 
// Ademas, la clase implementa el metodo compareTo para comparar dos objetos Connection en base a su costo de conexion.