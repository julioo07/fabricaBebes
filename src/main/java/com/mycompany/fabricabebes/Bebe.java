/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fabricabebes;

/**
 *
 * @author Julio Bermúdez
 */
public class Bebe {
    private String tipo;
    private int tipoAmor;
    private int tipoArte;
    private int tipoPersonalidad;

    public Bebe(int tipoAmor, int tipoArte, int tipoPersonalidad) {
        if (tipoAmor == 1 && tipoArte == 2 && tipoPersonalidad == 1){
            this.tipo = "MORENO";
        }else if (tipoAmor == 1 && tipoArte == 2 && tipoPersonalidad == 2){
            this.tipo = "AFRODESCENDIENTE";
        }else if (tipoAmor == 1 && tipoArte == 1 && tipoPersonalidad == 1){
            this.tipo = "RUBIO";
        }else if (tipoAmor == 1 && tipoArte == 1 && tipoPersonalidad == 2){
            this.tipo = "CASTANO";
        }else if (tipoAmor == 2 && tipoArte == 1 && tipoPersonalidad == 1){
            this.tipo = "PELIRROJO";
        }else if (tipoAmor == 2 && tipoArte == 1 && tipoPersonalidad == 2){
            this.tipo = "PINK";
        }else if (tipoAmor == 3 && tipoArte == 2 && tipoPersonalidad == 1){
            this.tipo = "BAD BUNNY";
        }else if (tipoAmor == 3 && tipoArte == 2 && tipoPersonalidad == 2){
            this.tipo = "PITUFO";
        }else
            this.tipo = "DEFECTUOSO";
    
        
        this.tipoAmor = tipoAmor;
        this.tipoArte = tipoArte;
        this.tipoPersonalidad = tipoPersonalidad;
    }
    
    
    
    @Override
    public String toString() {
        return "Bebe: "+ tipo + "(Amor[" + tipoAmor + "], Arte[" + tipoArte + "], Personalidad[" + tipoPersonalidad + "])";
    }
    
    
   
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTipoAmor() {
        return tipoAmor;
    }

    public void setTipoAmor(int tipoAmor) {
        this.tipoAmor = tipoAmor;
    }

    public int getTipoArte() {
        return tipoArte;
    }

    public void setTipoArte(int tipoArte) {
        this.tipoArte = tipoArte;
    }

    public int getTipoPersonalidad() {
        return tipoPersonalidad;
    }

    public void setTipoPersonalidad(int tipoPersonalidad) {
        this.tipoPersonalidad = tipoPersonalidad;
    }
    
    
    
}
