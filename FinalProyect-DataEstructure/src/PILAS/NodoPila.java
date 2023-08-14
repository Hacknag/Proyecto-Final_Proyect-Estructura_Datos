/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PILAS;
import LISTAS_CIRCULARES.*;

/**
 *
 *@author User
 */
public class NodoPila {
    private Ingredientes valor; //dato
    private NodoPila siguiente;
    
    //constructor para inicializar

    public NodoPila() {
        this.valor = null;
        this.siguiente = null;
    }

    public Ingredientes getValor() {
        return valor;
    }

    public void setValor(Ingredientes valor) {
        this.valor = valor;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }
}
