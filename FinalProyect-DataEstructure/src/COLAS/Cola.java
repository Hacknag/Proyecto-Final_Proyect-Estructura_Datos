/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COLAS;

/**
 *
 * @author joseriveratencio
 */
public class Cola {
    private Nodo frente;
    private Nodo ultimo;
    private int largo;

    public Cola() {
        this.frente = null;
        this.ultimo = null;
        this.largo = 0;
    }
        
    public void encola(Nodo nuevoNodo){
        if(frente == null){  // significa que la cola esta vacia
            frente = nuevoNodo;
            ultimo = nuevoNodo;                    
        } else{
            ultimo.setAtras(nuevoNodo);
            ultimo=nuevoNodo;
        }
        largo++;
    }
    
    
    //este se cambia
    public Nodo atiende(){
        Nodo aux = frente;
        if(frente!=null){
            frente=frente.getAtras();
            aux.setAtras(null);
            largo--;
        }
        return aux;
    }
    
    //no se cambia
    public boolean encuentra(Dispositivo referencia){
        if(frente != null){
            if (ultimo.getDato().getNumSerie().equals(referencia.getNumSerie())){
                return true;
            }else{
                Nodo aux=frente;
                while(aux!=null){
                    if(aux.getDato().getNumSerie().equals(referencia.getNumSerie())){
                        return true;
                    }
                    aux=aux.getAtras();
                }
            }
        }
        return false;
    }
    
    public String imprimir(){
        String s="";
        Nodo aux=frente;
        while(aux!=null){
            s+=aux.getDato().getNumSerie()+"\n";
            aux=aux.getAtras();
        }
        return s;
    }
}