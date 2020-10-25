package com.procesoResumen2.yinglin.NoApropiativo;

import com.procesoResumen2.yinglin.Proceso;

import java.util.ArrayList;

public class RR {

    //Estado

    /**
     * número de ciclo sirve para contar los ciclos que llevamos.
     * número de proceso almacenará el tamaño de la lista de proceso que tenemos, para poder calcular el índice de penalización.
     */

    int numeroCiclo,numeroProceso;

    /**
     * Variable para auqello proceso que aun no ha terminado de ejecutar.
     */
    Proceso procesoEjecutar;

    /**
     * Array con todos los procesos desde principio.
     */
    ArrayList<Proceso> listaTotalProceso;

    /**
     * Array que almacenará los procesos que no han terminado aún.
     */
    ArrayList<Proceso> listaProcesoAEjecutar = new ArrayList<>();

    //Constructor
    public RR(ArrayList<Proceso> colecciProceso) {
        this.listaTotalProceso = colecciProceso;
        this.numeroCiclo = 0;
        this.procesoEjecutar=colecciProceso.get(0);
        numeroProceso=listaTotalProceso.size();
        listaTotalProceso.remove(0);

    }
    //Comportamiento
    /**
     * Método que realiza el algoritmo Round-Robin que le pasamos por el parametro lo quantum que queremos.
     * @param quantum
     */
    public void run(int quantum){
        //Variable que almacenará la suma de todos los indices de cada proceso.
        float indiceTotal=0;

        //Variable para que solo me pinte la veces que me diga el quantum
        int num=quantum;

        while(procesoEjecutar.getEjecucion()!=0){
            if (num!=0) {
                if (procesoEjecutar.getEjecucion() > 1) {
                    numeroCiclo++;
                    procesoEjecutar.ejecutar();
                    System.out.println(procesoEjecutar.formatoNoTerminado(numeroCiclo));
                    num--;
                    //buscarElSiguiente();
                } else {
                    numeroCiclo++;
                    procesoEjecutar.ejecutar();
                    System.out.println(procesoEjecutar.formatoTerminado(numeroCiclo));
                    float resultado = procesoEjecutar.CalcularIndice(numeroCiclo);
                    indiceTotal+=resultado;
                    num=quantum;
                    llenarLista();
                    buscarElSiguiente();
                }
            }else {
                //Reseteamos el quantum para otro proceso.
                num=quantum;

                llenarLista();
                buscarElSiguiente();
            }

        }
        //Almacena el indice de penalización total.
        float resultadoTotal = indiceTotal/numeroProceso;

        //Mustra por pantalla el índice de penalización medio.
        System.out.format("\nEl índice de penalizacion medio es : %.2f",resultadoTotal);
        System.out.println("\nProceso terminado\n");

    }

    /**
     * Método que busca el siguiente Proceso y lo añade a la lista si aun no ha acabado.
     */
    private void buscarElSiguiente(){
        if (listaProcesoAEjecutar.size()!=0){
           if (procesoEjecutar.getEjecucion()!=0){
               listaProcesoAEjecutar.add(procesoEjecutar);
           }

            procesoEjecutar=listaProcesoAEjecutar.remove(0);
        }
    }

    /**
     * Método que llena la lista de proceso que esta aún ejecutando.
     */
    private void llenarLista(){
        if (listaTotalProceso.size() != 0) {
            while(numeroCiclo >= listaTotalProceso.get(0).getTiempoLlegada()){
                listaProcesoAEjecutar.add(listaTotalProceso.get((0)));
                listaTotalProceso.remove(0);
                if (listaTotalProceso.isEmpty()){
                    break;
                }
            }
        }
    }
}
