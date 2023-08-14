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

    public void inserta(Ingredientes p) {
        if (cabeza == null) {
            cabeza = new Nodo(p);
            ultimo = cabeza;
        } else if (p.getId() < cabeza.getDato().getId()) {
            Nodo nuevoNodo = new Nodo(p);
            nuevoNodo.setNext(cabeza);
            cabeza.setBack(nuevoNodo); // Agregar enlace hacia atrás
            cabeza = nuevoNodo;
        } else if (ultimo.getDato().getId() <= p.getId()) {
            ultimo.setNext(new Nodo(p));
            ultimo.getNext().setBack(ultimo); // Agregar enlace hacia atrás
            ultimo = ultimo.getNext();
        } else {
            Nodo aux = cabeza;
            while (aux.getNext().getDato().getId() < p.getId()) {
                aux = aux.getNext();
            }
            Nodo temp = new Nodo(p);
            temp.setNext(aux.getNext());
            temp.setBack(aux); // Agregar enlace hacia atrás
            aux.setNext(temp);
            temp.getNext().setBack(temp); // Agregar enlace hacia atrás
        }
        ultimo.setNext(cabeza);
        cabeza.setBack(ultimo); // Agregar enlace hacia atrás
    }

    public boolean existe(int id) {
        boolean esta = false;
        if (cabeza != null) {
            Nodo aux = cabeza;
            while (aux != null && aux.getDato().getId() != id) {
                aux = aux.getNext();
            }
            esta = (aux != null && aux.getDato().getId() == id);
        }
        return esta;
    }

    public void modifica(Ingredientes p) {
        if (cabeza != null) {
            Nodo aux = cabeza;
            while (aux != null && aux.getDato().getId() != p.getId()) {
                aux = aux.getNext();
            }
            if (aux != null && aux.getDato().getId() == p.getId()) {
                aux.getDato().setTipo(p.getTipo());
            }
        }
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
    
    public void mueveIzq() {
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

    public void elimina(int id) {
        if (cabeza != null) {
            if (cabeza.getDato().getId() == id) {
                cabeza = cabeza.getNext();
                cabeza.setBack(ultimo); // Actualizar enlace hacia atrás
            } else {
                Nodo aux = cabeza;
                while (aux.getNext() != null && aux.getNext().getDato().getId() < id) {
                    aux = aux.getNext();
                }
                if (aux.getNext() != null && aux.getNext().getDato().getId() == id) {
                    aux.setNext(aux.getNext().getNext());
                    if (aux.getNext() != null) {
                        aux.getNext().setBack(aux); // Actualizar enlace hacia atrás
                    } else {
                        ultimo = aux; // Actualizar último si se eliminó el último nodo
                    }
                }
            }
        }
    }

    public Ingredientes extrae(int id) {
        Ingredientes p = null;
        if (cabeza != null) {
            if (cabeza.getDato().getId() == id) {
                p = cabeza.getDato();
                cabeza = cabeza.getNext();
                cabeza.setBack(ultimo); // Actualizar enlace hacia atrás
            } else {
                Nodo aux = cabeza;
                while (aux.getNext() != null && aux.getNext().getDato().getId() < id) {
                    aux = aux.getNext();
                }
                if (aux.getNext() != null && aux.getNext().getDato().getId() == id) {
                    p = aux.getNext().getDato();
                    aux.setNext(aux.getNext().getNext());
                    if (aux.getNext() != null) {
                        aux.getNext().setBack(aux); // Actualizar enlace hacia atrás
                    } else {
                        ultimo = aux; // Actualizar último si se eliminó el último nodo
                    }
                }
            }
        }
        return p;
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
    
    /*
    public void inserta(Ingredientes p){
        if(cabeza==null){
            cabeza = new Nodo(p);
            ultimo = cabeza;    
        }else if(p.getId()<cabeza.getDato().getId()){ //poner al lado izquierdo
            Nodo nuevoNodo = new Nodo(p);
            nuevoNodo.setNext(cabeza);
            cabeza=nuevoNodo;
        }else if(ultimo.getDato().getId() <= p.getId()){//op derecha
            ultimo.setNext(new Nodo(p));
            ultimo =ultimo.getNext();
            
        }else{
           Nodo aux = cabeza;
           while (aux.getNext().getDato().getId()
                   <p.getId()){
               aux=aux.getNext();
           }
           Nodo temp = new Nodo(p);
           temp.setNext(aux.getNext());
           aux.setNext(temp);
        } 
        ultimo.setNext(cabeza);
        cabeza.setBack(ultimo);
    }
    
    public boolean existe (int id){
        boolean esta = false;
        //Busca en lista, y retorna true si una persona tiene el id
        //en la lista
        if (cabeza != null){
            //Si hay algo en la lista buscaré
            Nodo aux = cabeza;
            //utilizo aux como indice

            //Mientras no se acabe la lista y el elemento
            //de la lista sea menor que el buscado
            while (aux.getDato().getId() < id){
                aux = aux.getNext () ;//avanzo en la lista
            }

            //verdadero si lo encontró
            esta = (aux.getDato().getId()== id);
        }

        return esta;
    }
    
    public void modifica (Ingredientes p) {
        //busca a si existe alguien con el id, y le actualiza el nombre
        if (cabeza != null) {
            //Si hay algo en la lista buscaré
            Nodo aux = cabeza; //utilizo aux como indice
            //Mientras no se acabe la lista y el elemento
            //de la lista sea menor que el buscado
            while (aux.getDato().getId() < p.getId()) {
                aux = aux. getNext (); //avanzo en la lista
            }
            // Si lo encuentra hago el cambio
            if (aux. getDato () .getId () == p.getId ()){
                //Solo básta cambiar nombre
                //cabeza = cabeza.getNext();
                aux.getDato().setTipo(p.getTipo()) ;
                aux.getBack().getDato().setTipo(p.getTipo());
            }
        }
    } 
    public void elimina (int id) {
        //Si una persona tiene el id, lo elimina
        if (cabeza != null) { //Si hay algo en la lista buscaré
            if (cabeza.getDato().getId() == id) 
            {
                
                cabeza.getNext().setBack(null);
                cabeza = cabeza.getNext();
            } 
            else {
                Nodo aux = cabeza; //utilizo aux como indice
                //Mientras no se acabe la lista y el elemento
                //de la lista sea menor que el buscado
                while (aux. getNext () != null &&
                    aux.getNext () .getDato () .getId() < id) {
                    //aux = aux.getNext () ;
                    aux.getNext().setBack(aux);
                }
                //avanzo en la lista
            
                // si es el de adelante lo borro
                if (aux.getNext () .getDato () .getId () == id) {
                    aux. setNext (aux.getNext () .getNext ()); //cambio las referencias
                }
            }
        }
    }
    
    public Ingredientes extrae (int id) {
        Ingredientes p = null;
        //si una persona tiene el id, lo extrae (eliminando y retornando)
        if (cabeza != null) { //Si hay algo en la lista buscaré
            if (cabeza.getDato () .getId () == id) {
                cabeza = cabeza. getNext () ;
            } else {
                Nodo aux = cabeza; //utilizo aux como indice
                //Mientras no se acabe la lista y el elemento
                //de la lista sea menor que el buscado
                while (aux.getNext() .getDato(). getId()
                < id){
                    aux = aux. getNext () ;
                    //avanzo en la lista
                }
                // Si es el de adelante... quardo la persona y lo borro
                if (aux. getNext () .getDato () .getId() == id) {
                    p = aux. getNext () .getDato () ;
                    aux. setNext (aux.getNext () .getNext () ) ;//cambio las referencias
                }
            }
        }
        return p;
    }
    
     */
    @Override
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
