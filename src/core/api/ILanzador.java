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
import java.util.List;

public interface ILanzador extends IIniciador,IDetenedor,IDibujable{
	void lanzar();	
	List<IFicha> getFichas();
}
