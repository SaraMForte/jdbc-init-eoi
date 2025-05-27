package jdbcinit.c01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("java:S106")
public class DbInfoPrinter {
    private final Connection conn;

    public DbInfoPrinter(Connection conn) {
        this.conn = conn;
    }

    public void printClientsWithSellerAndOffice7() throws SQLException {
        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("""
                        SELECT DISTINCT
                            c.nombre_cliente,
                            e.nombre,
                            o.ciudad
                        FROM cliente c
                            INNER JOIN empleado e
                                ON c.codigo_empleado_rep_ventas = e.codigo_empleado
                            INNER JOIN oficina o
                                ON o.codigo_oficina = e.codigo_oficina
                        ORDER BY
                            e.nombre ASC, o.ciudad ASC;
                        """);
        ) {
            while (rs.next()) {
                System.out.println(rs.getString("nombre_cliente") + "; " + rs.getString("nombre") +
                                   "; " + rs.getString("ciudad"));
            }
            System.out.println("-".repeat(20));
        }
    }

    public void printEmployeeAndBoss8() throws SQLException {
        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("""
                        SELECT
                            e.nombre AS nombre_empleado,
                            j.nombre AS nombre_jefe
                        FROM empleado e
                            INNER JOIN empleado j
                                ON e.codigo_jefe = j.codigo_empleado
                        ORDER BY
                            e.nombre ASC;
                        """)
        ) {
            while (rs.next()) {
                System.out.println(rs.getString("nombre_empleado") + "; " + rs.getString("nombre_jefe"));
            }
            System.out.println("-".repeat(20));
        }
    }

    public void printEmployeeWithBossAndBossOfBoss9() throws SQLException {
        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("""
                        SELECT
                               e.nombre AS nombre_empleado,
                            j.nombre AS nombre_jefe,
                            jj.nombre AS nombre_del_jefe_del_jefe
                        FROM empleado e
                            INNER JOIN empleado j
                                ON e.codigo_jefe = j.codigo_empleado
                            INNER JOIN empleado jj
                                ON j.codigo_jefe = jj.codigo_empleado
                        ORDER BY
                            e.nombre ASC, j.nombre ASC
                        """);
        ) {
            while (rs.next()) {
                System.out.println(rs.getString("nombre_empleado") + "; " + rs.getString("nombre_jefe")
                                   + "; " + rs.getString("nombre_del_jefe_del_jefe"));
            }
            System.out.println("-".repeat(20));
        }
    }

    public void printLateDeliveryClients10() throws SQLException {
        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("""
                        SELECT
                            c.nombre_cliente
                        FROM pedido p
                            INNER JOIN cliente c
                                ON p.codigo_cliente = c.codigo_cliente
                        WHERE
                            p.estado = 'Entregado' AND
                            p.fecha_entrega > p.fecha_esperada
                        GROUP BY
                            c.nombre_cliente
                        ORDER BY
                            c.nombre_cliente
                        """)
        ) {
            while (rs.next()) {
                System.out.println(rs.getString("nombre_cliente"));
            }
            System.out.println("-".repeat(20));
        }
    }

    public void printLateDeliveryClients11() throws SQLException {
        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("""
                        SELECT DISTINCT
                            cl.codigo_cliente,
                            pr.gama
                        FROM cliente cl
                            LEFT JOIN pedido pe
                                ON cl.codigo_cliente = pe.codigo_cliente
                            INNER JOIN detalle_pedido de
                                ON pe.codigo_pedido = de.codigo_pedido
                            INNER JOIN producto pr
                                ON de.codigo_producto = pr.codigo_producto
                        ORDER BY
                            cl.codigo_cliente;
                        """)
        ) {
            while (rs.next()) {
                System.out.println(rs.getString("codigo_cliente") + "; " + rs.getString("gama"));
            }
            System.out.println("-".repeat(20));
        }
    }

    public void readClients() throws SQLException {
        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("""
                        SELECT 
                            codigo_cliente, 
                            nombre_cliente 
                        FROM cliente
                        """)

        ) {
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }
            System.out.println("-".repeat(20));
        }
    }
}
