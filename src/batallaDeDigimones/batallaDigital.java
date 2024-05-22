package batallaDeDigimones;

import Auxiliar.escaneres;

import Principal.gestion;

import java.util.ArrayList;
import java.util.Random;

public class batallaDigital {
    digimon enemigo;

    gestion miGestion = new gestion();

    Random r = new Random();

    public batallaDigital(){

        String[] nombres = {"Agumon", "Gabumon", "Patamon"};
        enemigo = new digimon(nombres[r.nextInt(nombres.length)]);

    }

    // getters y setters enemigo

    public digimon getEnemigo() {
        return enemigo;
    }
    public void setEnemigo(digimon enemigo) {
        this.enemigo = enemigo;
    }

    /**
     *Este método cambia entre los digimones que hay en el equipo
     *
     * @param trainer → El domador que está intentando cambiar de digimon
     *
     * @return → El nuevo digimon que va a entrar en combate de los que tiene en el equipo.
     *
     */

    public digimon elegir(domador trainer){
        int eleccion=0;

        ArrayList<digimon> digimons = trainer.getEquipoDigimon();

        System.out.println("Digimons disponibles:");

        for (int i = 0; i < digimons.size(); i++) {
            System.out.println((i+1) + ". " + digimons.get(i).getNombre()+" Nv."+digimons.get(i).getNivel());
        }

        try{
            System.out.print("Ingrese el número del digimon que desea elegir: ");
            eleccion = escaneres.nextInt();
        }catch (NumberFormatException e){
            System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
            eleccion=0;
        }


        if (eleccion >= 1 && eleccion <= digimons.size()) {
            return digimons.get(eleccion-1);
        } else {
            System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
            return null;
        }
    }

    public digimon pelea(domador trainer, digimon mio, digimon enemigo){

        int opcion;

        System.out.println("Tu digimon es: " + mio.getNombre()+" Nv. "+mio.getNivel()
                + "\n"+" HP:" + mio.getPuntosSalud()+" | ATQ: "+mio.getPuntosAtaque()+"\n\n");
        System.out.println("Tu rival es: " + enemigo.getNombre()+" Nv. "+enemigo.getNivel()
                + "\n"+" HP:" + enemigo.getPuntosSalud()+" | ATQ: "+enemigo.getPuntosAtaque()+"\n\n");

        System.out.println("""
                
                ¿Que quieres hacer?
                
                1. Atacar con el ataque común
                2. Atacar con el ataque de especie
                3. Capturar
                
                ¿Qué opción escoges?
                
        """);

        opcion=escaneres.nextInt();

        switch (opcion) {
            case 1:
                miGestion.AtaqueComun(mio, enemigo);

                if (enemigo.getPuntosSalud() != 0) {
                    miGestion.ataqueEnemigo(trainer, mio, enemigo);
                }else if(enemigo.getPuntosSalud() == 0){
                    enemigo=nuevoEnemigo();
                }

                break;
            case 2:
                miGestion.AtaqueEspecie(mio, enemigo);

                if (enemigo.getPuntosSalud()!= 0) {
                    miGestion.ataqueEnemigo(trainer, mio, enemigo);
                }else if(enemigo.getPuntosSalud() == 0){
                    enemigo=nuevoEnemigo();
                }

                break;
            case 3:
               miGestion.Captura(trainer, mio, enemigo);
                enemigo=nuevoEnemigo();
            break;
        }
        return enemigo;
    }

    public digimon nuevoEnemigo(){
        String[] nombres = {"Agumon", "Gabumon", "Patamon"};
        digimon enemigo = new digimon(nombres[r.nextInt(nombres.length)]);
        return enemigo;
    }
}
