/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seatmap;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 *
 * @author Patripon
 */
public class Gui2 extends JFrame implements ActionListener {

    JFrame marco;
    JButton boton1, boton3;
    JButton botones[] = new JButton[9];
    JPanel panel2, panel1, panel3, panel;
    JMenuBar barraMenu;
    JMenu menuCuenta;
    JMenuItem mCrearCuenta, mDarBaja, mEditarDatos, mComprar, mCambiar, mAbandonar;

    JTextField tNombre, tApellidos, tDni, tPassword, tNombre3, tApellidos3, tDni3, tPassword3;
    JLabel eNombre, eApellidos, eDni, ePassword, eNombre3, eApellidos3, eDni3, ePassword3;
    UsoFichero usoFichero = new UsoFichero();

    Persona persona;

    ArrayList<Asiento> fila1;

    public void crearVentana() {

        marco = new JFrame("Mapa Asientos");
        marco.setBounds(100, 100, 400, 600);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setLocationRelativeTo(null); //lo pone en le centro
        marco.setVisible(true);

        //PANELES
        panel = new JPanel(new CardLayout());

        //panel1
        panel1 = new JPanel();
        marco.add(panel);
        panel1.setBounds(0, 0, 300, 600);
        panel1.setBackground(Color.WHITE);
        panel1.setLayout(null);
        //panel2
        panel2 = new JPanel();
        panel2.setBounds(0, 0, 300, 300);
        panel2.setBackground(Color.BLACK);
        panel2.setLayout(new GridLayout(3, 3));
        botones2();
        //panel3
        panel3 = new JPanel();
        panel3.setBounds(0, 0, 300, 600);
        panel3.setBackground(Color.WHITE);
        panel3.setLayout(null);

        panel.add(panel1, "panel1");
        panel.add(panel2, "panel2");
        panel.add(panel3, "panel3");

        //ETIQUETAS 
        eNombre = new JLabel("Nombre");
        eNombre.setBounds(10, 10, 80, 35);
        eApellidos = new JLabel("Apellidos");
        eApellidos.setBounds(10, 40, 80, 50);
        eDni = new JLabel("DNI");
        eDni.setBounds(10, 60, 80, 90);
        ePassword = new JLabel("Password");
        ePassword.setBounds(10, 95, 80, 100);

        //TEXTFIELDS
        tNombre = new JTextField(20);
        tNombre.setBounds(100, 10, 150, 25);
        tApellidos = new JTextField(20);
        tApellidos.setBounds(100, 50, 150, 25);
        tDni = new JTextField(20);
        tDni.setBounds(100, 90, 150, 25);
        tPassword = new JPasswordField();
        tPassword.setBounds(100, 130, 150, 25);

        //BOTONES
        boton1 = new JButton("Crear cuenta/Login");
        boton1.setBounds(10, 180, 160, 30);
        boton1.addActionListener(this);

        //ETIQUETAS PANEL3
        eNombre3 = new JLabel("Nombre");
        eNombre3.setBounds(10, 10, 80, 35);
        eApellidos3 = new JLabel("Apellidos");
        eApellidos3.setBounds(10, 40, 80, 50);
        eDni3 = new JLabel("DNI");
        eDni3.setBounds(10, 60, 80, 90);
        ePassword3 = new JLabel("Password");
        ePassword3.setBounds(10, 95, 80, 100);

        //TEXTFIELDS PANEL3
        tNombre3 = new JTextField(20);
        tNombre3.setBounds(100, 10, 150, 25);
        tApellidos3 = new JTextField(20);
        tApellidos3.setBounds(100, 50, 150, 25);
        tDni3 = new JTextField(20);
        tDni3.setBounds(100, 90, 150, 25);
        tPassword3 = new JPasswordField();
        tPassword3.setBounds(100, 130, 150, 25);

        //BOTONES PANEL3
        boton3 = new JButton("Editar");
        boton3.setBounds(10, 180, 120, 30);
        boton3.addActionListener(this);

        //Los añado en el layout
        panel1.add(eNombre);
        panel1.add(tNombre);
        panel1.add(eApellidos);
        panel1.add(tApellidos);
        panel1.add(eDni);
        panel1.add(tDni);
        panel1.add(ePassword);
        panel1.add(tPassword);
        panel1.add(boton1);

        panel3.add(eNombre3);
        panel3.add(tNombre3);
        panel3.add(eApellidos3);
        panel3.add(tApellidos3);
        panel3.add(eDni3);
        panel3.add(tDni3);
        panel3.add(ePassword3);
        panel3.add(tPassword3);
        panel3.add(boton3);

        //MENU
        //MENU CUENTA
        //creo barra del menu
        barraMenu = new JMenuBar();
        marco.setJMenuBar(barraMenu);
        //creo un menu y la añado en la barra
        menuCuenta = new JMenu("Cuenta");
        barraMenu.add(menuCuenta);
        //creo una opcion y la añado al menu
        mCrearCuenta = new JMenuItem("Crear cuenta");
        menuCuenta.add(mCrearCuenta);
        //Linea separadora
        menuCuenta.add(new JSeparator());
        //creo otra opcion
        mEditarDatos = new JMenuItem("Editar los datos");
        menuCuenta.add(mEditarDatos);

        //MENU ASIENTOS
        JMenu menuAsientos = new JMenu("Asientos");
        barraMenu.add(menuAsientos);
        mComprar = new JMenuItem("Comprar asiento");
        menuAsientos.add(mComprar);

        //establezco oyentes para las opciones del menu
        mCrearCuenta.addActionListener(this);
        mComprar.addActionListener(this);
        mEditarDatos.addActionListener(this);

    }
    
