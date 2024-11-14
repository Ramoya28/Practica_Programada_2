package practica_programada_2;

public class NodoC {

    private Evaluacion dato;
    private NodoC sig, ant;

    public NodoC() {
    }

    public NodoC(Evaluacion dato) {
        this.dato = dato;
    }

    public Evaluacion getDato() {
        return dato;
    }

    public void setDato(Evaluacion dato) {
        this.dato = dato;
    }

    public NodoC getSig() {
        return sig;
    }

    public void setSig(NodoC sig) {
        this.sig = sig;
    }

    public NodoC getAnt() {
        return ant;
    }

    public void setAnt(NodoC ant) {
        this.ant = ant;
    }

    @Override
    public String toString() {
        return "NodoC{" + "dato=" + dato + '}';
    }

}
