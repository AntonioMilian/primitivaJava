package javaapplication21;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.net.URL;

/**
 * Este es el panel de herramientas de la primitiva, que hara que todo tenga funcionalidad
 * 
 * @author Bilal Rota
 * @version 04/06/2015
 */
public class PanelHerramientas extends JToolBar
{
    //--------- CONSTANTES ----------
    private static final String IMAGEN_SORTEAR = "Imagenes/IconoSortear.png";
    private static final String IMAGEN_REINICIAR = "Imagenes/IconoReiniciar.png"; 
    private static final String IMAGEN_ESTADISTICA = "Imagenes/IconoEstadistica.png"; 
    private static final String IMAGEN_SALIR = "Imagenes/IconoSalir.png";
    private static final int ESPACIO_BOTONES =4;
    private static final int ESPACIO = 1;
    private static final int NUMEROS_PERMITIDOS = 6;
    //--------- CAMPOS --------------

    private Juego juego;
    private PanelNumeros panelNumeros;

    private JButton btnSortear;
    private JButton btnReiniciar;
    private JButton btnEstadistica;
    private JButton btnSalir;

    private int numPartidasJugadas;
    /**
     * Constructor for objects of class PanelHerramientas
     */
    public PanelHerramientas(int posicion, PanelNumeros panelNumeros)
    {
        this.panelNumeros = panelNumeros;

        crearBotonSortear();
        crearBotonReiniciar();
        crearBotonEstadistica();
        crearBotonSalir();

        numPartidasJugadas = 0;

        this.setLayout(new GridLayout(4,1,ESPACIO_BOTONES,ESPACIO_BOTONES));        
        this.setBorder(new EmptyBorder(ESPACIO,ESPACIO,ESPACIO,ESPACIO));
    }

    /**
     * Boton encargado de sortear los numeros ganadores
     */
    private void crearBotonSortear(){
        btnSortear = new JButton();

        URL urlImagen = PanelHerramientas.class.getClassLoader().getResource(IMAGEN_SORTEAR); 

        btnSortear.setIcon(new ImageIcon(urlImagen));

        btnSortear.addActionListener(new ActionListener() {
                public void actionPerformed (ActionEvent e){
                    if (panelNumeros.retornaPulsados() < NUMEROS_PERMITIDOS){
                        JOptionPane.showMessageDialog(panelNumeros, "No has seleccionado suficientes numeros, la cantidad necesaria es: "+NUMEROS_PERMITIDOS);
                    }
                    else{
                        panelNumeros.numerosAzar();
                        btnSortear.setEnabled(false);
                        btnEstadistica.setEnabled(true);
                    }
                    numPartidasJugadas++;
                }
            });
        this.add(btnSortear);
    }

    /**
     * Boton que reinicia la primitiva
     */
    private void crearBotonReiniciar(){
        btnReiniciar = new JButton();

        URL urlImagen = PanelHerramientas.class.getClassLoader().getResource(IMAGEN_REINICIAR);        
        btnReiniciar.setIcon(new ImageIcon(urlImagen));

        btnReiniciar.addActionListener(new ActionListener() {
                public void actionPerformed (ActionEvent e){
                    btnSortear.setEnabled(true);
                    panelNumeros.reiniciarTodo();
                }
            });
        this.add(btnReiniciar);
    }

    /**
     * Boton que saca las estadisticas de la partida
     */
    private void crearBotonEstadistica(){
        btnEstadistica = new JButton();
        btnEstadistica.setEnabled(false);
        URL urlImagen = PanelHerramientas.class.getClassLoader().getResource(IMAGEN_ESTADISTICA);        
        btnEstadistica.setIcon(new ImageIcon(urlImagen));

        btnEstadistica.addActionListener(new ActionListener() {
                public void actionPerformed (ActionEvent e){
                    String texto = "El número de partidas jugadas es: "+numPartidasJugadas +"\n" +panelNumeros.calculador() ;
                    
                    JOptionPane.showMessageDialog(panelNumeros,texto);
                }
            });
        this.add(btnEstadistica);
    }

    /**
     * Boton para salir de la aplicacion
     */
    private void crearBotonSalir(){
        btnSalir = new JButton();

        URL urlImagen = PanelHerramientas.class.getClassLoader().getResource(IMAGEN_SALIR);        
        btnSalir.setIcon(new ImageIcon(urlImagen));

        btnSalir.addActionListener(new ActionListener() {
                public void actionPerformed (ActionEvent e){
                    salir();
                }
            });
        this.add(btnSalir);
    }

    /**
     * Metodo para salir
     */
    private void salir(){
        System.exit(0);
    }

}
