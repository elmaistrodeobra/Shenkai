/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;

public boolean registrarMedico(Medico medico) {
    String sql = "INSERT INTO Medico (nombre, apellido, telefono, cedula, especialidad, horario) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection con = obtenerConexion(); // Cambia "obtenerConexion()" por el método de conexión que tengan en su clase
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
    try (Connection con = obtenerConexion();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Medico m = new Medico(
                rs.getInt("id_medico"),
                rs.getString("nombre"),
                rs.getString("apellido"),
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
    try (Connection con = obtenerConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, idMedico);
        ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.err.println("Error al eliminar médico: " + e.getMessage());
        return false;
    }
}