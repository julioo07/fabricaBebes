/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fabricabebes;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Julio Bermúdez
 */
public class Simulacion {
    interfazFabrica refPantalla;
    ThreadPrinter printerThread;
    
    //productores
    ThreadProductor prodAmor;
    ThreadProductor prodArte;
    ThreadProductor prodPersonalidad;
    
    
    ThreadProductorBebes prodBebes;
    
    //colas
    ArrayList<Amor> qAmor = new ArrayList<Amor>();
    int maxAmor = 20; 
    ArrayList<Arte> qArte = new ArrayList<Arte>();
    int maxArte = 20; 
    ArrayList<Personalidad> qPersonalidad = new ArrayList<Personalidad>();
    int maxPersonalidad = 20; 
    ArrayList<Bebe> qBebes = new ArrayList<Bebe>();
    int maxBebes = 20; 
    ArrayList<Bebe> qDefectuosos = new ArrayList<Bebe>();
    
    //Queue<Bebe> honeados;

    public Simulacion(interfazFabrica refPantalla) {
        this.refPantalla = refPantalla;
        prodAmor = new ThreadProductor(this, "Amor");
        prodArte  = new ThreadProductor(this, "Arte");
        prodPersonalidad  = new ThreadProductor(this, "Personalidad");
        prodBebes = new ThreadProductorBebes(this);
        //
        printerThread =  new ThreadPrinter(this);
    }
    
    
    void iniciarSimulacion(){
        prodAmor.start();
        prodArte.start();
        prodPersonalidad.start();
        prodBebes.start();
        //... todos los starts
        printerThread.start();
    }
    
    void pausarSimulacion(){
        prodAmor.setIsPaused(true);
        prodArte.setIsPaused(true);
        prodPersonalidad.setIsPaused(true);
        prodBebes.setIsPaused(true);     
    }
    
    void resumeSimulacion(){
        prodAmor.setIsPaused(false);
        prodArte.setIsPaused(false);
        prodPersonalidad.setIsPaused(false);
        prodBebes.setIsPaused(false); 
    }
    
    private String printQueue(ArrayList arr){
        
        String str = "";
        for (int i = 0; i < arr.size(); i++) {
             str += (i+1) + "." + arr.get(i).toString() + "\n";
        }
        return str;
    }
    
    
    public void print(){
        this.printQBebes();
        this.printQDefectuosos();
        this.printQAmor();
        this.printQArte();
        this.printQPersonalidad();
        
        
        
        refPantalla.setLabelColorStatus(refPantalla.lblStatusTAmor, this.prodAmor.isActive());
        refPantalla.setLabelColorStatus(refPantalla.lblStatusTArte, this.prodArte.isActive());
        refPantalla.setLabelColorStatus(refPantalla.lblStatusTPersonalidad, this.prodPersonalidad.isActive());
        refPantalla.setLabelColorStatus(refPantalla.lblStatusTBebes, this.prodBebes.isActive());
    }
    
    public void printQAmor(){
        refPantalla.printQueueAmor(this.printQueue(qAmor));
    }
    public void printQArte(){
        refPantalla.printQueueArte(this.printQueue(qArte));
    }
    public void printQPersonalidad(){
        refPantalla.printQueuePersonalidad(this.printQueue(qPersonalidad));
    }
    public void printQBebes(){
        refPantalla.printQueueBebes(this.printQueue(qBebes));
    }
    public void printQDefectuosos(){
        refPantalla.printQueueDefectuosos(this.printQueue(qDefectuosos));
    }
 
    
    
    public void setTiempoAmor(int tiempo){
        prodAmor.setTiempo(tiempo);
    }
    public void setTiempoArte(int tiempo){
        prodArte.setTiempo(tiempo);
    }
    public void setTiempoPersonalidad(int tiempo){
        prodPersonalidad.setTiempo(tiempo);
    }
    public void setTiempoBebes(int tiempo){
        prodBebes.setTiempo(tiempo);
    }

    
    
    public void setPausaAmor(){
        prodAmor.setIsPaused(true);
    }
    public void setPausaArte(){
        prodArte.setIsPaused(true);
    }
    public void setPausaPersonalidad(){
        prodPersonalidad.setIsPaused(true);
    }
    public void setPausaBebes(){
        prodBebes.setIsPaused(true);
    }
    
    
    
    
    public void setResumeAmor(){
        prodAmor.setIsPaused(false);
    }
    public void setResumeArte(){
        prodArte.setIsPaused(false);
    }
    public void setResumePersonalidad(){
        prodPersonalidad.setIsPaused(false);
    }
    public void setResumeBebes(){
        prodBebes.setIsPaused(false);
    }
    
    
    
}
