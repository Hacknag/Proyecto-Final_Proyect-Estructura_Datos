/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PILAS;

import LISTAS_CIRCULARES.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author User
 */
public class Pila {

    private NodoPila cima; //top
    private int largo;

    public Pila() {
        this.cima = null;
        this.largo = 0;
    }

    public boolean Vacia() {
        return cima == null;
    }

    public int tamanio() {
        return this.largo;
    }

    public void push(Ingredientes valor) {
        NodoPila newNode = new NodoPila();
        newNode.setValor(valor);

        if (this.Vacia()) {
            this.cima = newNode;
        } else {
            newNode.setSiguiente(this.cima);
            this.cima = newNode;
        }
        this.largo++;
    }
    
    
        public Ingredientes pop(){
        Ingredientes personaAEliminar = null;
        if (!Vacia()) {
            personaAEliminar = this.cima.getValor();
            this.cima = this.cima.getSiguiente();
            this.largo--;
        }
        return personaAEliminar;
    }



   
    public void listar() {//Se tiene que eliminar despues de pruebas
        // Crea una copia de la pila.
        NodoPila aux = cima;
        // Recorre la pila hasta el ultimo node.
        while (aux != null) {
            System.out.println("|\t" + aux.getValor().getTipo() + "\t|");
            System.out.println("-----------------");
            aux = aux.getSiguiente();
        }
    }

    //poner en un vector los ingredientes de la pila
    public String[] obtenerIngredientespreparacion() {
        List<String> ingredientesList = new ArrayList<>();

        NodoPila aux = cima;
        // Recorre la pila hasta el último nodo.
        while (aux != null) {
            ingredientesList.add(aux.getValor().getTipo());
            aux = aux.getSiguiente();
        }
        Collections.reverse(ingredientesList);
        String[] vector = ingredientesList.toArray(new String[ingredientesList.size()]);

        return vector;
    }

}
