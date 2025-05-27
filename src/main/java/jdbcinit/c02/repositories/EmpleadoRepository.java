package jdbcinit.c02.repositories;

import jdbcinit.c02.model.Empleado;
import jdbcinit.c02.model.EmpleadoBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("java:S112")
public class EmpleadoRepository {

    private Connection conn;

    public EmpleadoRepository(Connection conn) {
        this.conn = conn;
    }

    public List<Empleado> findAll() throws Exception {
        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM empleado");
        ) {
            List<Empleado> empleados = new ArrayList<>();

            while (rs.next()) {
                empleados.add(extractEmpleadoFrom(rs));
            }
            return empleados;
        } catch (SQLException e) {
            throw new Exception("Cant not List all employees", e);
        }
    }

    public Optional<Empleado> findById(int id) throws Exception {
        try (
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM empleado WHERE codigo_empleado = ?")
        ) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                return Optional.empty();
            }

            return Optional.of(extractEmpleadoFrom(rs));
        } catch (SQLException e) {
            throw new Exception("Error to find empleado with id " + id, e);
        }
    }

    public Empleado extractEmpleadoFrom(ResultSet rs) throws SQLException {
        return new EmpleadoBuilder()
                .withCodigoEmpleado(rs.getInt("codigo_empleado"))
                .withNombre(rs.getString("nombre"))
                .withApellido1(rs.getString("apellido1"))
                .withApellido2(rs.getString("apellido2"))
                .withEmail(rs.getString("email"))
                .withCodigoOficina(rs.getString("codigo_oficina"))
                .withCodigoJefe(rs.getInt("codigo_jefe"))
                .withPuesto(rs.getString("puesto"))
                .build();
    }
}
