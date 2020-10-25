package com.procesoResumen2.yinglin;


import com.procesoResumen2.yinglin.Apropiativo.Fifo;
import com.procesoResumen2.yinglin.Apropiativo.SJF;
import com.procesoResumen2.yinglin.NoApropiativo.RR;
import com.procesoResumen2.yinglin.NoApropiativo.SRT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Controlador {

    //Constructor
    public Controlador(){}

    //Comportamiento

    /**
     * Método que ejecuta el comando que toca segun lo que escoja el usuario.
     * @param opcion
     * @throws IOException
     */
    public void ejecutar(int opcion) throws IOException {

        //Llamar a los dos métodos que hemos creado posteriormente.
        addProcesoLista1();
        addProcesoLista2();

        switch (opcion) {
            case 1:
                new Fifo(addProcesoLista1()).run();
                break;
            case 2:
                new SJF(addProcesoLista1()).run();
                break;
            case 3:
                new SRT(addProcesoLista1()).run();
                break;
            case 4:
                //Pregunta el numero de quantum que quiere para RR.
                Scanner sn = new Scanner(System.in);
                System.out.println("¿Que quantum quieres?");
                int numeroQuatum = sn.nextInt();

                new RR(addProcesoLista1()).run(numeroQuatum);
                break;
            case 5:
                Main.salir();

                break;
            default:
                //Obliga a que sea los número del 1 al 4.
                System.out.println("Solo números entre 1 y 5\n");
        }
    }

    /**
     * Método que añade los procesos a una lista, para comprobar el algoritmo realizado.
     */
    private ArrayList<Proceso> addProcesoLista1() {

        ArrayList<Proceso> lista1=new ArrayList<Proceso>();

        Proceso proceso1 = new Proceso('C', 3, 3);
        Proceso proceso2 = new Proceso('B', 2, 4);
        Proceso proceso3 = new Proceso('A', 0, 5);
        Proceso proceso4 = new Proceso('D', 5, 2);
        Proceso proceso5 = new Proceso('E', 6, 3);

        lista1.add(proceso1);
        lista1.add(proceso2);
        lista1.add(proceso3);
        lista1.add(proceso4);
        lista1.add(proceso5);

        //Sirve para ordena los procesos ,por si los procesos que nos dan son desordenada.
        Collections.sort(lista1);
        return lista1;
    }

    /**
     * Método que añade los procesos a una lista, para comprobar el algoritmo realizado.
     */
    private ArrayList<Proceso> addProcesoLista2() {

        ArrayList<Proceso>lista2=new ArrayList<Proceso>();

        Proceso proceso11 = new Proceso('D', 5, 3);
        Proceso proceso12 = new Proceso('B', 1, 4);
        Proceso proceso13 = new Proceso('E', 6, 4);
        Proceso proceso14 = new Proceso('A', 0, 3);
        Proceso proceso15 = new Proceso('C', 3, 2);

        lista2.add(proceso11);
        lista2.add(proceso12);
        lista2.add(proceso13);
        lista2.add(proceso14);
        lista2.add(proceso15);

        //Sirve para ordena los procesos ,por si los procesos que nos dan son desordenada.
        Collections.sort(lista2);
        return lista2;
    }
}
