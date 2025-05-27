package jdbcinit.c01;

import java.io.IOException;
import java.sql.SQLException;

@SuppressWarnings("java:S106")
public class FirstStep {

    public static void main(String[] args) {
        // Instancia de Conexión
        try (ConnectionBBDD connectionBBDD = new ConnectionBBDD()) {
            var dbInfoPrinter = new DbInfoPrinter(connectionBBDD.getConnection());
            dbInfoPrinter.printClientsWithSellerAndOffice7();
            dbInfoPrinter.printEmployeeAndBoss8();
            dbInfoPrinter.printEmployeeWithBossAndBossOfBoss9();
            dbInfoPrinter.printLateDeliveryClients10();
            dbInfoPrinter.printLateDeliveryClients11();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}