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
public interface IJugador extends IIniciador,IDetenedor,IDibujable{
	void capturarFichas();
	void ordenarFichas();
}
