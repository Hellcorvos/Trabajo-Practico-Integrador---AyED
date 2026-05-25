package grafo.contenedores;
import grafo.recursos.*;

public class ConnectionSet  extends AbsSet{

	@Override
	public boolean iguales(Object objA, Object objB) {
		Connection a = (Connection)objA;
		Connection b = (Connection)objB;
		
		if(a.getVertexI() == b.getVertexI() && a.getVertexJ() == b.getVertexJ() || a.getVertexI() == b.getVertexJ()
	   && a.getVertexJ() == b.getVertexI()) {
			return true;
		}
		return false;
	}

}
