package com.procesoResumen2.yinglin.NoApropiativo;

import com.procesoResumen2.yinglin.Proceso;

import java.util.ArrayList;

public class SRT {
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
     * Lista de proceso.
     */
    ArrayList<Proceso> colecciProceso;

    //Constructor

    public SRT(ArrayList<Proceso> colecciProceso) {
        this.colecciProceso = colecciProceso;
        this.numeroCiclo = 0;
        this.procesoMenor = colecciProceso.get(0);
        numeroProceso=colecciProceso.size();
    }


    //Comportamiento

    /**
     * Método que realiza el algoritmo SRT.
     */
    public void run() {
        //Variable que almacenará la suma de todos los indices de cada proceso.
        float indiceTotal=0;

        while (colecciProceso.size() != 0) {
            numeroCiclo++;

            if (procesoMenor.getEjecucion() > 1) {
                procesoMenor.ejecutar();
                System.out.println(procesoMenor.formatoNoTerminado(numeroCiclo));
                buscarRafagaMenor();

            } else {
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
        System.out.println("\nEl índice de penalizacion medio es : "+resultadoTotal);

        System.out.println("\nProceso terminado\n");

    }

    /**
     * Método que busca el ráfaga menor para utilizarlo posteriormente.
     */
    private void buscarRafagaMenor() {
        if (colecciProceso.size() != 0) {
            procesoMenor = colecciProceso.get(0);
            for (int i = 1; i < colecciProceso.size(); i++) {
                if (numeroCiclo >= colecciProceso.get(i).getTiempoLlegada()) {
                    if (procesoMenor.getEjecucion() > colecciProceso.get(i).getEjecucion()) {
                        procesoMenor = colecciProceso.get(i);
                    }
                } else {
                    break;
                }

            }
        }
    }
}
