package jdbcinit.c02;

import jdbcinit.c02.model.Empleado;
import jdbcinit.c02.model.Oficina;
import jdbcinit.c02.repositories.EmpleadoRepository;
import jdbcinit.c02.repositories.OficinaRepository;

import java.util.Optional;

@SuppressWarnings("java:S106")
public class Main {
    public static void main(String[] args) {
        try (ConnectionBBDD connectionBBDD = new ConnectionBBDD()) {

            EmpleadoRepository empleadoRepository = new EmpleadoRepository(connectionBBDD.getConnection());

            System.out.println("-".repeat(10) + "Lista de empleados" + "-".repeat(10));
            empleadoRepository.findAll().forEach(System.out::println);

            Optional<Empleado> empleadoId1 = empleadoRepository.findById(1);
            if (empleadoId1.isPresent()) {
                System.out.println("Only one employee: " + empleadoId1.get());
            } else {
                System.out.println("Only one employee: Not found");
            }

            OficinaRepository oficinaRepository = new OficinaRepository(connectionBBDD.getConnection());

            System.out.println("-".repeat(10) + "Lista de oficinas" + "-".repeat(10));
            oficinaRepository.findAll().forEach(System.out::println);

            Optional<Oficina> OficinaTWN = oficinaRepository.findById("TWN01");
            if (OficinaTWN.isPresent()) {
                System.out.println("Only one oficine: " + OficinaTWN.get());
            } else {
                System.out.println("Only one oficine: Not found");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
