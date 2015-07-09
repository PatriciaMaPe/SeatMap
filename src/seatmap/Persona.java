/*
 * quitar dni de personas, no es necesario*
 */
package seatmap;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Patripon
 */
public class Persona{

    private String nombre, apellidos, dni, password;
    private Asiento asiento;
    MapaAsientos mapaAsiento = new MapaAsientos();

    public Persona() {
    }

    public Persona(String nombre, String apellidos, String dni, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.password = password;
        this.asiento = null;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    @Override
    public String toString() {
        if (asiento == null) {
            return nombre + " , " + apellidos + " , " + dni + " , " + password;
        } else {
            return nombre + " , " + apellidos + " , " + dni + " , " + password
                    + " , " + asiento.getFila() + " , " + asiento.getColumna() + " , " + asiento.getPrecio();
        }
    }
    
    //asiento ocupado
    public Asiento elegirFila(int j) {
        ArrayList filaElegida = mapaAsiento.getFila1();
        Asiento asientoElegido = (Asiento) filaElegida.get(j);

        return asientoElegido;
    }
    
    //asigna un asiento 
    public void comprar(Persona persona, Asiento asientoElegido, int j) {
        ArrayList filaElegida = mapaAsiento.getFila1();
        if (asientoElegido.isOcupado() == false) {
            //guardo una persona en el asiento e indico que esta ocupado
            asientoElegido.setPersona(persona);
            asientoElegido.setOcupado(true);
            //devuelvo el asiento al array
            filaElegida.set(j, asientoElegido);
            //guardo en persona el asiento
            persona.setAsiento(asientoElegido);
        } else {
            JOptionPane.showMessageDialog(null, "Asiento ocupado");
        }
    }

    /*public void abandonar(Persona persona, int j) {
     ArrayList filaElegida = mapaAsiento.getFila1();
     //guardo el asiento de la persona
     Asiento asientoElegido = persona.getAsiento();
     persona.setAsiento(null);

     //le cambio la persona a null y ocupado a false, lo guardo en el array  
     asientoElegido.setPersona(null);
     asientoElegido.setOcupado(false);
     filaElegida.set(j, asientoElegido);

     }*/
}