    public void botones2() {
        for (int i = 0; i < 9; i++) {
            botones[i] = new JButton(Integer.toString(1) + Integer.toString(i));
            panel2.add(botones[i]);  // Añade los botones de 1 en 1.
            botones[i].addActionListener(this);
            botones[i].setBackground(Color.WHITE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == boton1) {

            persona = new Persona(tNombre.getText(), tApellidos.getText(), tDni.getText(), tPassword.getText());
            usoFichero.anhadirPersona("usuarios.txt", persona);
        }

        if (e.getSource() == boton3) {

            persona.setNombre(tNombre3.getText());
            persona.setApellidos(tApellidos3.getText());
            persona.setDni(tDni3.getText());
            persona.setPassword(tPassword3.getText());
            usoFichero.modPersona("usuarios.txt", persona);
        }

        //MENU
        if (e.getSource() instanceof JMenuItem) {
            if ("Crear cuenta".equals(e.getActionCommand())) {
                CardLayout cl = (CardLayout) (panel.getLayout());
                cl.show(panel, "panel1");

            }
            if ("Comprar asiento".equals(e.getActionCommand())) {
                CardLayout cl = (CardLayout) (panel.getLayout());
                cl.show(panel, "panel2");
                usoFichero.asientoOcupado("usuarios.txt", botones);
            }
            if ("Editar los datos".equals(e.getActionCommand())) {
                CardLayout cl = (CardLayout) (panel.getLayout());
                cl.show(panel, "panel3");
                tNombre3.setText(tNombre.getText());
                tApellidos3.setText(tApellidos.getText());
                tDni3.setText(tDni.getText());
                tPassword3.setText(tPassword.getText());
            }

        }

        //ELECCION BOTON ASIENTOS
        //BOTON 0
        if (e.getSource() == botones[0] && botones[0].getBackground() == Color.WHITE) {
            Asiento asientoElegido = persona.elegirFila(0);
            persona.comprar(persona, asientoElegido, 0);
            botones[0].setBackground(Color.RED);
            usoFichero.anhadirAsientoAPersona("usuarios.txt", persona, asientoElegido);

        } else if (e.getSource() == botones[0] && botones[0].getBackground() == Color.RED) {
            botones[0].setBackground(Color.WHITE);
            usoFichero.estaPersona("usuarios.txt", persona);
            usoFichero.borrarAsientoAPersona("usuarios.txt", persona);
        }

        //BOTON 1
        if (e.getSource() == botones[1] && botones[1].getBackground() == Color.WHITE) {
            Asiento asientoElegido = persona.elegirFila(1);
            persona.comprar(persona, asientoElegido, 1);
            botones[1].setBackground(Color.RED);
            usoFichero.anhadirAsientoAPersona("usuarios.txt", persona, asientoElegido);

        } else if (e.getSource() == botones[1] && botones[1].getBackground() == Color.RED) {
            botones[1].setBackground(Color.WHITE);
            usoFichero.estaPersona("usuarios.txt", persona);
            usoFichero.borrarAsientoAPersona("usuarios.txt", persona);
        }
        //BOTON 2
        if (e.getSource() == botones[2] && botones[2].getBackground() == Color.WHITE) {
            Asiento asientoElegido = persona.elegirFila(2);
            persona.comprar(persona, asientoElegido, 2);
            botones[2].setBackground(Color.RED);
            usoFichero.anhadirAsientoAPersona("usuarios.txt", persona, asientoElegido);

        } else if (e.getSource() == botones[2] && botones[2].getBackground() == Color.RED) {
            botones[2].setBackground(Color.WHITE);
            usoFichero.estaPersona("usuarios.txt", persona);
            usoFichero.borrarAsientoAPersona("usuarios.txt", persona);
        }
        //BOTON 3
        if (e.getSource() == botones[3] && botones[3].getBackground() == Color.WHITE) {
            Asiento asientoElegido = persona.elegirFila(3);
            persona.comprar(persona, asientoElegido, 3);
            botones[3].setBackground(Color.RED);
            usoFichero.anhadirAsientoAPersona("usuarios.txt", persona, asientoElegido);

        } else if (e.getSource() == botones[3] && botones[3].getBackground() == Color.RED) {
            botones[3].setBackground(Color.WHITE);
            usoFichero.estaPersona("usuarios.txt", persona);
            usoFichero.borrarAsientoAPersona("usuarios.txt", persona);
        }
        //BOTON 4
        if (e.getSource() == botones[4] && botones[4].getBackground() == Color.WHITE) {
            Asiento asientoElegido = persona.elegirFila(4);
            persona.comprar(persona, asientoElegido, 4);
            botones[4].setBackground(Color.RED);
            usoFichero.anhadirAsientoAPersona("usuarios.txt", persona, asientoElegido);

        } else if (e.getSource() == botones[4] && botones[4].getBackground() == Color.RED) {
            botones[4].setBackground(Color.WHITE);
            usoFichero.estaPersona("usuarios.txt", persona);
            usoFichero.borrarAsientoAPersona("usuarios.txt", persona);
        }
        //BOTON 5
        if (e.getSource() == botones[5] && botones[5].getBackground() == Color.WHITE) {
            Asiento asientoElegido = persona.elegirFila(5);
            persona.comprar(persona, asientoElegido, 5);
            botones[5].setBackground(Color.RED);
            usoFichero.anhadirAsientoAPersona("usuarios.txt", persona, asientoElegido);

        } else if (e.getSource() == botones[5] && botones[5].getBackground() == Color.RED) {
            botones[5].setBackground(Color.WHITE);
            usoFichero.estaPersona("usuarios.txt", persona);
            usoFichero.borrarAsientoAPersona("usuarios.txt", persona);
        }
        //BOTON 6
        if (e.getSource() == botones[6] && botones[6].getBackground() == Color.WHITE) {
            Asiento asientoElegido = persona.elegirFila(6);
            persona.comprar(persona, asientoElegido, 6);
            botones[6].setBackground(Color.RED);
            usoFichero.anhadirAsientoAPersona("usuarios.txt", persona, asientoElegido);

        } else if (e.getSource() == botones[6] && botones[6].getBackground() == Color.RED) {
            botones[6].setBackground(Color.WHITE);
            usoFichero.estaPersona("usuarios.txt", persona);
            usoFichero.borrarAsientoAPersona("usuarios.txt", persona);
        }
        //BOTON 7
        if (e.getSource() == botones[7] && botones[7].getBackground() == Color.WHITE) {
            Asiento asientoElegido = persona.elegirFila(7);
            persona.comprar(persona, asientoElegido, 7);
            botones[7].setBackground(Color.RED);
            usoFichero.anhadirAsientoAPersona("usuarios.txt", persona, asientoElegido);

        } else if (e.getSource() == botones[7] && botones[7].getBackground() == Color.RED) {
            botones[7].setBackground(Color.WHITE);
            usoFichero.estaPersona("usuarios.txt", persona);
            usoFichero.borrarAsientoAPersona("usuarios.txt", persona);
        }
        //BOTON 8
        if (e.getSource() == botones[8] && botones[8].getBackground() == Color.WHITE) {
            Asiento asientoElegido = persona.elegirFila(8);
            persona.comprar(persona, asientoElegido, 8);
            botones[8].setBackground(Color.RED);
            usoFichero.anhadirAsientoAPersona("usuarios.txt", persona, asientoElegido);

        } else if (e.getSource() == botones[8] && botones[8].getBackground() == Color.RED) {
            botones[8].setBackground(Color.WHITE);
            usoFichero.estaPersona("usuarios.txt", persona);
            usoFichero.borrarAsientoAPersona("usuarios.txt", persona);
        }

    }

}
