/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.patrones.estado;

/**
 *
 * @author jhonm
 */
import logica.Lanzador;
import logica.Tablero;
import logica.Jugador;
import static core.api.IJuego.TAM;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import core.api.IJuego;
import core.patrones.comando.ComandoDeJugandoPausado;
import core.patrones.fabrica.*;
import core.patrones.mediador.AMediador;

public class Inicial extends Estado {
	public Inicial(IJuego juego) {
		super(juego);		
		armar();		
	}
	private void armar() {
		juego.setJugador(new Jugador((AMediador)juego));
                
                //Elegimos el tipo de ficha
		juego.setLanzador(new Lanzador((AMediador)juego,Math.round(Math. random()*1) == 0?new FabricaDeFichaDeColor():new FabricaDeFichaDeLetra()));
		juego.setTablero(new Tablero((AMediador)juego));
		Container jp = (JPanel)juego,jf= (JPanel)juego; //Contenemos el juego en el panel
		while(!((jf=jf.getParent()) instanceof JFrame));
		((JFrame)jf).setResizable(false);	// Evitamos redimencion	
		((JFrame)jf).setSize(TAM.width,TAM.height);				
		((JFrame)jf).setVisible(true);
		((JFrame)jf).setFocusable(true);
                ((JFrame)jf).setLocationRelativeTo(null);
                
                //Funciones del boton Iniciar, 
		if (jp.getComponentCount() == 0) {
			final Button boton = new Button("Jugar");			
			jp.add(boton);
			boton.setFocusable(false); //Eliminar el margen del boton 
			boton.addActionListener(new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
				boton.setLabel(boton.getLabel(). equals("Jugar")?"Pausar":"Jugar");
				new ComandoDeJugandoPausado((Estado) juego.getEstado()).ejecutar();
			}});			
		} else {
			((Button)jp.getComponents()[0]). setLabel("Jugar");
			((Button)jp.getComponents()[0]). setFocusable(false);
		}
	}
	@Override
	public void manejar() {	
		juego.setEstado(new Jugando(juego));
	}
}

