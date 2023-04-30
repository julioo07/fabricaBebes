/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fabricabebes;

/**
 *
 * @author Julio Bermúdez
 */
public class Personalidad {
    private int valor;

    public Personalidad(int valor) {
        this.valor = valor;
    }
    
    
    @Override
    public String toString() {
        return "Personalidad " + "[" + valor + "]";
    }

    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
    
}
