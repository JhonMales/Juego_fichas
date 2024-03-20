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
public abstract class Estado {
	protected IJuego juego;	
	public Estado(IJuego juego) {		
		this.juego = juego;
	}
	public abstract void manejar();
}
