import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Juego {
	
	private Tablero tablero;
	private int cont;
	private int cont2;
	private int medida;
	
	
	public Juego(){
		this.tablero=new Tablero();
	}
	public Juego(int medida) {
		this.tablero=new Tablero(medida);
		this.medida=medida;
	}

	//metodo que se encarga de mesclar las posiciones del tablero a encendidas y apagadas mediante un numero random
	public void mezclarLuces(int nivel) {
		Random ran=new Random();
		for (int i=0;i<nivel;i++) {
			int a=ran.nextInt(nivel);
			int b=ran.nextInt(nivel);
			EncenderLuz(a, b);
		}
	}
	
	//metodo que cambia el estado de la luz en la posicion indicada por fila y col
			//si la posicion esta encendida se apaga y viceversa
	public void EncenderLuz(int fila , int col) {
		
		tablero.CambiarEstado(fila ,col); //posision selecionada
		//posiciones que estan al rededor de la posicion seleccionada tmb son afectadas por el cambio de estado de la luz
		tablero.CambiarEstado(fila ,col+1);
		tablero.CambiarEstado(fila ,col-1);
		tablero.CambiarEstado(fila-1 ,col);
		tablero.CambiarEstado(fila+1 ,col);
		}

	
	// VerificarGanador recorre las posiciones del tablero buscando que todas ellas esten apagadas si ese es el caso
		// retorna true y notifica que el juego se ah terminado.
		//de lo contrario retorna false
	public boolean VerificarGanador(){	
		for (int k=0;k<this.tablero.getMedida();k++) {
			for (int z=0;z<this.tablero.getMedida();z++) {
				if (this.tablero.getPos(k, z)==false) {
					cont=cont+1;
					cont2++;
					System.out.println("luz apagada,el numero de luces apagadas es: "+cont2);
					}
				else {
					cont=0;
					cont2=0;
					System.out.println(("la luz esta encendida"));
					}
			}}
		if (cont>=this.tablero.getMedida()*this.tablero.getMedida()) {
			System.out.println("¡¡se termino el juego!!");
			return true;
			}
		else {
			System.out.println("sigue intentanto");
			return false;
			}
	}	
	
	
	
	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero juego) {
		this.tablero = juego;
	}
	
	public boolean getPosDelTablero(int a ,int b) {
		boolean aux;
		if (this.tablero.getPos(a, b))
			aux=true;
		else
			aux=false;
		
		return aux;
	}
	
	public String toString() {
		
		String g="";
		for (int i=0;i<tablero.getMedida();i++) {
			for(int j=0;j<tablero.getMedida();j++) {
				if(tablero.getPos(i, j)) {
					g+="1";
				}
				else {
					g+="0";
				}
			}
			g+="\n";
		}
		return g;
		
	}
		
	
	public int getMedida() {
		return medida;
	}
	
	public int contarToques(int turno) {
		
		turno++;
		return turno;
		
	}
	
	
	
}
