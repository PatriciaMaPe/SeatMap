  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seatmap;

import java.util.ArrayList;

/**
 *
 * @author Patripon
 */
public class MapaAsientos {

    private static ArrayList<Asiento> fila1 = new ArrayList<Asiento>();

    private static int tamanhoF1 = 9;

    public void crear() {

        for (int i = 0; i < tamanhoF1; i++) {
            fila1.add(i, new Asiento(0, i, 5.3));
        }

    }

    public static int getTamanhoF1() {
        return tamanhoF1;
    }

    public static void setTamanhoF1(int tamanhoF1) {
        MapaAsientos.tamanhoF1 = tamanhoF1;
    }

    public ArrayList<Asiento> getFila1() {
        return fila1;
    }

    public void setFila1(ArrayList<Asiento> fila1) {
        this.fila1 = fila1;
    }

    @Override
    public String toString() {
        return "MapaAsientos{" + "fila1=" + fila1 + '}';
    }

}
