package practica_programada_2;

public class Evaluacion {
    
    private String Nombre;
    private String Apellidos;
    private Materia materia;
    private int NumCarnet;
    private int Nota;

    public Evaluacion(String Nombre, String Apellidos, Materia materia, int NumCarnet, int Nota) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.materia = this.materia.Estructuras_de_Datos;
        this.NumCarnet = NumCarnet;
        this.Nota = Nota;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public int getNumCarnet() {
        return NumCarnet;
    }

    public void setNumCarnet(int NumCarnet) {
        this.NumCarnet = NumCarnet;
    }

    public int getNota() {
        return Nota;
    }

    public void setNota(int Nota) {
        this.Nota = Nota;
    }

    @Override
    public String toString() {
        return "Evaluacion{" + "Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", materia=" + materia + ", NumCarnet=" + NumCarnet + ", Nota=" + Nota + '}';
    }
    
}
