package javaapplication21;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Esta es la clase de los numeros de la primitiva
 * 
 * @author Bilal Rota
 * @version 04/06/2015
 */
public class Numeros extends JButton implements ActionListener, MouseListener
{
    private static final Color SIN_PULSAR = Color.white; // Color de la luz encendida
    private static final Color PULSADA = Color.lightGray; // Color de la luz apagada
    private static final Color ACERTADA = Color.green;
    private static final Color NO_ACERTADA = Color.cyan;
    private static final Color COLOR_NUMEROS = Color.red;
    private static final int NUMEROS_PERMITIDOS = 6;

    private boolean pulsada;
    private boolean haSalido; // para comprobar si el numero ha salido ya
    private int numVecesHaSalido;
    
    //     private boolean haSidoPulsada;

    private PanelNumeros panelNumeros;

    /**
     * Constructor for objects of class Numeros
     */
    public Numeros(int numero,PanelNumeros panelNumeros)
    {
        super(numero+"");
        this.panelNumeros = panelNumeros;
        this.setBackground(SIN_PULSAR);
        this.setFont(new Font("Arial", Font.BOLD, 18));
        this.setForeground(COLOR_NUMEROS);
        pulsada = false;
        haSalido = false;
        numVecesHaSalido = 0;
        addActionListener(this);
        addMouseListener(this);
    }

    /**
     * Se llama a este metodo cuando el usuario clicka sobre un boton
     */
    public void actionPerformed(ActionEvent event){
        if (pulsada){
            pulsada = false;
            this.setBackground(SIN_PULSAR);
            panelNumeros.restaPulsados();
        }
        else {
            if (panelNumeros.retornaPulsados() >= NUMEROS_PERMITIDOS){
                JOptionPane.showMessageDialog(panelNumeros, "Has pulsado mas de "+NUMEROS_PERMITIDOS);
            }
            else{
                pulsada = true;
                this.setBackground(PULSADA);
                panelNumeros.aumentaPulsados();
            }
        }
    }

    /**
     * Motodo para comprobar si se puede volver a sortear
     */
    public boolean haSalido(){
        return haSalido;
    }

    /**
     * Metodo para cambiar los colores de los aciertos o errores
     */
    public void acertada(){
        if (!pulsada){
            this.setBackground(NO_ACERTADA);
            haSalido = true;
        }
        else {
            this.setBackground(ACERTADA);
        }
        numVecesHaSalido++;
    }

    /**
     * Metodo para reiniciar el boton
     */
    public void reiniciar(){
        this.setBackground(SIN_PULSAR);
        pulsada = false;
        haSalido = false;
    }

    /**
     * Get de los botones para sacar el resultado en el caso de que
     * haya sido pulsada o no
     */
    public boolean pulsada(){
        return pulsada;
    }
    
    public int vecesHaSalido(){
        return numVecesHaSalido;
    }

    //PARA CUANDO PASAMOS EL RATON POR ENCIMA
    /**
     * Metodos usados para cambiar el color del numero al pasar el raton por encima
     * Desde este hasta mouseClicked
     */
    public void mouseEntered(MouseEvent e){
        this.setForeground(Color.ORANGE);
    }

    public void mouseExited(MouseEvent e){
        this.setForeground(COLOR_NUMEROS);
    }

    public void mousePressed(MouseEvent e){
        //NO NECESARIO
    }

    public void mouseReleased(MouseEvent e){
        //NO NECESARIO
    }

    public void mouseClicked(MouseEvent e){
        //NO NECESARIO
    }
    //----------------------------------------

}
