package Principal;

import batallaDeDigimones.*;
import Auxiliar.escaneres;

/**
 *
 * @author Raúl Martín Torrabadella Mendoza
 *
 */

public class Main {
    public static void main(String[] args) {

        gestion miGestion = new gestion();

        //Crea el objeto trainer
        System.out.println("Dime tu nombre de domador");
        String nombre = escaneres.nextLine();
        domador trainer = new domador(nombre);

        //Crea el objeto digimon
        digimon digi = new digimon();

        //Crea el objeto batalla
        batallaDigital batalla = new batallaDigital();

        //Creo otras variables necesarias
        boolean terminarBatalla = false;
        int opcion;

        System.out.println("Bien, empecemos eligiendo el digimon que deseas usar");
        digi=batalla.elegir(trainer);

        do{
            System.out.println("""
                
                ¿Que quieres hacer?
                
                1. Pelear
                2. Cambiar de digimon
                
                ¿Qué quieres hacer?
                
            """);

            if(digi.getPuntosSalud()<=0){
                System.out.println("Cambia de digimon:");
                opcion = 2;
            }else{
                opcion = escaneres.nextInt();
            }
            switch (opcion){
                case 1:
                    batalla.setEnemigo(batalla.pelea(trainer, digi, batalla.getEnemigo()));
                    break;
                case 2:
                    digi = batalla.elegir(trainer);
                    miGestion.ataqueEnemigo(trainer, digi, batalla.getEnemigo());
                    break;
                default:
                    System.err.println("ERROR: Opcion no valida");
                    break;
            }

            terminarBatalla=miGestion.salir(trainer, terminarBatalla);

        }while (!terminarBatalla);

    }
}