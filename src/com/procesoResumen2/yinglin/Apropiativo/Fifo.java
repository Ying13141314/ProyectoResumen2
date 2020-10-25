package com.procesoResumen2.yinglin.Apropiativo;

import com.procesoResumen2.yinglin.Proceso;

import java.util.ArrayList;

public class Fifo {
    //Estado

    /**
     * número de ciclo sirve para contar los ciclos que llevamos.
     * número de proceso almacenará el tamaño de la lista de proceso que tenemos, para poder calcular el índice de penalización.
     */
    int numCiclo,numeroProceso;

    /**
     * Array de los procesos.
     */
    ArrayList<Proceso> coleccionProceso;

    //Constructor

    public Fifo(ArrayList<Proceso> coleccionProceso) {
        this.coleccionProceso = coleccionProceso;
        numCiclo = 0;
        numeroProceso = coleccionProceso.size();
    }

    //Comportamiento

    /**
     *  Método que realiza el algoritmo Fifo.
     */
    public void run(){
        //Variable que almacenará la suma de todos los indices de cada proceso.
        float indiceTotal=0;

        for (int contador=0;contador<coleccionProceso.size();contador++) {
            for (int i = 0; i < coleccionProceso.get(contador).getRafaga(); i++) {
                numCiclo++;
                coleccionProceso.get(contador).ejecutar();
                 if (coleccionProceso.get(contador).getEjecucion() != 0) {
                    System.out.println(coleccionProceso.get(contador).formatoNoTerminado(numCiclo));
                } else {
                    System.out.println(coleccionProceso.get(contador).formatoTerminado(numCiclo));
                    float resultado = coleccionProceso.get(contador).CalcularIndice(numCiclo);
                    indiceTotal+=resultado;
                }
            }

        }
        //Otra manera de calcular el indice de penalización.
        //float resultadoTotal = listaResultado.stream().reduce(Float::sum).orElse(0f)/numeroProceso;

        //Almacena el indice de penalización total.
        float resultadoTotal = indiceTotal/numeroProceso;

        //Mustra por pantalla el índice de penalización medio.
        System.out.format("\nEl índice de penalizacion medio es : %.2f",resultadoTotal);

        System.out.println("\nProceso terminado\n");
    }

}
