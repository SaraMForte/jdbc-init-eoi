package jdbcinit.e01;

import jdbcinit.e01.controller.OficinaController;
import jdbcinit.e01.repository.OficinaRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        try (var connectionBbdd = new ConnectionBBDD()) {
            OficinaController oficinaController =
                    new OficinaController(new OficinaRepository(connectionBbdd.getConnection()));

            while (run) {
                System.out.print("""
                        -------------- Selection Menu --------------
                        1.findAll
                        2.findById
                        3.create
                        4.update
                        5.delete
                        6.exit
                        Insert your option:\s""");
                String command = scanner.nextLine();
                switch (command) {
                    case "1" -> oficinaController.findAll();
                    case "2" -> oficinaController.findById();
                    case "3" -> oficinaController.create();
                    case "4" -> oficinaController.update();
                    case "5" -> oficinaController.delete();
                    case "6" -> run = false;
                    default -> System.out.println("Invalid command");
                }
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
