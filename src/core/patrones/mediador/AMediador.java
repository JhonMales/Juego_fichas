/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.patrones.mediador;

/**
 *
 * @author jhonm
 */
import javax.swing.JPanel;

public abstract class AMediador extends JPanel{
	private static final long serialVersionUID = 1L;
	public void actualizar() {
		repaint();		
	}
}
