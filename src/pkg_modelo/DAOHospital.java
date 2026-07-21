package pkg_modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author uli08
 */
public class DAOHospital {
    
    private final String URL = "jdbc:mysql://localhost:3306/hospital";
    private final String USER = "root";
    private final String PASS = "root";

    // MÉTODOS DEL INTEGRANTE 2 - MÓDULO MÉDICOS

    public boolean registrarMedico(Medico medico) {
        String sql = "INSERT INTO Medico (nombre, apellido, telefono, cedula, especialidad, horario) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, medico.getNombre());
            ps.setString(2, medico.getApellido());
            ps.setString(3, medico.getTelefono());
            ps.setString(4, medico.getCedula());
            ps.setString(5, medico.getEspecialidad());
            ps.setString(6, medico.getHorario());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al registrar médico: " + e.getMessage());
            return false;
        }
    }

    public List<Medico> consultarMedicos() {
        List<Medico> lista = new ArrayList<>();
        String sql = "SELECT * FROM Medico";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // Si tu tabla Medico no tiene columna 'edad', se envía 0 como valor por defecto
                int edad = 0;
                try {
                    edad = rs.getInt("edad");
                } catch (SQLException e) {
                    // Si no existe la columna en la BD, continúa con 0
                }

                Medico m = new Medico(
                    rs.getInt("id_medico"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    edad,
                    rs.getString("telefono"),
                    rs.getString("cedula"),
                    rs.getString("especialidad"),
                    rs.getString("horario")
                );
                lista.add(m);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar médicos: " + e.getMessage());
        }
        return lista;
    }

    public boolean eliminarMedico(int idMedico) {
        String sql = "DELETE FROM Medico WHERE id_medico = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idMedico);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar médico: " + e.getMessage());
            return false;
        }
    }

    // MÉTODOS DEL INTEGRANTE 3 - MÓDULO CITAS (Tu parte)

    public boolean verificarHorarioOcupado(int id_medico, String fecha, String hora) throws SQLException {
        boolean estaOcupado = false;
        String sql = "SELECT * FROM CitaMedica WHERE id_medico = ? AND fecha = ? AND hora = ?";
        
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, id_medico);
            ps.setString(2, fecha);
            ps.setString(3, hora);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                estaOcupado = true;
            }
        }
        return estaOcupado;
    }
    
    public void insertarCita(Cita cita) throws SQLException {
        String sql = "INSERT INTO CitaMedica (id_paciente, id_medico, fecha, hora, diagnostico) "
                + "VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, cita.getPaciente().getId()); 
            ps.setInt(2, cita.getMedico().getId());   
            ps.setString(3, cita.getFecha());
            ps.setString(4, cita.getHora());
            ps.setString(5, cita.getDiagnostico());
            
            ps.executeUpdate();
        }
    }
    
    public ArrayList<Cita> obtenerTodasLasCitas() throws SQLException {
        ArrayList<Cita> lista = new ArrayList<>();
        String sql = "SELECT * FROM CitaMedica";
        
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                int id_cita = rs.getInt("id_cita");
                String fecha = rs.getString("fecha");
                String hora = rs.getString("hora");
                String diagnostico = rs.getString("diagnostico");
                
                lista.add(new Cita(id_cita, null, null, fecha, hora, diagnostico));
            }
        }
        return lista;
    }
}