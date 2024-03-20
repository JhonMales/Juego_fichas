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
import static logica.fichas.FichaDeColor.COLORES;
import static logica.fichas.FichaDeColor.N_COLORES;

import java.awt.Point;

import core.api.IFicha;
import logica.fichas.FichaDeColor;

public class FabricaDeFichaDeColor implements IFabricaDeFichas {
	@Override
	public IFicha crearFicha(Point posicion) {
		int color_i   = (int) floor(random() * N_COLORES);		
		return new FichaDeColor(new Point(posicion.x, posicion.y + ALTO), COLORES.get(color_i));
	}

}
