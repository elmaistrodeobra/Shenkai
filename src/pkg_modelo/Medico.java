package pkg_modelo;

public class Medico extends Persona {
    private String cedula;
    private String especialidad;
    private String horario;

    // Constructor completo con ID
    public Medico(int id, String nombre, String apellido, int edad, String telefono, String cedula, String especialidad, String horario) {
        super(id, nombre, apellido, edad, telefono);
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.horario = horario;
    }

    // Constructor sin ID (para nuevos registros)
    public Medico(String nombre, String apellido, int edad, String telefono, String cedula, String especialidad, String horario) {
        super(0, nombre, apellido, edad, telefono);
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.horario = horario;
    }

    public String getCedula() { 
        return cedula; 
    }
    
    public void setCedula(String cedula) { 
        this.cedula = cedula; 
    }

    public String getEspecialidad() { 
        return especialidad; 
    }
    
    public void setEspecialidad(String especialidad) { 
        this.especialidad = especialidad; 
    }

    public String getHorario() { 
        return horario; 
    }
    
    public void setHorario(String horario) { 
        this.horario = horario; 
    }

    @Override
    public String mostrarPerfil() {
        return "Dr(a). " + getNombre() + " " + getApellido() + " | Esp: " + especialidad + " | Cédula: " + cedula;
    }
}