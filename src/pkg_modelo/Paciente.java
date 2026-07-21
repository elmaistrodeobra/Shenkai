/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg_modelo;

/**
 *
 * @author uli08
 */
public class Paciente extends Persona{
    protected String alergias;
    protected String cita;
    protected String tipoSangre;
    protected String diagnostico;
    
    public Paciente (int i, String n,String a, int e, int t){
        super (i,n,a,e,t);// Invocando al constructor de la super clase con "super"
    }
    @Override
    public String mostrarPerfil (){
        return "Paciente " + nombre + "" + "Cita: " + cita + "" + "Diagnóstico: " + diagnostico+ "";
    }
}
