/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seatmap;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;

/**
 *
 * @author Patripon
 */
public class UsoFichero {

    PrintWriter fichero = null;
    Scanner sc;
    ArrayList lista = new ArrayList();

    //FICHERO PERSONAS
    public void anhadirPersona(String nombFich, Persona persona) {
        boolean presente = estaPersona(nombFich, persona);
        if (presente == false) {
            try {
                //añadir en le fichero sin sobreescribir
                fichero = new PrintWriter(new FileWriter(new File(nombFich), true));
                //Escribimos en el fichero
                fichero.println(persona);

            } catch (IOException ex) {
                System.err.println("error" + ex.toString());

            } finally {
                fichero.close();
            }
        }
    }

    public void leerPersona(String nombreFich) {

        try {
            sc = new Scanner(new File(nombreFich));
            while (sc.hasNextLine()) {
                String linea = sc.nextLine(); // Obtengo una linea del fichero 

                String[] cortarString = linea.split(" , ");
                Persona persona = new Persona();
                Asiento asiento = new Asiento();

                //Ponemos los atributos en el objeto
                if (cortarString.length <= 5) {
                    persona.setNombre(cortarString[0]);
                    persona.setApellidos(cortarString[1]);
                    persona.setDni(cortarString[2]);
                    persona.setPassword(cortarString[3]);
                } else {
                    persona.setNombre(cortarString[0]);
                    persona.setApellidos(cortarString[1]);
                    persona.setDni(cortarString[2]);
                    persona.setPassword(cortarString[3]);
                    asiento.setFila(Integer.parseInt(cortarString[4]));
                    asiento.setColumna(Integer.parseInt(cortarString[5]));
                    asiento.setPrecio(Double.parseDouble(cortarString[6]));
                    persona.setAsiento(asiento);
                }

                //Añado el objeto persona al ArrayList
                lista.add(persona);

            }

        } catch (FileNotFoundException ex) {
            System.err.println("Error" + ex.toString());
        } finally {
            sc.close();
        }

    }

    //Busca una persona en el fichero con su dni
    public boolean estaPersona(String nombFich, Persona persona) {
        boolean presente = false;
        leerPersona(nombFich);
        String dni = persona.getDni();
        for (int i = 0; i < lista.size(); i++) {
            Persona personaBus = (Persona) lista.get(i);
            if (personaBus.getDni().equals(dni)) {
                presente = true;
            }
        }
        lista.clear();
        return presente;
    }

    public void escribirPersonas(String nombFich) {
        try {
            //añadir en el fichero 
            fichero = new PrintWriter(new File(nombFich));
            //Escribimos en el fichero
            for (int i = 0; i < lista.size(); i++) {
                fichero.println(lista.get(i));
            }
            lista.clear();

        } catch (IOException ex) {
            System.err.println("error" + ex.toString());

        } finally {
            fichero.close();
        }
    }
    //modifico persona con la persona que le paso por parametro
    public void modPersona(String nombFich, Persona persona) {
        Persona personaBus = null;
        leerPersona(nombFich);
        String dni = persona.getDni();
        for (int i = 0; i < lista.size(); i++) {
            personaBus = (Persona) lista.get(i);
            if (personaBus.getDni().equals(dni)) {
                lista.set(i, persona);
            }
        }
        escribirPersonas(nombFich);
        System.out.println(lista);
    }
    
    //borra la persona del fichero
    public void borrarPersona(String nombFich, Persona persona) {
        Persona personaBus = null;
        leerPersona(nombFich);
        String dni = persona.getDni();
        for (int i = 0; i < lista.size(); i++) {
            personaBus = (Persona) lista.get(i);
            if (personaBus.getDni().equals(dni)) {
                lista.remove(i);
            }
        }
        escribirPersonas(nombFich);

    }

    //Añado a la persona un asiento, sea null o con atributos
    public void anhadirAsientoAPersona(String nombFich, Persona persona, Asiento asientoElegido) {
        boolean presente = estaPersona(nombFich, persona);
        if (presente == true) {
            persona.setAsiento(asientoElegido);
        }
        modPersona(nombFich, persona);

    }
    
    //borro asiento de persona
    public void borrarAsientoAPersona(String nombFich, Persona persona) {
        boolean presente = estaPersona(nombFich, persona);
        if (presente == true) {
            persona.setAsiento(null);
            modPersona(nombFich, persona);

        }

    }
    
    //lee los asiento ocupados del fichero, marca casillas del mapa
    public void asientoOcupado(String nombFich, JButton botones[]) {
        leerPersona(nombFich);
        for (int i = 0; i < lista.size(); i++) {
            Persona personaBus = (Persona) lista.get(i);
            if (personaBus.getAsiento() != null) {
                int posicion = personaBus.getAsiento().getColumna();
                botones[posicion].setBackground(Color.RED);

            }
        }
    }
}
