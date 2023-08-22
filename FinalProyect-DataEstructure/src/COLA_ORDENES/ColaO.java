/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COLA_ORDENES;

import java.util.Random;

/**
 *
 * @author Arman
 */
public class ColaO {

    private NodoO frente;
    private NodoO ultimo;
    private int largo;

    public ColaO() {
        this.frente = null;
        this.ultimo = null;
        this.largo = 0;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    Random random = new Random();
    OrdenO OR1 = new OrdenO();

    public void encola(NodoO nuevoNodo) {
        if (largo == 3) {
            //no se encola ya que solo pueden haber 3 ordenes
        } else {
            if (frente == null) {  // significa que la cola esta vacia
                frente = nuevoNodo;
                ultimo = nuevoNodo;
            } else {
                ultimo.setAtras(nuevoNodo);
                ultimo = nuevoNodo;
            }
            largo++;
        }

    }

    //este se cambia
    public NodoO atiende() {
        NodoO aux = frente;
        if (frente != null) {
            frente = frente.getAtras();
            aux.setAtras(null);
            largo--;
        }
        return aux;
    }

    //no se cambia
    public boolean encuentra(OrdenO referencia) {
        if (frente != null) {
            if (ultimo.getDato().getId() == referencia.getId()) {
                return true;
            } else {
                NodoO aux = frente;
                while (aux != null) {
                    if (aux.getDato().getId() == (referencia.getId())) {
                        return true;
                    }
                    aux = aux.getAtras();
                }
            }
        }
        return false;
    }

    public void mueve() {
        //Para que la pila gire al utilizar un ingrediente
        try {
            System.out.println(ObtenerFrente());
            System.out.println(ObtenerSegundo());
            if (frente != null) {
                NodoO Primero = frente;
                NodoO Segundo = frente.getAtras();
                NodoO Tercero = frente.getAtras().getAtras();

                frente = Segundo;
                Segundo.setAtras(Tercero);
                largo--;
            }
        } catch (Exception ex) {

        }

    }

    public String ObtenerFrente() {
        String dato = frente.getDato().getDescripcion();
        return dato;
    }

    public String ObtenerSegundo() {
        try {
            String dato = frente.getAtras().getDato().getDescripcion();
            return dato;
        } catch (Exception ex) {
            return " ";
        }

    }

    public String ObtenerTercero() {
        try {
            String dato = frente.getAtras().getAtras().getDato().getDescripcion();
            return dato;
        } catch (Exception ex) {
            return " ";
        }

    }

    public String imprimir() {

        String s = "";
        NodoO aux = frente;
        while (aux != null) {
            s += aux.getDato().getId() + "\n";
            aux = aux.getAtras();
        }
        return s;
    }
}
