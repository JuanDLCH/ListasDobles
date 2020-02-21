/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.listasdobles;

/**
 *
 * @author juand
 * @param <T>
 */
public class DoublyLinkedList<T extends Estudiante> implements iList<T> {

    private DoubleNode<T> head;
    private DoubleNode<T> tail;

    public DoublyLinkedList() {
        head = tail = null;
    }

    /*
    Añade un item al inicio de la lista
     */
    @Override
    public void add(T d) {
        if (isEmpty()) {
            head = tail = new DoubleNode<>(d);
        } else {
            head = new DoubleNode<>(d, null, head);
            head.getNextNode().setPreviousNode(head);
        }
    }

    /*
    Añade un item al final de la lista
     */
    @Override
    public void addLast(T d) {
        if (isEmpty()) {
            head = tail = new DoubleNode<>(d);
        } else {
            tail = new DoubleNode<>(d, tail, null);
            tail.getPreviousNode().setNextNode(tail);
        }
    }

    /*
    Retorna verdadero si la lista está vacía
     */
    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    /*
    Muestra los datos todos los estudiantes
     */
    @Override
    public String showStudentData() {
        String data = "";
        DoubleNode<T> current = this.head;
        while (current != null) {
            data += "Cédula: " + current.getData().getCedula()
                    + " Nombre: " + current.getData().getNombre()
                    + " Barrio: " + current.getData().getBarrio()
                    + " Nota: " + current.getData().getNota() + "\n";
            current = current.getNextNode();
        }
        return data;
    }

    /*
    Borra los datos de un estudiante seleccionado por su cédula
     */
    @Override
    public void delete(String dato) throws Exception {
        DoubleNode<T> current = this.head;
        if (current.getData().getCedula().equals(dato)) {
            this.head = current.getNextNode();
        } else {
            while (!current.getNextNode().getData().equals(dato)) {
                current = current.getNextNode();
            }
            current.setNextNode(current.getNextNode().getNextNode());
        }
    }

    /*
    Determina si existe un estudiante con esa cédula
     */
    @Override
    public boolean exists(String dato) {
        DoubleNode<T> current = this.head;
        while (current != null) {
            if (current.getData().getCedula().equals(dato) || current.getData().getBarrio().equals(dato)) {
                return true;
            }
            current = current.getNextNode();
        }
        return false;
    }

    /*
    Muestra la información de un estudiante buscado por su cédula, lanza una
    excepción si no existe ningún estudiante con esa cédula
     */
    @Override
    public String show(String codigo) throws Exception {
        if (!exists(codigo)) {
            throw new Exception("No existe estudiante con esta cédula");
        } else {
            DoubleNode<T> current = this.head;
            while (current != null) {
                if (current.getData().getCedula().equals(codigo)) {
                    return "Cédula: " + current.getData().getCedula() + "\n"
                            + "Nombre: " + current.getData().getNombre() + "\n"
                            + "Barrio: " + current.getData().getBarrio() + "\n"
                            + "Nota: " + current.getData().getNota();
                }
                current = current.getNextNode();
            }
            return "";
        }
    }

    /*
    Muestra la información de los estudiantes de cierto barrio ingresado por el
    usuario, si no existe ninguno perteneciente a ese barrio, lanza una excepción 
     */
    @Override
    public String neighborhoodData(String barrio) throws Exception {
        String datos = "";
        if (!exists(barrio)) {
            throw new Exception("No existe el barrio");
        } else {
            DoubleNode<T> current = this.head;
            while (current != null) {
                if (current.getData().getBarrio().equals(barrio)) {
                    datos += "Cédula: " + current.getData().getCedula()
                            + " Nombre: " + current.getData().getNombre()
                            + " Barrio: " + current.getData().getBarrio()
                            + " Nota: " + current.getData().getNota() + "\n";
                }
                current = current.getNextNode();
            }
            return datos;
        }

    }

    /*
    Añade un nodo delante de otro especificado por el usuario
     */
    @Override
    public void addAfter(String cedula, T est) throws Exception {
        DoubleNode<T> current = this.head;
        DoubleNode<T> newNode = new DoubleNode<>(est);
        if (isEmpty()) {
            add(est);
        } else {
            if (exists(cedula)) {
                while (!current.getData().getCedula().equals(cedula)) {
                    current = current.getNextNode();
                }
                newNode.setNextNode(current.getNextNode());
                current.setNextNode(newNode);
            } else {
                throw new Exception("No existe estudiante con la cédula ingresada");
            }
        }
    }

}
