/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.api;

/**
 *
 * @author jhonm
 */
import java.awt.Point;

import core.patrones.componente.IComponente;

public interface IFicha extends IMovible,IDibujable,IComponente{
	boolean esIgual(IFicha ficha);
	Point getPosicion();
}

