package jdbcinit.e01.persistence;

import jdbcinit.e01.persistence.model.Oficina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("java:S112")
public class OficinaRepository {
    private final Connection conn;

    public OficinaRepository(Connection conn) {
        this.conn = conn;
    }

    public List<Oficina> findAll() throws DataAccessException {
        final String sqlQuery = "SELECT * FROM oficina ORDER BY codigo_oficina";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sqlQuery)) {
            List<Oficina> oficinas = new ArrayList<>();

            while (rs.next()) {
                oficinas.add(extractOficinaFrom(rs));
            }
            return oficinas;
        } catch (SQLException e) {
            throw new DataAccessException("Cant not List oficinas", e);
        }
    }

    public Optional<Oficina> findById(String id) throws DataAccessException {
        final String sqlQuery = "SELECT * FROM oficina WHERE codigo_oficina = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                return Optional.empty();
            }

            return Optional.of(extractOficinaFrom(rs));
        } catch (SQLException e) {
            throw new DataAccessException("Error to find empleado with id " + id, e);
        }
    }

    private Oficina extractOficinaFrom(ResultSet rs) throws SQLException {
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

    public void create(Oficina oficina) throws DataAccessException {
        final String sqlQuery = """
                INSERT INTO oficina
                    (codigo_oficina, ciudad, pais, region, codigo_postal, telefono, linea_direccion1, linea_direccion2)
                VALUES
                    (?, ?, ?, ?, ?, ?, ?, ?);
                """;

        try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setString(1, oficina.codigoOficina());
            stmt.setString(2, oficina.ciudad());
            stmt.setString(3, oficina.pais());
            stmt.setString(4, oficina.region());
            stmt.setString(5, oficina.codigoPostal());
            stmt.setString(6, oficina.telefono());
            stmt.setString(7, oficina.lineaDireccion1());
            stmt.setString(8, oficina.lineaDireccion2());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("Error to create oficina", e);
        }
    }

    public Oficina updateById(Oficina oficina) throws DataAccessException {
        final String sqlQuery = """
                UPDATE oficina
                SET
                    ciudad = ?,
                    pais = ?,
                    region = ?,
                    codigo_postal = ?,
                    telefono = ?,
                    linea_direccion1 = ?,
                    linea_direccion2 = ?
                WHERE
                    codigo_oficina = ?
                """;

        try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setString(1, oficina.ciudad());
            stmt.setString(2, oficina.pais());
            stmt.setString(3, oficina.region());
            stmt.setString(4, oficina.codigoPostal());
            stmt.setString(5, oficina.telefono());
            stmt.setString(6, oficina.lineaDireccion1());
            stmt.setString(7, oficina.lineaDireccion2());
            stmt.setString(8, oficina.codigoOficina());
            stmt.executeUpdate();

            return oficina;
        } catch (SQLException e) {
            throw new DataAccessException("Error to update oficina", e);
        }
    }

    public void deleteById(String id) throws DataAccessException {
        final String sqlQuery = """
                DELETE FROM oficina
                WHERE
                    codigo_oficina = ?
                """;

        try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("Error to delete oficina", e);
        }
    }
}
