package Principal;

import batallaDeDigimones.*;

import java.util.Random;

public class gestion {

    /**
     *
     * @param trainer → El domador es obligatorio de pasarlo, en caso de que sa su primer digimon le pondrá inicialmente un "Agumon", si no el digimon que le hayamos pasado
     *
     * @param d → Este digimon será el que capturemos en los combates para evitar posibles errores esta variable es opcional, además de estar en try-catch.
     *
     *            Lo de que sea opcional está hecho de la siguiente manera:
     *
     *            [TIPO DE VARIABLE] [...] [NOMBRE DE LA VARIABLE]
     *            Los 3 puntos de en medio hace que le puedas pasar desde 0 hasta las que quieras.
     */
    public static void agregarDigimon(domador trainer, digimon ... d){
        if(trainer.getPrimerDigimon()){
            digimon primero = new digimon("Agumon");
            trainer.getEquipoDigimon().add(primero);
            trainer.setPrimerDigimon(false);
        }else {
            try{
                for (digimon digi : d) {
                    trainer.getEquipoDigimon().add(digi);
                }
            } catch (Exception e) {
                System.err.println("ERROR: No hay suficientes digimones");
            }
        }
    }

    /**
     *Este método hace el ataque de un digimon común, el cual hace el daño justo (Puntos de Ataque)
     *
     * @param miDigimon → El digimon que hará el ataque
     *
     * @param enemigo → El digimon que recibirá el ataque
     *
     * @return → Retorno un true en caso de que el enemigo se quede sin vida o un false en caso de que no
     */
    public void AtaqueComun(digimon miDigimon, digimon enemigo){
        int vidaARestar =  enemigo.getPuntosSalud();
        int ataque =miDigimon.getPuntosAtaque();
        int NumeroPuntosDeAtaqueDigitalesComun=miDigimon.getNumeroAtaqueDigitalesComunes();

        if(NumeroPuntosDeAtaqueDigitalesComun>0){
            miDigimon.setNumeroAtaqueDigitalesComunes(NumeroPuntosDeAtaqueDigitalesComun-1);

            System.out.println("Has usado un ataque común, te quedan "+miDigimon.getNumeroAtaqueDigitalesComunes()+" puntos de ataque digitales comunes");

            enemigo.setPuntosSalud(vidaARestar-ataque);

            if(enemigo.getPuntosSalud()<=0){
                enemigo.setPuntosSalud(0);
            }

        }else{
            System.out.println("No tienes puntos de ataque digitales comunes");
        }
    }

    /**
     *Este método hace el ataque de un digimon de especie, el cual hace el doble daño (Puntos de Ataque)
     *
     * @param miDigimon → El digimon que hará el ataque
     *
     * @param enemigo → El digimon que recibirá el ataque
     *
     * @return → Retorno un true en caso de que el enemigo se quede sin vida o un false en caso de que no (Este sirve para terminar el combate o no)
     */
    public void AtaqueEspecie(digimon miDigimon, digimon enemigo){
        int vidaARestar = enemigo.getPuntosSalud();
        int ataque =miDigimon.getPuntosAtaque();
        int NumeroPuntosDeAtaqueDigitalesEspecie=miDigimon.getNumeroAtaqueDigitalesEspecie();

        if(NumeroPuntosDeAtaqueDigitalesEspecie>0){
            miDigimon.setNumeroAtaqueDigitalesComunes(NumeroPuntosDeAtaqueDigitalesEspecie-1);

            System.out.println("Has usado un ataque especie, te quedan "+miDigimon.getNumeroAtaqueDigitalesEspecie()+" puntos de ataque digitales de especie");

            enemigo.setPuntosSalud(vidaARestar-(ataque*2));

            if(enemigo.getPuntosSalud()<=0){
                enemigo.setPuntosSalud(0);
            }
        }else{
            System.out.println("No tienes puntos de ataque digitales de especie");
        }
    }

    /**
     * Este método hace que el enemigo ataque al digimon del domador, la probabilidad de que el ataque sea de común o de especie es 60/40 respectivamente.
     *
     * @param trainer → Le paso el domador para en caso de digimon muera, poder quitarlo de la lista del equipo.
     *
     * @param mio → El digimon que recibirá el ataque y que en caso de morir, se quita del equipo.
     *
     * @param enemigo → El digimon que realiza el ataque
     *
     */
    public void ataqueEnemigo(domador trainer, digimon mio, digimon enemigo){

        Random r = new Random();

        if(r.nextInt(11)<=6){
            AtaqueComun(enemigo, mio);
        }else{
            AtaqueEspecie(enemigo, mio);
        }

        if (mio.getPuntosSalud()<=0){
            mio.setPuntosSalud(0);
            System.out.println("Tu digimon está tieso (La ha palmado), cambia si te queda alguno."+"\n"+"Sino GGWP");

            for(int i = 0; i < trainer.getEquipoDigimon().size(); i++){
                if(trainer.getEquipoDigimon().get(i).getNombre().equals(mio.getNombre())){
                    trainer.getEquipoDigimon().remove(i);
                    break;
                }
            }

        }
    }

    /**
     * Este método captura un digimon
     *
     * @param trainer → El domador que intenta capturar el digimon
     *
     * @param enemigo → El digimon que puede ser capturado
     *
     * @return → Retorno un true en caso de que el enemigo sea capturado o un false en caso de que no (Este sirve para terminar el combate o no)
     */
    public void Captura(domador trainer, digimon mio, digimon enemigo){
        if (((enemigo.getSaludCapturable())>=enemigo.getPuntosSalud()) && (enemigo.getNivel()>=2)){

            agregarDigimon(trainer, enemigo);

            System.out.println("El digimon "+enemigo.getNombre()+" ha sido capturado por "+trainer.getNombre());

            if(enemigo.getNombre().equals("Agumon")){
                trainer.setCapturadoAgumon(true);
            }else if(enemigo.getNombre().equals("Gabumon")){
                trainer.setCapturadoGabumon(true);
            }else if(enemigo.getNombre().equals("Patamon")){
                trainer.setCapturadoPatamon(true);
            }
        }else{
            System.out.println("El digimon "+enemigo.getNombre()+" no ha podido ser capturado");
            ataqueEnemigo(trainer, mio, enemigo);
        }
    }

    public boolean salir(domador trainer, boolean terminarBatalla){
        if(trainer.getCapturadoAgumon() && trainer.getCapturadoGabumon() && trainer.getCapturadoPatamon()){
            terminarBatalla=true;

            System.out.println("¡Felicidades "+trainer.getNombre()+" has completado el juego!");
        }

        for (int i = 0; i < trainer.getEquipoDigimon().size(); i++) {
            if(trainer.getEquipoDigimon().get(i).getPuntosSalud()==0){
                trainer.getEquipoDigimon().remove(i);
            }
        }

        if (trainer.getEquipoDigimon().isEmpty()){
            terminarBatalla = true;
        }
        return terminarBatalla;
    }

}
