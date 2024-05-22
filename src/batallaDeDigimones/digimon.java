package batallaDeDigimones;

import java.util.Random;

public class digimon {

    // ------------ ATRIBUTOS ------------

    /**
     * @param r ⇾ Este random es para que genere de forma aleatoria el nivel, puntos de salud y puntos de ataque
     */
    Random r = new Random();

    private String nombre;
    private int nivel;
    private int puntosAtaque;
    private int puntosSalud;
    private int SaludCapturable;
    private int numeroAtaqueDigitalesComunes;
    private int numeroAtaqueDigitalesEspecie;

    // ------------ CONSTRUCTOR ------------
    public digimon() {

    }

    /**
     *
     * @param nombre ⇾ el nombre del digimon será elegido aleatoriamente antes de pasarlo al constructor
     *
     */
    public digimon(String nombre) {
        this.nombre = nombre;
        Random r = new Random();
        this.nivel = r.nextInt(5)+1;
        this.puntosAtaque = nivel*5;
        this.puntosSalud = nivel*10;
        this.SaludCapturable=puntosSalud-20;
        this.numeroAtaqueDigitalesComunes = 10;
        this.numeroAtaqueDigitalesEspecie = 5;
    }

    //------------ GETTER Y SETTER ------------

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public int getPuntosAtaque() {
        return puntosAtaque;
    }
    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }
    public int getPuntosSalud() {
        return puntosSalud;
    }
    public void setPuntosSalud(int puntosSalud) {
        this.puntosSalud = puntosSalud;
    }
    public int getSaludCapturable() {
        return SaludCapturable;
    }
    public int getNumeroAtaqueDigitalesComunes() {
        return numeroAtaqueDigitalesComunes;
    }
    public void setNumeroAtaqueDigitalesComunes(int numeroAtaqueDigitalesComunes) {
        this.numeroAtaqueDigitalesComunes = numeroAtaqueDigitalesComunes;
    }
    public int getNumeroAtaqueDigitalesEspecie() {
        return numeroAtaqueDigitalesEspecie;
    }
    public void setNumeroAtaqueDigitalesEspecie(int numeroAtaqueDigitalesEspecie) {
        this.numeroAtaqueDigitalesEspecie = numeroAtaqueDigitalesEspecie;
    }


    // ------------ TO STRING ------------

    @Override
    public String toString() {
        return "digimon{" +  " nombre=" + nombre + ", nivel=" + nivel + ", puntosAtaque=" + puntosAtaque
                + ", puntosSalud=" + puntosSalud + ", numeroAtaqueDigitalesComunes=" + numeroAtaqueDigitalesComunes
                + ", numeroAtaqueDigitalesEspecie=" + numeroAtaqueDigitalesEspecie + '}';
    }
}

