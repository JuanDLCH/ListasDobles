/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.listasdobles;

/**
 *
 * @author juand
 */
public interface iList<T> {

    /*
    *Agregar un dato al inicio de la lista
     */
    public void add(T d);

    /*
    *Agregar un dato al final de la lista
     */
    public void addLast(T d);

    /*
    *Verificar si la lista está vacía
    *Retornar true si está vacía
     */

 /*
    *Borrar un dato ingreasado por el usuario de la lista
    *Generar error si no hay datos para borrar
     */
    public void delete(String dato) throws Exception;

    /*
    Determinar si un dato ingresado ya existe
     */
    public boolean exists(String dato) throws Exception;

    /*
    Determinar si la lista está vacía
     */
    public boolean isEmpty();

    /*
        Mostrar todos los datos de la lista y retornarlos en una cadena
        de texto
     */
    public String showStudentData();

    /*
    Mostrar un estudiante en cuestión de su código
     */
    public String show(String codigo) throws Exception;

    /*
    Muestra todos los estudiantes que pertenecen a un barrio en común
    */
    public String neighborhoodData(String barrio) throws Exception;
    
    public void addAfter(String cedula, T est) throws Exception;
}
