/*
<<<<<<< HEAD
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg_modelo;

/**
 *
 * @author uli08
 */
public class Medico {
    
}
=======
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
 */
package pkg_modelo;

public class Medico extends Persona {
    private String cedula;
    private String especialidad;
    private String horario;

    public Medico(int id, String nombre, String apellido, String telefono, String cedula, String especialidad, String horario) {
        super(id, nombre, apellido, telefono);
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.horario = horario;
    }

    public Medico(String nombre, String apellido, String telefono, String cedula, String especialidad, String horario) {
        super(0, nombre, apellido, telefono);
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.horario = horario;
    }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    @Override
    public String getDetallesRol() {
        return "Dr(a). " + getNombre() + " " + getApellido() + " | Esp: " + especialidad + " | Cédula: " + cedula;
    }
}
>>>>>>> origin/master
