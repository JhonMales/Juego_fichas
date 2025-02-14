/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

/**
 *
 * @author jhonm
 */
import conexion.*;
import java.awt.Graphics;

import javax.swing.JFrame;


import core.api.IJuego;
import core.api.IJugador;
import core.api.ILanzador;
import core.api.ITablero;
import core.patrones.estado.Estado;
import core.patrones.estado.Inicial;
import core.patrones.mediador.AMediador;
import javax.swing.JOptionPane;

public class Juego extends AMediador implements IJuego{	
	private static final long serialVersionUID = 1L;
	public IJugador jugador;
	public ILanzador lanzador;
	public ITablero talero;
	Estado estado;
        
        
	@Override
	public ILanzador getLanzador() {		
		return lanzador;
	}
	@Override
	public ITablero getTablero() {	
		return talero;
	}
	@Override
	public IJugador getJugador() {		
		return jugador;
	}
	@Override
	public void setLanzador(ILanzador lanzador) {
		this.lanzador=lanzador;		
	}
	@Override
	public void setJugador(IJugador jugador) {
		this.jugador = jugador;		
	}
	@Override
	public void setTablero(ITablero talero) {
		this.talero=talero;		
	}
	public void setEstado(Object estado) {
		this.estado=(Estado)estado;
	}
	public Object getEstado() {
		return estado;
	}
	public static void main(String[] args) {
		JFrame jf=new JFrame();
		Juego juego=new Juego();
		jf.getContentPane().add(juego);
		juego.setEstado(new Inicial(juego));
                
	}
	@Override
	public void paint(Graphics pintor) {
		super.paint(pintor);
		talero.dibujar(pintor);
		lanzador.dibujar(pintor);
		jugador.dibujar(pintor);		
	}
	@Override
	public boolean gameOver() {		
		return talero!=null?talero.reportarGameOver():false;
	}
	@Override
	public void reportar() {		
		talero.reportarScore();	
	}
        
}

