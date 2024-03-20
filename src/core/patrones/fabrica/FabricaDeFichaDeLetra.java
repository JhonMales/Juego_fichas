/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.patrones.fabrica;

/**
 *
 * @author jhonm
 */
import static core.api.IJuego.ALTO;
import static java.lang.Math.floor;
import static java.lang.Math.random;
import static logica.fichas.FichaDeLetra.N_LETRAS;
import static logica.fichas.FichaDeLetra.letras;

import java.awt.Point;

import core.api.IFicha;
import logica.fichas.FichaDeLetra;

public class FabricaDeFichaDeLetra implements IFabricaDeFichas {
	@Override
	public IFicha crearFicha(Point posicion) {
		int letra_i   = (int) floor(random() * N_LETRAS);		
		return new FichaDeLetra(new Point(posicion.x, posicion.y + ALTO), letras[letra_i]);
	}  
        
}
