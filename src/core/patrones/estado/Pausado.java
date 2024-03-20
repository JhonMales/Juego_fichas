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
import core.api.IJuego;

public class Pausado extends Estado {
	public Pausado(IJuego juego) {
		super(juego);
		juego.getLanzador().detener();
		juego.getJugador().detener();
	}
	@Override
	public void manejar() {	
		if(juego.gameOver()) {
		   new Final(juego).manejar();
		}else {
		   juego.setEstado(new Jugando(juego));
		}
	}
}
