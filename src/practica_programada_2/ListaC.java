package practica_programada_2;

import javax.swing.JOptionPane;

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

    public Evaluacion busquedaId(int n) {
        if (this.esVacia()) {
            return null;
        }

        NodoC aux = cabeza;
        do {
            if (aux.getDato().getNumCarnet() == n) {
                return aux.getDato();
            }
            aux = aux.getSig();
        } while (aux != cabeza);

        return null;
    }

    public Evaluacion busquedaNombre(String nombre) {
        if (this.esVacia()) {
            return null;
        }

        NodoC aux = cabeza;
        do {
            if (aux.getDato().getNombre().equals(nombre)) {
                return aux.getDato();
            }
            aux = aux.getSig();
        } while (aux != cabeza);

        return null;
    }

    public void estadisticas() {
        if (this.esVacia()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía.");
            return;
        }

        int totalEvaluaciones = 0;
        int totalAprobados = 0;
        int totalReprobados = 0;
        int sumaNotasAprobados = 0;
        int sumaTotalNotas = 0;

        NodoC aux = cabeza;
        do {
            int nota = aux.getDato().getNota();
            sumaTotalNotas += nota;
            totalEvaluaciones++;

            if (nota >= 70) {
                totalAprobados++;
                sumaNotasAprobados += nota;
            } else {
                totalReprobados++;
            }

            aux = aux.getSig();
        } while (aux != cabeza);

        int promedioAprobados = sumaNotasAprobados / totalAprobados;
        int promedioGeneral = sumaTotalNotas / totalEvaluaciones;

        JOptionPane.showMessageDialog(null, "***** Estadisticas *****\n"
                + "Total de aprobados: " + totalAprobados + "\n"
                + "Total de reprobados: " + totalReprobados + "\n"
                + "Promedio de notas de aprobados: " + promedioAprobados + "\n"
                + "Promedio general de notas: " + promedioGeneral);
    }

    public Evaluacion extrae(int numCarnet) {
        if (this.esVacia()) {
            return null;
        }
        if (cabeza.getDato().getNumCarnet() == numCarnet) {
            Evaluacion extraida = cabeza.getDato();
            eliminar(numCarnet);
            return extraida;
        } else if (ultimo.getDato().getNumCarnet() == numCarnet) {
            Evaluacion extraida = ultimo.getDato();
            eliminar(numCarnet);
            return extraida;
        } else {
            NodoC aux = cabeza;
            while (aux.getSig() != cabeza) {
                if (aux.getSig().getDato().getNumCarnet() == numCarnet) {
                    Evaluacion extraida = aux.getSig().getDato();
                    eliminar(numCarnet);
                    return extraida;
                }
                aux = aux.getSig();
            }
        }
        return null;
    }

    public Evaluacion notaMayor() {
        if (this.esVacia()) {
            return null;
        }
        NodoC aux = cabeza;
        Evaluacion mayor = cabeza.getDato();
        do {
            if (aux.getDato().getNota() > mayor.getNota()) {
                mayor = aux.getDato();
            }
            aux = aux.getSig();
        } while (aux != cabeza);
        return mayor;
    }

    public Evaluacion notaMenor() {
        if (this.esVacia()) {
            return null;
        }
        NodoC aux = cabeza;
        Evaluacion menor = cabeza.getDato();
        do {
            if (aux.getDato().getNota() < menor.getNota()) {
                menor = aux.getDato();
            }
            aux = aux.getSig();
        } while (aux != cabeza);
        return menor;
    }

    @Override
    public String toString() {
        String r = "Lista Doble Enlazada Circular\n";
        if (this.esVacia()) {
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
