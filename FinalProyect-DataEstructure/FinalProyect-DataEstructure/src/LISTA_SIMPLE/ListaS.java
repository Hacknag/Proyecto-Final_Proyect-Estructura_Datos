/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LISTA_SIMPLE;

/**
 *
 * @author Jennifer
 */
public class ListaS {
    private Nodo_Simple cabeza;
    
    public void inserta(Orden p){
        if(cabeza==null){
            cabeza = new Nodo_Simple(p);
        }else if(p.getId()<cabeza.getDato().getId()){
            Nodo_Simple aux = new Nodo_Simple(p);
            aux.setNext(cabeza);
            cabeza=aux;
        }else if(cabeza.getNext()==null){
            cabeza.setNext(new Nodo_Simple(p));
        }else{
           Nodo_Simple aux = cabeza;
           while (aux.getNext() != null &&
                   aux.getNext().getDato().getId()
                   <p.getId()){
               aux=aux.getNext();
           }
           Nodo_Simple temp = new Nodo_Simple(p);
           temp.setNext(aux.getNext());
           aux.setNext(temp);
        } 
    }
    
        public void elimina (int id) {
        //Si una persona tiene el id, lo elimina
        if (cabeza != null) { //Si hay algo en la lista buscaré
            if (cabeza.getDato().getId() == id) 
            {
                cabeza = cabeza.getNext();
            } 
            else {
                Nodo_Simple aux = cabeza; //utilizo aux como indice
                //Mientras no se acabe la lista y el elemento
                //de la lista sea menor que el buscado
                while (aux. getNext () != null &&
                    aux.getNext () .getDato () .getId() < id) {
                    aux = aux.getNext () ;
                }
                //avanzo en la lista
            
                // si es el de adelante lo borro
                if (aux.getNext () != null &&
                aux.getNext () .getDato () .getId () == id) {
                    aux. setNext (aux.getNext () .getNext ()); //cambio las referencias
                }
            }
        }
    }
}
