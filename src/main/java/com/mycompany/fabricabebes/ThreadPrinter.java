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
public class ThreadPrinter extends Thread{
    private boolean isRunning = true;
    private boolean isPaused = false;
    Simulacion simulacion;
    private int tiempo = 1;

    public ThreadPrinter(Simulacion simulacion) {
        this.simulacion = simulacion;
    }

    @Override
    public void run() {

        while(isRunning){
            try {
                    sleep(tiempo*1000);
                    simulacion.print();
                } catch (InterruptedException ex) {
                    
                }
            
            
            
        }
    }  
}
