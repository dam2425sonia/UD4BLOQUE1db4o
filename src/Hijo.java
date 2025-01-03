public class Hijo {
    
    String nombre;
    int edad;
    
    Hijo(String nombre, int ed) {
        this.nombre=nombre;
        edad=ed;
    }
    
    void visualHijo() {
        System.out.println("\tNOMBRE: " +nombre);
        System.out.println("\tEDAD: " +edad);
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }  

}