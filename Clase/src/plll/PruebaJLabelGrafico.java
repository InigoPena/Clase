package plll;

import java.awt.BorderLayout;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PruebaJLabelGrafico extends JFrame {
	public static void main(String[] args) {
		PruebaJLabelGrafico vent = new PruebaJLabelGrafico();
	}
	
	// No static
	
	private JPanel pJuego;
	private JLabel lCoche;
	
	public PruebaJLabelGrafico() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 400);
		setLocation(2000, 0);
	
	
	//Creamos los contenedores
	pJuego = new JPanel();
	
	//Creamos los componentes
	//lCoche = new JLabel( new ImageIcon("coche.png") );
	//try {
		lCoche = new JLabel(new ImageIcon(PruebaJLabelGrafico.class.getResource("coche.png")));
	//} catch (MalformedURLException | URISyntaxException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	//}
	
	//Asociamos componente a contenedores
	pJuego.add(lCoche);
	getContentPane().add(pJuego, BorderLayout.CENTER);
	//Gestion de eventos
	
	
	}
}
