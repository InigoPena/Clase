package plll;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaConfirmacionLenta {
	
	private static Thread hilo;
	private static Random r = new Random();
	// Este método simula un proceso que tarda un tiempo en hacerse (entre 5 y 10 segundos)
	private static void procesoConfirmar() {
		try {
			Thread.sleep( 5000 + 1000*r.nextInt(6) );
		} catch (InterruptedException e) {}
	}
	
	public static void main(String[] args) {
		verHilos( "Antes de ventana" );
		JFrame vent = new JFrame();
		// vent.setLayout( new BorderLayout() );
		vent.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		vent.setSize( 200, 100 );
		vent.setLocation( 2000, 0 );
	
		JPanel pCentral = new JPanel();
		JTextField textFieldUsuario = new JTextField( "Usuario:" );
		pCentral.add( textFieldUsuario );
		vent.add( pCentral, BorderLayout.NORTH );
		
		JButton bAceptar = new JButton( "Aceptar" );
		vent.add( bAceptar, BorderLayout.SOUTH );
	
		bAceptar.addActionListener( new ActionListener() {
			// Truco de Java: las variables externas que uses aquí se copian en la clase interna
			// JButton bAceptar = valor bAceptar de la clase externa
			// A cambio, tiene que ser final (no puede cambiar de valor)
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println( "Pulsado botón" );
				bAceptar.setForeground( Color.RED );
				hilo = new Thread() {
					@Override
					public void run() {
						System.out.println("Inicio Proceso");
						System.out.println(hilo.isAlive() + " " + hilo.getState());
						procesoConfirmar();
						System.out.println("Fin proceso");
						bAceptar.setEnabled(true);
						
					}
				};
				//Podria hacerse impl Runnable
				//Thread hilo2 = new Thread(new Runnable() {
					//@Override
					//public void run() {
						//procesoConfirmar();
					//}
				//});
				//procesoConfirmar(); en vez de hacerlo desde el escuchador
			}
		});
		
		vent.setVisible( true );
		System.out.println( "Fin" );
		verHilos( "Después de ventana" );
	}
	
	private static void verHilos( String mensaje ) {
		System.out.println( mensaje );
		for (Thread hilo : Thread.getAllStackTraces().keySet()) {
			System.out.println( "  " + hilo.getName() + " " + hilo.isDaemon() );
		}
	}
	
	private static class MiHilo extends Thread{
		
	}
	
	}
