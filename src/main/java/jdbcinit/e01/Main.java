package jdbcinit.e01;

import jdbcinit.e01.infrastructure.controller.OficinaController;
import jdbcinit.e01.infrastructure.persistence.ConnectionBBDD;
import jdbcinit.e01.infrastructure.persistence.OfficeService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

@SuppressWarnings("java:S106")
public class Main {

    private static OficinaController oficinaController;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        try (var connectionBbdd = new ConnectionBBDD()) {
            oficinaController = new OficinaController(new OfficeService(connectionBbdd.getConnection()));
            mainLoop();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mainLoop() {
        boolean chooseNext;

        do {
            String command = chooseOption();
            chooseNext = execute(command);
        } while (chooseNext);
    }

    private static String chooseOption() {
        System.out.print("""
                -------------- Selection Menu --------------
                1.findAll
                2.findById
                3.create
                4.update
                5.updateFieldById
                6.delete
                7.exit
                Insert your option:\s"""
        );
        return scanner.nextLine();
    }

    private static boolean execute(String command) {
        switch (command) {
            case "1" -> oficinaController.findAll();
            case "2" -> oficinaController.findById();
            case "3" -> oficinaController.create();
            case "4" -> oficinaController.update();
//            case "5" -> oficinaController.updateFieldById();
            case "6" -> oficinaController.delete();
            case "7" -> {
                return false;
            }
            default -> System.out.println("Invalid command");
        }
        return true;
    }
}
