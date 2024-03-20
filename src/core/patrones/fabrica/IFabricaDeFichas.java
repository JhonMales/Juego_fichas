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
import java.awt.Point;
import core.api.IFicha;

public interface IFabricaDeFichas {
	IFicha crearFicha(Point posicion);
}
