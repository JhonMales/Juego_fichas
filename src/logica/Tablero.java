/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author jhonm
 */
import static core.api.IJuego.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Stack;
import javax.swing.*;
import core.api.*;
import core.patrones.mediador.*;
import java.applet.AudioClip;

public class Tablero extends AColega implements ITablero,IDibujable{
	public final static  int PUNTAJE_X_COLUMNA = 10;
    Stack<IFicha> pilas[];    
    int puntaje;
    int trios;
    AudioClip point,over,ingame;
    String jugador;
	public Tablero(AMediador juego) {	
		super(juego);
		posicion = new Point(ORIGEN.x,Y_TALERO);
		this.pilas = new Stack[N_COLUMNAS];
		iniciar();
	}
	@Override
	public void recibirFicha(IFicha f_i) {
		int columna = f_i.getPosicion().x / ANCHO;
		if (pilas[columna].size() < N_FILAS) {
			pilas[columna].push(f_i);
			verificarColumnas();
		}
	}
	@Override
	public void recogerFichas() {	
		List<IFicha> fichas =((IJuego)juego).getLanzador().getFichas();
		List<IFicha> removidas= new ArrayList<IFicha>();
		for (IFicha f_i : fichas) {				
			if(f_i.getPosicion().y>posicion.y-ALTO) {
			   removidas.add(f_i);
			   recibirFicha(f_i);
			}
		}
		fichas.removeAll(removidas);
	}
	@Override
	public void verificarTrios() {
		verificarColumnas();		
	}
	private void verificarColumnas() {
		List<IFicha> removidas=new ArrayList<IFicha>();
		for (Stack<IFicha> p_i : pilas) {
			for (int i = 0; i < p_i.size(); i++) {
				if (p_i.size() - i >= 3) {
                    if(p_i.get(i).esIgual(p_i.get(i+1))&&p_i.get(i+1).esIgual(p_i.get(i+2))) {
                       removidas.add(p_i.get(i));
                       removidas.add(p_i.get(i+1));
                       removidas.add(p_i.get(i+2));
                       break;
                    }
				}
			}
			if(!removidas.isEmpty()) {
                           point = java.applet.Applet.newAudioClip(getClass().getResource("/agregados/345299__scrampunk__okay.wav"));
			   p_i.removeAll(removidas);
			   removidas=new ArrayList<IFicha>();
			   puntaje+=PUNTAJE_X_COLUMNA;
                           point.play();
                           trios++;
			   actualizar();
			}
		}		
	}
	@Override
	public boolean reportarGameOver() {
		for(Stack p_i:pilas) {			
			if(p_i.size() == N_FILAS) {
                            over = java.applet.Applet.newAudioClip(getClass().getResource("/agregados/350986__cabled-mess__lose-c-01.wav"));
                            over.play();
			   return true;
			}
		}
		return false;
	}
	@Override
	public void reportarScore() {
		SwingUtilities.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	        	JOptionPane.showMessageDialog(null,"Nombre: " + jugador + "\nScore: "+puntaje + "\nTrios completados: " + trios); 
	        	iniciar();
	        }
	    });		
	}
	@Override
	public void dibujar(Graphics pintor) {
		recogerFichas();
		for(Stack p_i:pilas) {			
			for(int i=0;i<p_i.size();i++) {
				IFicha f_i=(IFicha)p_i.get(i);
				f_i.getPosicion().y = posicion.y+(N_FILAS-i)*ALTO;
				f_i.dibujar(pintor);
			}
		}
	}
	@Override
	public void iniciar() {
		puntaje = 0;
                jugador = JOptionPane.showInputDialog("Cual es tu nombre?");
		for(int i=0;i<N_COLUMNAS;i++) {
			pilas[i] = new Stack<IFicha>(); 
		}		
	}     
}

