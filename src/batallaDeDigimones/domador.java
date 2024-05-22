package batallaDeDigimones;

import java.util.ArrayList;

import Principal.gestion;

import javax.swing.text.StyledEditorKit;

public class domador {

    // ------------ ATRIBUTOS ------------
    private String nombre;

    /**
     * @param primerDigimon ⇾ Un booleano que indica si es el primer digimon
     */
    private Boolean primerDigimon=true;
    private Boolean capturadoAgumon=true;
    private Boolean capturadoGabumon=false;
    private Boolean capturadoPatamon=false;
    private ArrayList <digimon> equipoDigimon= new ArrayList<digimon>(3);

    // ------------ CONSTRUCTOR ------------

    /**
     *
     * @param nombre → El nombre del domador
     *
     * Uso el método agregarDigimon, ya que en caso de que sea el primer digimon le añadirá automáticamente un Agumon
     */
    public domador(String nombre) {
        this.nombre = nombre;
        gestion.agregarDigimon(this);
    }

    // ------------ GETTER Y SETTER ------------

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getPrimerDigimon() {
        return primerDigimon;
    }
    public void setPrimerDigimon(Boolean primerDigimon) {
        this.primerDigimon = primerDigimon;
    }

    public Boolean getCapturadoAgumon() {
        return capturadoAgumon;
    }
    public void setCapturadoAgumon(Boolean capturadoAgumon) {
        this.capturadoAgumon = capturadoAgumon;
    }

    public Boolean getCapturadoGabumon() {
        return capturadoGabumon;
    }
    public void setCapturadoGabumon(Boolean capturadoGabumon) {
        this.capturadoGabumon = capturadoGabumon;
    }

    public Boolean getCapturadoPatamon() {
        return capturadoPatamon;
    }
    public void setCapturadoPatamon(Boolean capturadoPatamon) {
        this.capturadoPatamon = capturadoPatamon;
    }

    public ArrayList <digimon> getEquipoDigimon() {
        return equipoDigimon;
    }

    public void setEquipoDigimon(ArrayList <digimon> equipoDigimon) {
        this.equipoDigimon = equipoDigimon;
    }

    // ------------ TO STRING ------------

    @Override
    public String toString() {
        return "domador{" +
                "nombre='" + nombre + '\'' +
                ", primerDigimon=" + primerDigimon +
                ", capturadoAgumon=" + capturadoAgumon +
                ", capturadoGabumon=" + capturadoGabumon +
                ", capturadoPatamon=" + capturadoPatamon +
                ", equipoDigimon=" + equipoDigimon +
                '}';
    }

}
