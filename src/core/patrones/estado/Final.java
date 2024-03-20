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

public class Final extends Estado {
	public Final(IJuego juego) {
		super(juego);
		juego.reportar();		
	}
	@Override
	public void manejar() {		
		juego.setEstado(new Inicial(juego));			
	}
}
