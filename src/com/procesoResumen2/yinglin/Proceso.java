package com.procesoResumen2.yinglin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Proceso implements Comparable<Proceso> {
    //Estado

    /**
     * Nombre del proceso
     */
    private char pid;

    /**
     * Tiempo de llegada es el tiempo que llega el proceso para ser ejecutada.
     * Ráfaga es las veces que se tiene que ejecutar un proceso.
     * ejecucion sirve para contar la cantidad de veces que hay que ejecutar los procesos.
     */
    private int tiempoLlegada,rafaga,ejecucion;

    //Constructor
    public Proceso(char pid, int tiempoLlegada, int rafaga) {
        this.pid = pid;
        this.tiempoLlegada = tiempoLlegada;
        this.rafaga = rafaga;
        this.ejecucion = rafaga;

    }


    //Comportamiento

    /**
     * Método que sirve para saber si un proceso ha terminado o no.
     */
    public void ejecutar(){
        ejecucion--;

    }

    //Los getter y setter.

    /**
     * Método para obtener Ejecución.
     * @return
     */
    public int getEjecucion() {
        return ejecucion;
    }

    /**
     * Método para obtener Pid.
     * @return
     */
    public char getPid() {
        return pid;
    }

    public void setPid(char pid) {
        this.pid = pid;
    }

    /**
     * Método para obtener tiempo de llegada.
     * @return
     */
    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    /**
     * Método para obtener ráfaga.
     * @return
     */
    public int getRafaga() {
        return rafaga;
    }

    public void setRafaga(int rafaga) {
        this.rafaga = rafaga;
    }

    /**
     * Método que me muestra por pantalla la información del proceso cuando no ha terminado un proceso.
     * @param numCiclo
     * @return
     */
    public String formatoNoTerminado(int numCiclo){
        return "CICLO " + numCiclo + "- Proceso [id=" + pid + ", rafaga pendiente=" + ejecucion + "]";
    }

    /**
     * Método que me muestra por pantalla la información del proceso cuando ha terminado un proceso.
     * @param numCiclo
     * @return
     */
    public String formatoTerminado(int numCiclo){
        return "CICLO " + numCiclo + "- Proceso [id=" + pid + ", rafaga pendiente=" + ejecucion + "]-Terminado";
    }

    /**
     * Método que calcula el indice de cada proceso.
     * @param ciclo
     */
    public float CalcularIndice(int ciclo){
        return (float) (ciclo-tiempoLlegada)/ rafaga;
    }

    /**
     * Método que ordena por orden de llegada y si hay un empate se ordena alfabéticamente.
     * @param procesoNuevo
     * @return
     */
    @Override
    public int compareTo(Proceso procesoNuevo) {
        int compararProceso=0;
        compararProceso=tiempoLlegada-procesoNuevo.getTiempoLlegada();
        if (compararProceso==0){
            compararProceso=pid-procesoNuevo.getPid();
        }
        return compararProceso;
    }
}
