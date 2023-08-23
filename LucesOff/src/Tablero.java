
public class Tablero {
	
	
	private boolean [][] tablero; 
	private int medida;
	
	
	

	public Tablero() {
		this.medida=0;
		this.tablero=new boolean [medida][medida];
		
	}
	
	public Tablero(int medida) { //arreglar metodo crear juego o constructor
		this.tablero=new boolean [medida][medida];
		this.medida=medida;
			for (int i=0;i<medida;i++) {
				for(int j=0;j<medida;j++) {
					tablero[i][j]=false;
			}
		}
	}
	

	public void CambiarEstado(int fila , int col){
		if ((fila>=0 & fila<=tablero.length-1) & (col>=0 & col<=tablero[0].length-1)){
		
			if (this.tablero[fila][col]==true) {
				this.tablero[fila][col]=false;
				System.out.println("se cambio a false");
				}
		
			else{
				this.tablero[fila][col]=true;
				System.out.println("se cambio a true");
				}
			}
		else
			System.out.println("la fila o culumna no existe");
		}
	
	
	public int getMedida(){
		return this.medida;
	}
	
	public boolean getPos(int fila, int columna) {
		return this.tablero[fila][columna];
	}
	
	public void setPos(int fila, int columna, boolean b) {
		
		this.tablero[fila][columna]=b;
	}
	
	public String toString() {
		String string="";
		for (int i=0;i<tablero.length;i++) {
			for(int j=0;j<tablero.length;j++) {
				if(tablero[i][j]) {
					string+="0";
				}
				else {
					string+="+";
				}
			}
			string+="\n";
		}
		return string;
		
	}


}
