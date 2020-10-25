package com.procesoResumen2.yinglin.Apropiativo;

import com.procesoResumen2.yinglin.Proceso;

import java.util.ArrayList;

public class SJF {

    //Estado

    /**
     * número de ciclo sirve para contar los ciclos que llevamos.
     * número de proceso almacenará el tamaño de la lista de proceso que tenemos, para poder calcular el índice de penalización.
     */
    int numeroCiclo,numeroProceso;

    /**
     * Variable que almacenará el proceso menor de todo lo que hay.
     */
    Proceso procesoMenor;

    /**
     * Array de los procesos.
     */
    ArrayList<Proceso> colecciProceso;

    //Constructor

    public SJF(ArrayList<Proceso> colecciProceso) {
        this.colecciProceso = colecciProceso;
        this.numeroCiclo = 0;
        this.procesoMenor=colecciProceso.get(0);
        numeroProceso=colecciProceso.size();
    }



    //Comportamiento

    /**
     * Método que realiza el algoritmo SJF.
     */
    public void run(){
        //Variable que almacenará la suma de todos los indices de cada proceso.
        float indiceTotal=0;

        while(colecciProceso.size()!=0){
            numeroCiclo++;
                if (procesoMenor.getEjecucion() > 1){
                        procesoMenor.ejecutar();
                        System.out.println(procesoMenor.formatoNoTerminado(numeroCiclo));
                    }else {
                        procesoMenor.ejecutar();
                        System.out.println(procesoMenor.formatoTerminado(numeroCiclo));
                        float resultado = procesoMenor.CalcularIndice(numeroCiclo);
                        indiceTotal+=resultado;
                        colecciProceso.remove(procesoMenor);
                        buscarRafagaMenor();
                }

        }

        //Almacena el indice de penalización total.
        float resultadoTotal = indiceTotal/numeroProceso;

        //Mustra por pantalla el índice de penalización medio.
        System.out.format("\nEl índice de penalizacion medio es : %.2f",resultadoTotal);

        System.out.println("\nProceso terminado\n");

    }

    /**
     * Método que busca la ráfaga mínimo.
     */
    private void buscarRafagaMenor(){
        if (colecciProceso.size()!=0){
            procesoMenor = colecciProceso.get(0);
        for (int i = 1; i <colecciProceso.size() ; i++) {
            if (numeroCiclo>=colecciProceso.get(i).getTiempoLlegada()){
                if (procesoMenor.getRafaga()>colecciProceso.get(i).getRafaga()){
                    procesoMenor=colecciProceso.get(i);
                }
            }else {
                break;
            }

        }
        }
        //Otra manera de buscar la ráfaga menor.
        /*colecciProceso.stream().filter(proceso -> proceso.getTiempoLlegada()<numeroCiclo)
                .min(Comparator.comparing(Proceso::getRafaga));*/
    }




}







