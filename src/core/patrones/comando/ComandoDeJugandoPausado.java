/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.patrones.comando;

/**
 *
 * @author jhonm
 */
import core.patrones.estado.Estado;

public class ComandoDeJugandoPausado implements IComando{
	Estado estado;
	public ComandoDeJugandoPausado(Estado estado){		
		this.estado = estado;
	}
	@Override
	public void ejecutar() {
		estado.manejar();
	}
}
