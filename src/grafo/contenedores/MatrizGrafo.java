package grafo.contenedores;

public class MatrizGrafo extends MatrizArr {
    public MatrizGrafo(int ordenGrafo){
        super(ordenGrafo,ordenGrafo);
    }

    public boolean areConnected(int i, int j){//Devuelve true si los nodos i y j estan conectados, false en caso contrario
		boolean response=false;
		if (i>=0 && i<getNroFilas() && j>=0 && j<getNroColumnas()){//si en en ese lugar de la matriz hay un valor distinto de null, entonces los nodos i y j estan conectados
			if (this.matriz[i][j]!=null){
				response=true;
			}
		}				
		return response;
    
}
}