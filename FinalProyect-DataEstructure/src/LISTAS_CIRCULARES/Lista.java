/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LISTAS_CIRCULARES;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Lista {

    private Nodo cabeza;
    private Nodo ultimo;
    
    private Ingredientes ing = new Ingredientes();

    public void inserta(Ingredientes i) {
        if (cabeza == null) {
            cabeza = new Nodo(i);
            ultimo = cabeza;
        } else if (i.getId() < cabeza.getDato().getId()) {
            Nodo nuevoNodo = new Nodo(i);
            nuevoNodo.setNext(cabeza);
            cabeza.setBack(nuevoNodo); 
            cabeza = nuevoNodo;
        } else if (ultimo.getDato().getId() <= i.getId()) {
            ultimo.setNext(new Nodo(i));
            ultimo.getNext().setBack(ultimo);
            ultimo = ultimo.getNext();
        } else {
            Nodo aux = cabeza;
            while (aux.getNext().getDato().getId() < i.getId()) {
                aux = aux.getNext();
            }
            Nodo temp = new Nodo(i);
            temp.setNext(aux.getNext());
            temp.setBack(aux); 
            aux.setNext(temp);
            temp.getNext().setBack(temp); 
        }
        ultimo.setNext(cabeza);
        cabeza.setBack(ultimo); 
    }

    public void contarIngredientesNoVacios() {
    int contador = 0;
    Nodo actual = cabeza;

    if (actual != null) {
        do {
            if (!actual.getDato().getTipo().equals("vacio")) {
                contador++;
            }
            actual = actual.getNext();
        } while (actual != cabeza);
    }
    
        System.out.println(contador);

    // Si hay 3 o menos nodos con tipo "vacio", asignar tipos aleatorios
    if (contador ==2) {
        actual = cabeza;
        if (actual != null) {
            do {
                if (actual.getDato().getTipo().equals("vacio")) {
                    actual.getDato().setTipo(ing.IngredienteAleatorio());
                }
                actual = actual.getNext();
            } while (actual != cabeza);
        }
    }
}

    
    //cuando bota en el basurero
    public void botar(Ingredientes i) {
        if (cabeza != null) {
            Nodo aux = cabeza;
            while (aux != null && aux.getDato().getId() != i.getId()) {
                aux = aux.getNext();
            }
            if (aux != null && aux.getDato().getId() == i.getId()) {
                aux.getDato().setTipo("vacio");
            }
        }
    }
    
    public void mueveIzq() {//Para que la pila gire al utilizar un ingrediente
        if (cabeza != null) {
            Nodo primero = cabeza;
            Nodo segundo = cabeza.getNext();
            Nodo tercero = cabeza.getNext().getNext();
            Nodo cuarto = cabeza.getNext().getNext().getNext();
            Nodo quinto= cabeza.getNext().getNext().getNext().getNext();
            ultimo = quinto;

            // Mover los nodos hacia la izquierda
            cabeza = segundo;
            segundo.setNext(tercero);
            tercero.setNext(cuarto);
            cuarto.setNext(quinto);
            quinto.setNext(primero);
            ultimo.setNext(primero);

            // Actualizar enlaces de regreso
            cabeza.setBack(quinto);   
            segundo.setBack(cabeza);
            tercero.setBack(segundo);
            cuarto.setBack(tercero);
            quinto.setBack(cuarto);
            
            ultimo.setBack(cuarto);
        }
    }

   

    public String[][] obtenerTiposIngredientes() {
        ArrayList<String[]> ingredientesList = new ArrayList<>();

        Nodo actual = cabeza;
        if (actual != null) {
            do {
                Ingredientes ingrediente = actual.getDato();
                String[] infoIngrediente = { Integer.toString(ingrediente.getId()), ingrediente.getTipo() };
                ingredientesList.add(infoIngrediente);
                actual = actual.getNext();
            } while (actual != cabeza);
        }

        String[][] ingredientesArray = new String[ingredientesList.size()][2];
        ingredientesArray = ingredientesList.toArray(ingredientesArray);

        return ingredientesArray;
    }
    
    
    @Override //Para pruebas eliminar despues de pruebas
    public String toString() {
        Nodo aux = cabeza;
        String s = "Lista: ";
        if (aux != null) {
            s += aux + ", ";
            aux = aux.getNext();
            while (aux != cabeza) {
                s += aux + ", ";
                aux = aux.getNext();
            }
        } else {
            s += "vacia";
        }
        return s;
    }
    
    
}
