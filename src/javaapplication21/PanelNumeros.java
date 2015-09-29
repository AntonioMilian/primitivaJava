package javaapplication21;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import java.util.Random;

/**
 * Esta clase engloba los numeros dentro de un panel
 * 
 * @author Bilal Rota
 * @version 04/06/2015
 */
public class PanelNumeros extends JPanel
{

    //--------- CONSTANTES --------
    private final static int NUM_BOTONES = 49;
    private final static int NUM_FILAS = 7;
    private static final int ESPACIO = 1;
    private static final int VECES_POSIBLE = 6;

    //--------- VARIABLES --------
    private Numeros[] listaNumeros; //Array de numeros para poder modificarlos al ser pulsados
    private int numerosPulsados;

    private Random generador;

    /**
     * Constructor for objects of class PanelNumeros
     */
    public PanelNumeros()
    {
        listaNumeros = new Numeros[NUM_BOTONES];
        numerosPulsados = 0;

        construirVentana();
        this.setLayout(new GridLayout(NUM_FILAS,NUM_FILAS,ESPACIO,ESPACIO));        
        this.setBorder(new EmptyBorder(ESPACIO,ESPACIO,ESPACIO,ESPACIO));
        generador = new Random();
    }

    /**
     * Construimos los botones
     */
    private void construirVentana(){
        for (int i = 1; i <= NUM_BOTONES; i++){
            Numeros numero = new Numeros(i,this);
            listaNumeros[i-1] = numero;
            this.add(numero);
        }
    }

    /**
     * Metodo para sortear los numeros, sacara varias cifras al azar y las modificara
     * en el tablero segun ha sido pulsado o no
     */
    public void numerosAzar(){

        int numerosSalidos = 0;
        while (numerosSalidos < VECES_POSIBLE){
            int numeroposible = generador.nextInt(NUM_BOTONES);
            if (!listaNumeros[numeroposible].haSalido()){
                listaNumeros[numeroposible].acertada();
                numerosSalidos++;
            }            
        }

    }

    public String calculador(){
        int nMasVecesSalido = 0;
        int vecesPulsado = 0;

        for (int i = 1; i <= NUM_BOTONES; i++){
            if (listaNumeros[i-1].vecesHaSalido() > vecesPulsado){
                nMasVecesSalido = i;
                vecesPulsado = listaNumeros[i-1].vecesHaSalido();
            }

        } 

        String cadenaDeTexto = "El número que mas veces ha salido es el: "+nMasVecesSalido+"\n"+"Ha salido: "+vecesPulsado+" veces";
        return cadenaDeTexto;
    }

    /**
     * Set y get de numeros pulsados usado para no permitir la pulsacion de mas
     * de 6 numeros o los permitidos
     */
    public void aumentaPulsados(){
        numerosPulsados++;
    }

    public void restaPulsados(){
        numerosPulsados--;
    }

    public int retornaPulsados(){
        return numerosPulsados;
    }

    /**
     * Metodo para reiniciar el tablero completamente
     */
    public void reiniciarTodo(){
        for (int i = 1; i <= NUM_BOTONES; i++){
            listaNumeros[i-1].reiniciar();
        } 
        numerosPulsados = 0;
    }

}
