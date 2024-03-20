/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.fichas;

/**
 *
 * @author jhonm
 */
import static core.api.IJuego.*;

import java.awt.Graphics;
import java.awt.Point;

import core.api.IFicha;

public class FichaDeLetra extends Ficha{
	public static int N_LETRAS = (int)Math.ceil(N_COLUMNAS*1.3);
    final public static char[]  letras = crearLetras();
	private static char[] crearLetras() {
		char[]  letras = new char[N_LETRAS];
		char a = 'a';
		for(int i=0;i<letras.length;i++) {			
			letras[i] = a == 'j' ? 'x' : (a == 'g' ? 'w' : a);
			a++;
		}
		return letras;
	}
	protected String letra;
	public FichaDeLetra(Point posicion,char letra) {
		super(posicion);
		this.letra = new String(new char[] {letra});		
	}
	@Override
	public boolean esIgual(IFicha ficha) {
		return ((FichaDeLetra)ficha).letra.equals(letra);
	}
	@Override
	public void dibujar(Graphics pintor) {
            //Dibujamos la letra en el recuadro
		int x = (ANCHO - pintor.getFontMetrics().stringWidth(letra))/2;
		int y =  ALTO - pintor.getFontMetrics().getLeading();
		pintor.drawString(letra, posicion.x + x, posicion.y + y );
		pintor.drawRect(posicion.x, posicion.y, ANCHO, ALTO);
	}
}

