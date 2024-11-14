package practica_programada_2;

import javax.swing.JOptionPane;

public class Practica_Programada_2 {

    public static void main(String[] args) {
        
        ListaC l = new ListaC();
        
        l.inserta(new Evaluacion("Pedro", "Sanchez", Materia.Estructuras_de_Datos, 1, 24));
        l.inserta(new Evaluacion("Alberto", "Aguero", Materia.Estructuras_de_Datos, 2, 93));
        l.inserta(new Evaluacion("Juan", "Santamaria", Materia.Estructuras_de_Datos, 3, 100));
        l.inserta(new Evaluacion("Juan", "Martinez", Materia.Estructuras_de_Datos, 4, 33));
        l.inserta(new Evaluacion("Maria", "Jimenez", Materia.Estructuras_de_Datos, 5, 72));
        JOptionPane.showMessageDialog(null, l);
        JOptionPane.showMessageDialog(null, l.busquedaId(2));
        JOptionPane.showMessageDialog(null, l.busquedaNombre("Pedro"));
        l.estadisticas();
        //Llame al metodo notaMayor
        //Llame al metodo notaMenor
        //Extrae una Evaluacion de la lista y muestra la Evaluacion extraida
        l.eliminar(1);
        l.estadisticas();
        
    }
    
}
