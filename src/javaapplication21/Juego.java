package javaapplication21;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Esta es la clase que englobara toda la interfaz y el juego de la primitiva
 * 
 * @author Bilal Rota
 * @version 04/06/2015
 */
public class Juego extends JFrame
{
    //--------- CONSTANTES -----------
    
    private static final int ESPACIO = 8;
    
    //--------- VARIABLES ------------
    
    private PanelHerramientas panelHerramientas;
    private PanelNumeros panelNumeros;
    

    /**
     * Constructor for objects of class Juego
     */
    public Juego()
    {
        super("Juego de la primitiva");
        
        this.panelNumeros = new PanelNumeros();
        this.panelHerramientas = new PanelHerramientas(1,panelNumeros);
        
        construirVentana();
        this.setVisible(true);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(d.width/2- getWidth()/2, d.height/2- getHeight()/2);        
    }

    /**
     * Construimos la ventana con este metodo, incluiremos el panel de herramientas y el de numeros
     */
    public void construirVentana(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setSize(new Dimension(500,400));
        
        JPanel contenedor = (JPanel) this.getContentPane();
        contenedor.setLayout(new BorderLayout(ESPACIO,ESPACIO));
        contenedor.setBorder(new EmptyBorder(ESPACIO,ESPACIO,ESPACIO,ESPACIO));
        
        contenedor.add(panelHerramientas, BorderLayout.WEST);
        contenedor.add(panelNumeros, BorderLayout.EAST);
        
    }
}
