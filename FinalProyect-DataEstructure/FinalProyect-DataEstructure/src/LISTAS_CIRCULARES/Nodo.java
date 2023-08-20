/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LISTAS_CIRCULARES;


/**
 *
 * @author User
 */
public class Nodo {
    private Ingredientes dato;
    private Nodo next;
    private Nodo back; 
    
    @Override
    public String toString(){
        return "Nodo{"+"dato="+dato+'}';
    }
    
    public Nodo(Ingredientes dato){
        this.dato=dato;
    }

    public Ingredientes getDato() {
        return dato;
    }

    public void setDato(Ingredientes dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
    
    public Nodo getBack() {
        return back;
    }

    public void setBack(Nodo back) {
        this.back = back;
    }
}
