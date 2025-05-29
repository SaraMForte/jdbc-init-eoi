package jdbcinit.e01.infrastructure.controller;

import jdbcinit.e01.application.exception.DataAccessException;
import jdbcinit.e01.application.OfficeService;
import jdbcinit.e01.domain.Office;

import java.util.Optional;
import java.util.Scanner;

@SuppressWarnings("java:S106")
public class OficinaController {

    OfficeService officeService;
    Scanner scanner = new Scanner(System.in);

    public OficinaController(OfficeService officeService) {
        this.officeService = officeService;
    }

    public void findAll() {
        System.out.println("-------------- All Oficinas --------------");
        try {
            officeService.findAll()
                    .forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error to find all oficina");
        }
    }

    public void findById() {
        System.out.println("-------------- Oficina --------------");
        String id = askToUser("Enter code of oficina: ");
        try {
            Optional<Office> office = officeService.findById(id);
            if (office.isPresent()) {
                System.out.println(office.get());
            } else {
                System.out.println("The id " + id + " does not exist in oficina.");
            }
        } catch (Exception e) {
            System.out.println("Error to find by id code oficina");
        }
    }

    public void create() {
        System.out.println("-------------- Create Oficina --------------");
        try {
            officeService.create(askOficinaToUser());
            System.out.println("Oficina created successfully.");
        } catch (Exception e) {
            System.out.println("Error to create oficina");
        }
    }

    public void update() {
        System.out.println("-------------- Update Oficinas --------------");
        try {
            Office office = officeService.updateById(askOficinaToUser());
            System.out.println("Oficina updated successfully: \n" + office);
        } catch (Exception e) {
            System.out.println("Error to update oficina");
        }
    }

//  TODO - Complete this updateFieldById
    public void updateFieldById() {
        System.out.println("-------------- Update Oficina Field --------------");
        try {
            String id = askToUser("Enter id of oficina: ");
            String field = askToUser("Enter field of oficina: ");
            String value = askToUser("Enter value for field " + field + ": ");

            Office office = officeService.updateFieldById(id, field, value);
            System.out.println("Oficina updated successfully: \n" + office);

        } catch (DataAccessException e) {
            System.out.println("Error to update oficina field");
        }
    }

    private Office askOficinaToUser() {
        System.out.println("-".repeat(10) + " Insert the data of oficina " + "-".repeat(10));
        Office office = new Office();
        office.setOfficeCode(askToUser("Codigo Oficina: "));
        office.setCity(askToUser("Ciudad: "));
        office.setCountry(askToUser("Pais: "));
        office.setRegion(askToUser("Region: "));
        office.setPostalCode(askToUser("CodigoPostal: "));
        office.setPhone(askToUser("Telefono: "));
        office.setAddressLine1(askToUser("LineaDireccion1: "));
        office.setAddressLine2(askToUser("LineaDireccion2: "));
        return office;
    }

    public void delete() {
        System.out.println("-------------- Delete Oficinas --------------");
        try {
            officeService.deleteById(askToUser("Enter code of oficina"));
        } catch (Exception e) {
            System.out.println("Error to delete oficina");
        }
    }

    private String askToUser(String text) {
        System.out.println(text);
        return scanner.nextLine();
    }

}
