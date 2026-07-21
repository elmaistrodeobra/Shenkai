package pkg_modelo;

public class Cita {
    private int idCita;
    private Paciente paciente;
    private Medico medico;
    private String fecha;
    private String hora;
    private String diagnostico;

    // Constructor completo
    public Cita(int idCita, Paciente paciente, Medico medico, String fecha, String hora, String diagnostico) {
        this.idCita = idCita;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.hora = hora;
        this.diagnostico = diagnostico;
    }

    // Constructor sin ID (para nuevas citas)
    public Cita(Paciente paciente, Medico medico, String fecha, String hora, String diagnostico) {
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.hora = hora;
        this.diagnostico = diagnostico;
    }

    // Getters y Setters corregidos
    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}