package grafo.contenedores;
import grafo.recursos.*;
public class ConnectionColaPrioridad extends ColaPrioridad{

	@Override
	public boolean esMenor(Object objA, Object objB) {
		Connection a = (Connection)objA;
		Connection b = (Connection)objB;
		return a.getConnectionCost() < b.getConnectionCost();
	}

	@Override
	public boolean esMayor(Object objA, Object objB) {
		Connection a = (Connection)objA;
		Connection b = (Connection)objB;
		return a.getConnectionCost() > b.getConnectionCost();
	}

	@Override
	public boolean iguales(Object objA, Object objB) {
		Connection a = (Connection)objA;
		Connection b = (Connection)objB;
		return a.getConnectionCost() == b.getConnectionCost();
	}

}
