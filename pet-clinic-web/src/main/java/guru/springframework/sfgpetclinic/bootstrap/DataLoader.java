package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        // Pet Types
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        // Owners
        Owner owner1 = new Owner();
        owner1.setFirstName("Vladimir");
        owner1.setLastName("Ulyanov");
        owner1.setAddress("144 Green");
        owner1.setCity("Pensacola");
        owner1.setTelephone("+12838444392");

        Pet vladimirsPet = new Pet();
        vladimirsPet.setName("Quake");
        vladimirsPet.setPetType(savedDogPetType);
        vladimirsPet.setOwner(owner1);
        vladimirsPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(vladimirsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ekaterina");
        owner2.setLastName("Romanova");
        owner2.setAddress("Lenina");
        owner2.setCity("Chelyabinsk");
        owner2.setTelephone("+79113453453");
        ownerService.save(owner2);

        Pet katesPet = new Pet();
        katesPet.setName("Rainbow");
        katesPet.setPetType(savedCatPetType);
        katesPet.setOwner(owner2);
        katesPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(katesPet);

        System.out.println("Loaded Owners....");


        // Vets
        Vet vet1 = new Vet();
        vet1.setFirstName("Freddie");
        vet1.setLastName("Mercury");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Serious");
        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
