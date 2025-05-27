package jdbcinit.c02.repositories;

import jdbcinit.c02.model.Oficina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("java:S112")
public class OficinaRepository {
    private Connection conn;

    public OficinaRepository(Connection conn) {
        this.conn = conn;
    }

    public List<Oficina> findAll() throws Exception {
        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM oficina");
        ) {
            List<Oficina> oficinas = new ArrayList<>();

            while (rs.next()) {
                oficinas.add(extractOficinaFrom(rs));
            }
            return oficinas;
        } catch (SQLException e) {
            throw new Exception("Cant not List oficinas", e);
        }
    }

    public Optional<Oficina> findById(String id) throws Exception {
        try (
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM oficina WHERE codigo_oficina = ?")
        ) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                return Optional.empty();
            }

            return Optional.of(extractOficinaFrom(rs));
        } catch (SQLException e) {
            throw new Exception("Error to find empleado with id " + id, e);
        }
    }

    public Oficina extractOficinaFrom(ResultSet rs) throws SQLException {
        Oficina oficina = new Oficina();
        oficina.setCodigoOficina(rs.getString("codigo_oficina"));
        oficina.setCiudad(rs.getString("ciudad"));
        oficina.setPais(rs.getString("pais"));
        oficina.setRegion(rs.getString("region"));
        oficina.setCodigoPostal(rs.getString("codigo_postal"));
        oficina.setTelefono(rs.getString("telefono"));
        oficina.setLineaDireccion1(rs.getString("linea_direccion1"));
        oficina.setLineaDireccion2(rs.getString("linea_direccion2"));
        return oficina;
    }
}
