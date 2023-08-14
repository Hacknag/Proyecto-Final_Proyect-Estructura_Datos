/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LISTAS_CIRCULARES;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Ingredientes {
    private int id;
    private String tipo;
    
    public Ingredientes (int id, String tipo){
        this.id = id;
        this.tipo = tipo;
    }
    
    public Ingredientes(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    //Esta es la funcion para agregar un ingrediente ramdom
    public String IngredienteAleatorio (){
        Random rand = new Random();
        int tipoIngrediente = rand.nextInt(4);
        switch (tipoIngrediente) {
            case 0:
                return  "pan";
            case 1:
                return "carne";
            case 2:
                return "queso";
            default:
                return"lechuga";
        }
    }
    
    @Override
    public String toString(){
        return "Ingrediente{" + "id="+id+", ingrediente="+tipo+'}';
    }
}
