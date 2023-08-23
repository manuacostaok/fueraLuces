
//hacer cartel si ganas felicitaciones 

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;


import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.border.MatteBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Interface implements ActionListener{

	private JFrame frmFueraLuces;
	private JTextField textFieldInputNombre;
	private JButton [] tableroBotones;
	private JPanel pBotonesTablero;
	private Juego fueraLuces;
	private int turno;
	private JLabel lblMuestraTurnos;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frmFueraLuces.setVisible(true);
					window.frmFueraLuces.setLocationRelativeTo(null);//para poner la ventana al centro 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public Interface() {
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.pBotonesTablero=new JPanel();
		this.fueraLuces=new Juego();
		frmFueraLuces = new JFrame();
		frmFueraLuces.getContentPane().setBackground(new Color(210, 180, 140));
		frmFueraLuces.setResizable(false);
		frmFueraLuces.setTitle("Fuera Luces - UNGS TP");
		frmFueraLuces.setType(Type.UTILITY);
		frmFueraLuces.setBounds(100, 100, 579, 484);
		frmFueraLuces.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFueraLuces.getContentPane().setLayout(null);
		
		JLabel lblMuestraNombre = new JLabel();
		lblMuestraNombre.setText("");
		
		//AREA DEL TABLERO
		//-------------------------------------------------------------------------
		JPanel panelParaTablero = new JPanel();
		panelParaTablero.setBackground(new Color(205, 133, 63));
		panelParaTablero.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelParaTablero.setBounds(173, 63, 390, 375);
		frmFueraLuces.getContentPane().add(panelParaTablero);
		panelParaTablero.setLayout(new GridLayout(1, 1, 0, 0));
		
		//--------------------------------------------------------------------------
		
		
		//PANEL LATERAL IZQUIERDO
		//-----------------------------------------------------------------------
		JPanel paneBody = new JPanel();
		paneBody.setBackground(new Color(224, 255, 255));
		paneBody.setBounds(0, 0, 163, 455);
		frmFueraLuces.getContentPane().add(paneBody);
		paneBody.setLayout(null);
		//----------------- HEAD---------------------------
		JPanel head = new JPanel();
		head.setBackground(new Color(240, 230, 140));
		head.setToolTipText("FUERA LUCES ");
		head.setBounds(10, 11, 143, 48);
		paneBody.add(head);
		
		//-----------------Titulo----------------------------
		JLabel lbltitulo = new JLabel("FUERA LUCES");
		lbltitulo.setBackground(new Color(205, 133, 63));
		lbltitulo.setFont(new Font("Permanent Marker", Font.PLAIN, 18));
		head.add(lbltitulo);
		
		//-----------------------------------------------------------
		//muestra los intentas realizados por el jugador
		JPanel panelNombres = new JPanel();
		panelNombres.setBackground(new Color(119, 136, 153));
		panelNombres.setBounds(20, 66, 121, 48);
		paneBody.add(panelNombres);
		
		
		
		JLabel lblINGRESANOMBRE = new JLabel("Ingresa tu nombre :");
		lblINGRESANOMBRE.setForeground(new Color(240, 248, 255));
		lblINGRESANOMBRE.setFont(new Font("Sitka Text", Font.BOLD, 11));
		panelNombres.add(lblINGRESANOMBRE);
		
		
		textFieldInputNombre = new JTextField();
		textFieldInputNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					lblMuestraNombre.setText(textFieldInputNombre.getText());
					lblINGRESANOMBRE.setVisible(false);
					textFieldInputNombre.setVisible(false);
					}
				
			}
		});
		panelNombres.add(textFieldInputNombre);
		textFieldInputNombre.setColumns(10);
		
		
		//--------------------------
		
		//PANEL DE ELECCION DE NIVELES
		JPanel PanelNiveles = new JPanel();
		PanelNiveles.setBackground(new Color(205, 133, 63));
		PanelNiveles.setBounds(10, 125, 143, 188);
		paneBody.add(PanelNiveles);
		PanelNiveles.setLayout(null);
		
		JButton btn6x6 = new JButton("6x6");
		btn6x6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fueraLuces=new Juego(6);
				fueraLuces.mezclarLuces(6);
				CrearBotones(6,6);
				
			}
		});
		btn6x6.setBounds(10, 86, 123, 40);
		PanelNiveles.add(btn6x6);

		JButton btn4x4 = new JButton("4x4");
		btn4x4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fueraLuces=new Juego(4);
				fueraLuces.mezclarLuces(4);
				CrearBotones(4,4);
				
			}
		});
		btn4x4.setBounds(10, 35, 123, 40);
		PanelNiveles.add(btn4x4);
		
		JButton btn8x8 = new JButton("8x8");
		btn8x8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fueraLuces=new Juego(8);
				fueraLuces.mezclarLuces(8);
				CrearBotones(8,8);
			}
		});
		btn8x8.setBounds(10, 137, 123, 40);
		PanelNiveles.add(btn8x8);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("ELEGIR NIVEL");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Permanent Marker", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 10, 123, 14);
		PanelNiveles.add(lblNewLabel_1);
		
		JPanel panelRecords = new JPanel();
		panelRecords.setBackground(new Color(188, 143, 143));
		panelRecords.setBounds(10, 324, 143, 120);
		paneBody.add(panelRecords);
		panelRecords.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setText("<html><p style=\"width:100px\">"+"FueraLuces\n"+"\ncopyrigth2021"+"\nSMSTSoftware"+"</p></html>"); 
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 11, 123, 98);
		panelRecords.add(lblNewLabel_2);
		
		JPanel panelInformacionJugador = new JPanel();
		panelInformacionJugador.setBackground(new Color(240, 255, 240));
		panelInformacionJugador.setBounds(173, 11, 390, 41);
		frmFueraLuces.getContentPane().add(panelInformacionJugador);
		panelInformacionJugador.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Est\u00E1 jugando:");
		lblNewLabel_3.setBounds(12, 10, 113, 20);
		panelInformacionJugador.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblCajaTurnos = new JLabel("Toques :");
		lblCajaTurnos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCajaTurnos.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblCajaTurnos.setBounds(207, 10, 95, 20);
		panelInformacionJugador.add(lblCajaTurnos);
		
		
		lblMuestraNombre.setBounds(115, 10, 88, 20);
		panelInformacionJugador.add(lblMuestraNombre);
		
		this.lblMuestraTurnos = new JLabel();
		lblMuestraTurnos.setText("");
		lblMuestraTurnos.setBounds(292, 14, 88, 16);
		panelInformacionJugador.add(lblMuestraTurnos);
		
}
	
	
	
	//metodo para generar los botones a un GridLayout, puede recibir renglon y columna y dar un efecto de tablero 
	private void CrearBotones(int fila, int columna) {
		pBotonesTablero.setBackground(new Color(224, 255, 255));
		pBotonesTablero.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pBotonesTablero.setBounds(173, 69, 390, 375);
		frmFueraLuces.getContentPane().add(pBotonesTablero);
		pBotonesTablero.removeAll();
		pBotonesTablero.setLayout(new GridLayout(fila,columna,0,0));
		tableroBotones = new JButton[fila*columna];
		for(int i=0;i<(fila*columna);i++) {
			tableroBotones[i]=new JButton();
			tableroBotones[i].addActionListener(this);
			pBotonesTablero.add(tableroBotones[i]);			
		}
		pBotonesTablero.updateUI(); //ACT panel
		mostrarTablero();
		
	}

	
	private void mostrarTablero() {
		int cont=0;
		for(int i=0;i<this.fueraLuces.getMedida();i++) {
			for (int j=0;j<this.fueraLuces.getMedida();j++) {
				if (this.fueraLuces.getPosDelTablero(i,j)) {
					
					tableroBotones[cont].setText("1");
					tableroBotones[cont].setRolloverIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\LucesOff\\src\\IMG\\botonPresionado.png"));
					tableroBotones[cont].setPressedIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\LucesOff\\src\\IMG\\FOCOonm.png"));
   				   // tableroBotones[cont].setSelectedIcon(new ImageIcon("BotonNormal.png"));
					tableroBotones[cont].setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\LucesOff\\src\\IMG\\BotonNormal.png"));
					}
				else 
					{
					tableroBotones[cont].setText("0");
					tableroBotones[cont].setRolloverIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\LucesOff\\src\\IMG\\focoAmouse.png"));
					tableroBotones[cont].setPressedIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\LucesOff\\src\\IMG\\focoAcomun.png"));
					tableroBotones[cont].setSelectedIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\LucesOff\\src\\IMG\\focoA.png"));
					tableroBotones[cont].setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\LucesOff\\src\\IMG\\focoA.png"));
					}
					
						
				cont++;
				
			}
		}
		cont=0;

	}
	
	
	public void actionPerformed(ActionEvent arg0) {

		int cont=0;
		for(int i=0;i<this.fueraLuces.getMedida();i++) {
			for (int j=0;j<this.fueraLuces.getMedida();j++) {
				if(((JButton)arg0.getSource()).equals(tableroBotones[cont])){
					turno++;
					
					//lblMuestraTurnos.setText("");
					lblMuestraTurnos.setText(""+turno);
					fueraLuces.EncenderLuz(i, j);
					mostrarTablero();
				}
				cont++;
				
			}
		}
		cont=0;
		VerificarGanador();
	
	}
	
	
	private void VerificarGanador() {
		if (fueraLuces.VerificarGanador()) {
			boolean bandera=false;
			pBotonesTablero.removeAll();//si gana saca el tablero
			pBotonesTablero.updateUI();//actualiza la interface
			int opcion = JOptionPane.showConfirmDialog(tableroBotones[1], "Apagaste todas las luces! \n ¡Ganaste! \n ¿Quieres volver a intentar?");//funcion que pone mensaje + 3 opciones
			
			if(opcion==1){//opcion si
				
				initialize();
				
				}
			
			if(opcion==1 && bandera==false) {//opcion no 
				System.out.println("opcionNO");
				
				System.exit(0);}
			if(opcion==2)	 {//opcion cancelar				
				System.exit(0);}
			System.out.println("la opcion es:"+opcion);
			}
		}
	
}