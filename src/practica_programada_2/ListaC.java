package practica_programada_2;

public class ListaC {

    private NodoC cabeza, ultimo;

    public boolean esVacia() {
        if (cabeza == null) {
            return true;
        } else {
            return false;
        }
    }

    public void inserta(Evaluacion e) {
        NodoC nuevo = new NodoC(e);
        if (this.esVacia()) {
            cabeza = nuevo;
            //circular
            ultimo = nuevo;
            ultimo.setSig(cabeza);
            //doble
            cabeza.setAnt(ultimo);
        } else if (nuevo.getDato().getNumCarnet() <= cabeza.getDato().getNumCarnet()) {
            nuevo.setSig(cabeza);
            cabeza.setAnt(nuevo);//doble
            cabeza = nuevo;
            //circular
            ultimo.setSig(cabeza);
            //doble
            cabeza.setAnt(ultimo);
        } else if (nuevo.getDato().getNumCarnet() >= ultimo.getDato().getNumCarnet()) {
            ultimo.setSig(nuevo);
            nuevo.setAnt(ultimo);//doble
            ultimo = nuevo;
            ultimo.setSig(cabeza);
            //doble
            cabeza.setAnt(ultimo);
        } else {
            NodoC aux = cabeza;
            while (aux.getSig() != ultimo
                    && aux.getSig().getDato().getNumCarnet() < nuevo.getDato().getNumCarnet()) {
                aux = aux.getSig();
            }
            //insertar al final o en medio
            nuevo.setSig(aux.getSig());
            aux.setSig(nuevo);
            //doble
            nuevo.setAnt(aux);
            nuevo.getSig().setAnt(nuevo);
        }
    }

    public int eliminar(int n) {
        if (this.esVacia()) {
            return -1;//pila vacia
        } else {
            if (cabeza.getDato().getNumCarnet() == n) {
                if (cabeza == ultimo) {
                    cabeza = ultimo = null;
                } else {
                    this.cabeza = this.cabeza.getSig();
                    ultimo.setSig(cabeza);
                    cabeza.setAnt(ultimo);//doble
                }
                return 1;//logre eliminar
            } else if (ultimo.getDato().getNumCarnet() == n) {
                ultimo = ultimo.getAnt();
                ultimo.setSig(cabeza);
                cabeza.setAnt(ultimo);
                return 1;//logre eliminar
            } else {
                NodoC aux = cabeza;
                while (aux.getSig() != ultimo && aux.getSig().getDato().getNumCarnet() < n) {
                    aux = aux.getSig();
                }
                if (aux.getSig().getDato().getNumCarnet() == n) {
                    aux.setSig(aux.getSig().getSig());
                    //doble
                    aux.getSig().setAnt(aux);
                    return 1;
                }
            }
            return -2;//elemento no encontrado
        }
    }

    @Override
    public String toString() {
        String r = "Lista Doble Enlazada Circular\n";
        if (!this.esVacia()) {
            r += "Vacia";
        } else {
            NodoC aux = cabeza;
            do {
                r += aux + "\n";
                aux = aux.getSig();
            } while (aux != cabeza);

        }
        return r;
    }

}
