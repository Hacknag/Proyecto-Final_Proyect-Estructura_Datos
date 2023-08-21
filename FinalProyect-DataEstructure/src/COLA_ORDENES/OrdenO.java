/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package COLA_ORDENES;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Arman
 */
public class OrdenO {
    private int Id;
    private String descripcion;

    public OrdenO(int Id, String descripcion) {
        this.Id = Id;
        this.descripcion = descripcion;
    }

    public OrdenO() {
    }

    public int getId() {
        return Id;
    }

    public void setID(int Id) {
        this.Id = Id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String randomListOrdenes() {
        List<String> myList = Arrays.asList("Hamburguesa de carne",
                "Hamburguesa con queso",
                "Hamburguesa clasica");
        Random r = new Random();
        int randomitem = r.nextInt(myList.size());
        String randomElement = myList.get(randomitem);

        return randomElement;

    }
}
