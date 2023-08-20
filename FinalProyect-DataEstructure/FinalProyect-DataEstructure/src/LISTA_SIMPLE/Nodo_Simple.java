/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LISTA_SIMPLE;

/**
 *
 * @author Jennifer
 */
public class Nodo_Simple {
    private Orden dato;
    private Nodo_Simple next;     
        
      @Override
    public String toString(){
        return "Nodo{"+"dato="+dato+'}';
    }

    public Nodo_Simple(Orden dato) {
        this.dato = dato;
    }

    public Orden getDato() {
        return dato;
    }

    public void setDato(Orden dato) {
        this.dato = dato;
    }

    public Nodo_Simple getNext() {
        return next;
    }

    public void setNext(Nodo_Simple next) {
        this.next = next;
    }
}
