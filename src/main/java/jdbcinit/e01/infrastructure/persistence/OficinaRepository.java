package jdbcinit.e01.infrastructure.persistence;

import jdbcinit.e01.application.exception.DataAccessException;
import jdbcinit.e01.application.exception.DatabaseMetadataAccessException;
import jdbcinit.e01.application.exception.NotUpdatableResultSetException;
import jdbcinit.e01.application.repository.OfficeRepository;
import jdbcinit.e01.domain.Office;
import jdbcinit.e01.infrastructure.persistence.model.OficinaJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("java:S112")
public class OficinaRepository implements OfficeRepository {
    private final Connection conn;

    public OficinaRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Office> findAll() throws DataAccessException {
        final String sqlQuery = "SELECT * FROM oficina ORDER BY codigo_oficina";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sqlQuery)) {
            List<OficinaJDBC> oficinaJDBCS = new ArrayList<>();

            while (rs.next()) {
                oficinaJDBCS.add(extractOficinaFrom(rs));
            }

            return oficinaJDBCS.stream().map(OficinaJDBC::toOffice).toList();
        } catch (SQLException e) {
            throw new DataAccessException("Cant not List oficinas", e);
        }
    }

    @Override
    public Optional<Office> findById(String id) throws DataAccessException {
        final String sqlQuery = "SELECT * FROM oficina WHERE codigo_oficina = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                return Optional.empty();
            }

            return Optional.of(extractOficinaFrom(rs).toOffice());
        } catch (SQLException e) {
            throw new DataAccessException("Error to find empleado with id " + id, e);
        }
    }

    private OficinaJDBC extractOficinaFrom(ResultSet rs) throws SQLException {
        return new OficinaJDBC(rs.getString("codigo_oficina"), rs.getString("ciudad"), rs.getString("pais"), rs.getString("region"), rs.getString("codigo_postal"), rs.getString("telefono"), rs.getString("linea_direccion1"), rs.getString("linea_direccion2"));
    }

    @Override
    public void create(Office office) throws DataAccessException {
        final String sqlQuery = """
                INSERT INTO oficina
                    (codigo_oficina, ciudad, pais, region, codigo_postal, telefono, linea_direccion1, linea_direccion2)
                VALUES
                    (?, ?, ?, ?, ?, ?, ?, ?);
                """;

        try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setString(1, office.officeCode());
            stmt.setString(2, office.city());
            stmt.setString(3, office.country());
            stmt.setString(4, office.region());
            stmt.setString(5, office.postalCode());
            stmt.setString(6, office.phone());
            stmt.setString(7, office.addressLine1());
            stmt.setString(8, office.addressLine2());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("Error to create oficina", e);
        }
    }

    @Override
    public Office updateById(Office office) throws DataAccessException {
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
            stmt.setString(1, office.city());
            stmt.setString(2, office.country());
            stmt.setString(3, office.region());
            stmt.setString(4, office.postalCode());
            stmt.setString(5, office.phone());
            stmt.setString(6, office.addressLine1());
            stmt.setString(7, office.addressLine2());
            stmt.setString(8, office.officeCode());
            stmt.executeUpdate();

            return office;
        } catch (SQLException e) {
            throw new DataAccessException("Error to update oficina", e);
        }
    }

    public Office updateFieldById(String id, String field, String value) throws DataAccessException {
        final String sqlQuery = "SELECT * FROM oficina WHERE codigo_oficina = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sqlQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            if (!isUpdatable()) {
                throw new NotUpdatableResultSetException("Cant not get metadata of database");
            }

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            rs.absolute(1);
            rs.updateString(field, value);
            rs.updateRow();

            return findById(id).orElseThrow(() -> new Exception("Cant not find office with id " + id));
        } catch (Exception e) {
            throw new DataAccessException("Error to update oficina by field: " + e.getMessage(), e);
        }
    }

    private boolean isUpdatable() throws DatabaseMetadataAccessException {
        try {
            DatabaseMetaData metaData = conn.getMetaData();
            return metaData.supportsResultSetConcurrency(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE
            );
        } catch (SQLException e) {
            throw new DatabaseMetadataAccessException("Unable to retrieve database metadata to determine if the ResultSet is updatable.", e);
        }
    }

    @Override
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
