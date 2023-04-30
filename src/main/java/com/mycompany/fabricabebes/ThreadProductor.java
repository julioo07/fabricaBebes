/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fabricabebes;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julio Bermúdez
 */
public class ThreadProductor extends Thread{
    private boolean isRunning = true;
    private boolean isPaused = false;
    Simulacion simulacion;
    private String tipo;
    private int tiempo = 2;

    public ThreadProductor(Simulacion simulacion, String tipo) {
        this.simulacion = simulacion;
        this.tipo = tipo;
    }
    
    
    
    @Override
    public void run() {
        
        
        while(isRunning){
            try {
                    sleep(tiempo*1000);
                    //fabricar!!!
                    int numeroAmor = (new Random()).nextInt(3) + 1;
                    int numeroArte = (new Random()).nextInt(2) + 1;
                    int numeroPersonalidad = (new Random()).nextInt(2) + 1;
                    if (tipo.equals("Amor")){
                        if (simulacion.qAmor.size() < simulacion.maxAmor){
                            simulacion.qAmor.add(new Amor(numeroAmor));
                            //simulacion.printQAmor();
                            
                        }else{
                            this.isPaused = true;
                        }
                    }
                    if (tipo.equals("Arte")){
                        if (simulacion.qArte.size() < simulacion.maxArte){
                            simulacion.qArte.add(new Arte(numeroArte));
                            //simulacion.printQAmor();
                            
                        }else{
                            this.isPaused = true;
                        }
                    }
                    if (tipo.equals("Personalidad")){
                        if (simulacion.qPersonalidad.size() < simulacion.maxPersonalidad){
                            simulacion.qPersonalidad.add(new Personalidad(numeroPersonalidad));
                            //simulacion.printQAmor();
                            
                        }else{
                            this.isPaused = true;
                        }
                    }
                    
                } catch (InterruptedException ex) {
                    
                }
            
            
            
            while(isPaused){
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    
                }
            }
            
            
            
        }
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void setIsPaused(boolean isPaused) {
        this.isPaused = isPaused;
    }
    
    public boolean isActive(){
        return !this.isPaused;
    }
    
    
    
    
    
    
    
    
    
}