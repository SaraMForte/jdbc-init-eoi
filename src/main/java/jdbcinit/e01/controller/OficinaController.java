package jdbcinit.e01.controller;

import jdbcinit.e01.repository.OficinaRepository;
import jdbcinit.e01.repository.model.Oficina;

import java.util.Optional;
import java.util.Scanner;

@SuppressWarnings("java:S106")
public class OficinaController {

    OficinaRepository oficinaRepository;
    Scanner scanner = new Scanner(System.in);

    public OficinaController(OficinaRepository oficinaRepository) {
        this.oficinaRepository = oficinaRepository;
    }

    public void findAll() {
        System.out.println("-------------- All Oficinas --------------");
        try {
            oficinaRepository.findAll()
                    .forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error to find all oficina");
        }
    }

    public void findById() {
        System.out.println("-------------- Oficina --------------");
        String id = askToUser("Enter code of oficina: ");
        try {
            Optional<Oficina> oficina = oficinaRepository.findById(id);
            if (oficina.isPresent()) {
                System.out.println(oficina.get());
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
            oficinaRepository.create(askOficinaToUser());
        } catch (Exception e) {
            System.out.println("Error to create oficina");
        }
    }

    public void update() {
        System.out.println("-------------- Update Oficinas --------------");
        try {
            oficinaRepository.updateById(askOficinaToUser());
        } catch (Exception e) {
            System.out.println("Error to update oficina");
        }
    }

    public Oficina askOficinaToUser() {
        Oficina oficina = new Oficina();
        System.out.println("-".repeat(10) + " Insert the data of oficina " + "-".repeat(10));
        oficina.setCodigoOficina(askToUser("Codigo Oficina: "));
        oficina.setCiudad(askToUser("Ciudad: "));
        oficina.setPais(askToUser("Pais: "));
        oficina.setRegion(askToUser("Region: "));
        oficina.setCodigoPostal(askToUser("CodigoPostal: "));
        oficina.setTelefono(askToUser("Telefono: "));
        oficina.setLineaDireccion1(askToUser("LineaDireccion1: "));
        oficina.setLineaDireccion2(askToUser("LineaDireccion2: "));
        return oficina;
    }

    public void delete() {
        System.out.println("-------------- Delete Oficinas --------------");
        try {
            oficinaRepository.deleteById(askToUser("Enter code of oficina"));
        } catch (Exception e) {
            System.out.println("Error to delete oficina");
        }
    }

    public String askToUser(String text) {
        System.out.println(text);
        return scanner.nextLine();
    }

}
