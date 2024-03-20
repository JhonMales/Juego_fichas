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
public interface ITablero extends IDibujable ,IIniciador{
	void recogerFichas();
	void recibirFicha(IFicha ficha);
	void verificarTrios();	
	boolean reportarGameOver();
	void reportarScore();
}
