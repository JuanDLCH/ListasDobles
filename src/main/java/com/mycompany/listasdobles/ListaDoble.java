/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.listasdobles;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author juand
 */
public class ListaDoble {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList<Estudiante> estudiantes = new DoublyLinkedList<>();
        DoublyLinkedList<Estudiante> ganaron = new DoublyLinkedList<>();
        DoublyLinkedList<Estudiante> perdieron = new DoublyLinkedList<>();
        /*estudiantes.add(new Estudiante("1000638705", "Juan", "Robledo", 2.0));
        estudiantes.add(new Estudiante("22148167", "Camila", "Calasanz", 3.2));
        estudiantes.add(new Estudiante("3620896", "Miguel", "Belen", 4.3));
        estudiantes.add(new Estudiante("1128455282", "Alex", "San Javier", 0.0));*/
        String doc = "", nombre = "", barrio = "";
        Double nota = 0.0;
        boolean salida = false;
        do {
            System.out.print("Ingrese el documento del estudiante: ");
            doc = scanner.next();
            System.out.print("Ingrese el nombre del estudiante: ");
            nombre = scanner.next();
            System.out.print("Ingrese el barrio donde vive el estudiante: ");
            barrio = scanner.next();
            System.out.print("Ingrese la nota del estudiante: ");
            nota = scanner.nextDouble();
            if (estudiantes.exists(doc)) {
                System.out.println("El dato ingresado ya existe");
            } else {
                if (nota >= 3) {
                    estudiantes.add(new Estudiante(doc, nombre, barrio, nota));
                    ganaron.add(new Estudiante(doc, nombre, barrio, nota));
                } else {
                    estudiantes.addLast(new Estudiante(doc, nombre, barrio, nota));
                    perdieron.add(new Estudiante(doc, nombre, barrio, nota));
                }
            }
            System.out.print("¿Desea continuar? S/N");
            salida = scanner.next().equals("N");
        } while (!salida);
        System.out.println(estudiantes.showStudentData());
        buscarEstudiante(estudiantes);
        System.out.println("\n Añadir estudiante después de otro buscado por su cédula");
        System.out.print("Ingrese el documento del estudiante: ");
        doc = scanner.next();
        System.out.print("Ingrese el nombre del estudiante: ");
        nombre = scanner.next();
        System.out.print("Ingrese el barrio donde vive el estudiante: ");
        barrio = scanner.next();
        System.out.print("Ingrese la nota del estudiante: ");
        nota = scanner.nextDouble();
        if (estudiantes.exists(doc)) {
            System.out.println("El estudiante ingresado ya existe");
        } else {
            try {
                System.out.println("Ingrese la cédula del estudiante que desea mover hacia atrás en la lista");
                estudiantes.addAfter(scanner.next(), new Estudiante(doc, nombre, barrio, nota));
                System.out.println("Añadido con éxito");
            } catch (Exception ex) {
                Logger.getLogger(ListaDoble.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
        System.out.println(estudiantes.showStudentData());
        System.out.println("Ingrese un barrio para seleccionar estudiantes");
        try {
            System.out.println(estudiantes.neighborhoodData(scanner.next()));
        } catch (Exception ex) {
            Logger.getLogger(ListaDoble.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void buscarEstudiante(DoublyLinkedList<Estudiante> estudiantes) {
        Scanner scanner = new Scanner(System.in);
        String cod;
        System.out.println("Ingrese el código del estudiante a buscar");
        cod = scanner.next();
        try {
            System.out.println(estudiantes.show(cod));
        } catch (Exception ex) {
            Logger.getLogger(ListaDoble.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void pedirDatos(String doc, String nombre, String barrio, Double nota) {

    }
}
