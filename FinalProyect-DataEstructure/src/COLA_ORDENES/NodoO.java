/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COLA_ORDENES;

/**
 *
 * @author Arman
 */
public class NodoO {

    private OrdenO dato;
    private NodoO atras;

    public NodoO(OrdenO dato) {
        this.dato = dato;
        this.atras = null;
    }

    public OrdenO getDato() {
        return dato;
    }

    public void setDato(OrdenO dato) {
        this.dato = dato;
    }

    public NodoO getAtras() {
        return atras;
    }

    public void setAtras(NodoO atras) {
        this.atras = atras;
    }
}
