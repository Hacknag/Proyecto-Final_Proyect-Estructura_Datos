/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COLAS;

/**
 *
 *@author User
 */
public class Nodo {
    private Dispositivo dato;
    private Nodo atras;
    
    public Nodo(Dispositivo dato) {
        this.dato = dato;
        this.atras = null;
    }

    public Dispositivo getDato() {
        return dato;
    }

    public void setDato(Dispositivo dato) {
        this.dato = dato;
    }

    public Nodo getAtras() {
        return atras;
    }

    public void setAtras(Nodo atras) {
        this.atras = atras;
    }
    
}