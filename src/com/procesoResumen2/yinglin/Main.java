package com.procesoResumen2.yinglin;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    //Estado

    /**
     * Variable que controla para salir.
     */
    private static boolean salir = false;

    /**
     * Controlador
     */
    private static Controlador miControlador = new Controlador();

    //Comportamiento
    public static void main(String args[]) throws IOException {
        menu();

    }
    /**
     * Método menú donde puedo elegir a que algoritmo quiero utilizar o ejecutar primero.
     * @throws IOException
     */
    private static void menu() throws IOException {
        Scanner sn = new Scanner(System.in);

        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1.FIFO");
            System.out.println("2.SJF");
            System.out.println("3.SRT");
            System.out.println("4.RR");
            System.out.println("5.Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                miControlador.ejecutar(opcion);

                //Obliga introducir número.
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }catch(IOException e) {
                System.out.println("ERROR VUELVES A INTENTAR");
            }
        }
        System.out.println("Terminado");
        sn.close();
    }

    /**
     * Método que me controla para finalizar el proyecto.
     */
    public static void salir() {
        salir=true;
    }
}
