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
public class ThreadProductorBebes extends Thread{
    private boolean isRunning = true;
    private boolean isPaused = false;
    Simulacion simulacion;
    private int tiempo = 2;

    public ThreadProductorBebes(Simulacion simulacion ) {
        this.simulacion = simulacion;
    }
    
    @Override
    public void run() {
        while(isRunning){
            try {
                    sleep(tiempo*1000);
                    int creados;
                    int posibilidad = (new Random()).nextInt(100) + 1;
                    if (posibilidad <= 90){
                        //unico
                        creados = 1;
                    }else if (posibilidad <= 95 && posibilidad > 90){
                        //mellizos
                        creados = 2;
                    }else if (posibilidad <= 98 && posibilidad > 95){
                        //trillizos
                        creados = 3;
                    }else{
                        //otro
                        creados = (new Random()).nextInt(3,6) + 1;
                    }
                    
                    //fabricar bebés y encolarlos!!!
                    
                    
                    if (simulacion.qBebes.size() < simulacion.maxBebes){
                        if (simulacion.qAmor.size() > 0 &&
                            simulacion.qArte.size() > 0 &&
                            simulacion.qPersonalidad.size() > 0){
                            Amor sAmor = simulacion.qAmor.remove(0);
                            Arte sArte = simulacion.qArte.remove(0);
                            Personalidad sPersonalidad = simulacion.qPersonalidad.remove(0);
                            int Am = sAmor.getValor();
                            int Ar = sArte.getValor();
                            int Per = sPersonalidad.getValor();
                    
                            System.out.println(sAmor.getValor());
                            System.out.println(sArte.getValor());
                            System.out.println(sPersonalidad.getValor());
                            System.out.println(creados);
                            System.out.println("-----------");
                            
                            for (int i = 0; i < creados; i++) {  
                                Bebe nuevoBebe = new Bebe(Am, Ar, Per);
                                if (nuevoBebe.getTipo().equals("DEFECTUOSO")){
                                    simulacion.qDefectuosos.add(nuevoBebe);
                                }else{
                                    simulacion.qBebes.add(nuevoBebe);
                                }
                            
                            //simulacion.printQBebes();
                            }                    
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