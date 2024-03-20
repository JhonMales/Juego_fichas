/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.patrones.componente;

/**
 *
 * @author jhonm
 */
public interface IComponente {
	default void adicionar(IComponente componente) {};
	default IComponente remover() {return null;}
	default IComponente getHoja() {return null;}
}
