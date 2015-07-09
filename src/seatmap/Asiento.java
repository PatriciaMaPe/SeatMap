/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seatmap;



/**
 *
 * @author Patripon
 */
public class Asiento {
    private int fila;
    private int columna;
    private boolean ocupado;
    private double precio;
    public Persona persona;
    MapaAsientos seatmap1 = new MapaAsientos();
    
    
    public Asiento() {
    }

    public Asiento(int fila, int columna, double precio) {
        
        this.fila = fila;
        this.columna = columna;
        this.ocupado = false;
        this.precio = precio;
        this.persona = null;
    }

   

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return  fila + " , " + columna + " , " + ocupado + " , " + precio + " , " + persona;
    }
    
   
    
}
