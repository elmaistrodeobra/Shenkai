package pkg_modelo;

/**
 * @author uli08
 */
public abstract class Persona {
    protected int id;
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String telefono; // Cambiado a String para alinearlo con la base de datos

    public Persona(int i, String n, String a, int e, String t) {
        this.id = i;
        this.nombre = n;
        this.apellido = a;
        this.edad = e;
        this.telefono = t;
    }

    public abstract String mostrarPerfil();

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }
}