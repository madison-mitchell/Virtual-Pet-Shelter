package shelter;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class VirtualPetShelter {
    ConcurrentHashMap<String, VirtualPet> pets = new ConcurrentHashMap<>();

    public Collection<VirtualPet> getAllPets() {
        return pets.values();
    }

    public void add(VirtualPet petToAdd) {
        pets.put(petToAdd.getName(), petToAdd);
    }

    public VirtualPet findPet(String petName) {
        return pets.get(petName);
    }

    public void adopt(VirtualPet petToRemove) {
        pets.remove(petToRemove.getName(), petToRemove);
    }

    public void showPetMap() {
        System.out.println("" +
                "|Health\t\t|Hunger\t\t|Thirst\t\t|Waste\t\t|Happy\t\t|Sleepy\t\t|Social\t\t|Activity\t\t|Name\n" +
                "------------|-----------|-----------|-----------|-----------|-----------|-----------|---------------|----------------");
        for (VirtualPet pet : getAllPets()) {
            System.out.println("| " + pet.healthStatus() + "\t|" + pet.hungerStatus() + "\t|" + pet.thirstStatus() + "\t|" + pet.wasteStatus() + "\t|" + pet.happinessStatus() + "\t|" + pet.sleepinessStatus() + "\t|" + pet.lonelinessStatus() + "\t|" + pet.activityStatus() + "\t\t|" + pet.getName());
        }
    }

    public void tick() {
        for (VirtualPet pet : pets.values()) {
            pet.tick();
        }
    }

    public void feedAll() {
        for (VirtualPet pet : pets.values()) {
            pet.feed();
        }
    }

    public void waterAll() {
        for (VirtualPet pet : pets.values()) {
            pet.water();
        }
    }

    public void playAll() {
        for (VirtualPet pet : pets.values()) {
            pet.play();
        }
    }

    public void cuddleAll() {
        for (VirtualPet pet : pets.values()) {
            pet.cuddle();
        }
    }

    public void vetAll() {
        for (VirtualPet pet : pets.values()) {
            pet.goToVet();
        }
    }

    public void pottyAll() {
        for (VirtualPet pet : pets.values()) {
            pet.goPotty();
        }
    }

    public void sleepAll() {
        for (VirtualPet pet : pets.values()) {
            pet.sleep();
        }
    }

    public void unAlive() {
        for (VirtualPet pet : pets.values()) {
            if (!pet.isPetAlive()) {
                pets.remove(pet.getName(), pet);
                System.out.println("" +
                        "                                                     ...\n" +
                        "                                                   ;::::;\n" +
                        "                                                 ;::::; :;\n" +
                        "                                               ;:::::'   :;\n" +
                        "                                              ;:::::;     ;.\n" +
                        "                                             ,:::::'       ;           OOO\\\n" +
                        "                                             ::::::;       ;          OOOOO\\\n" +
                        "                                             ;:::::;       ;         OOOOOOOO\n" +
                        "                                            ,;::::::;     ;'         / OOOOOOO\n" +
                        "                                          ;:::::::::`. ,,,;.        /  / DOOOOOO\n" +
                        "                                        .';:::::::::::::::::;,     /  /     DOOOO\n" +
                        "                                       ,::::::;::::::;;;;::::;,   /  /        DOOO\n" +
                        "                                      ;`::::::`'::::::;;;::::: ,#/  /          DOOO\n" +
                        "                                      :`:::::::`;::::::;;::: ;::#  /            DOOO\n" +
                        "                                      ::`:::::::`;:::::::: ;::::# /              DOO\n" +
                        "                                      `:`:::::::`;:::::: ;::::::#/               DOO\n" +
                        "                                       :::`:::::::`;; ;:::::::::##                OO\n" +
                        "                                       ::::`:::::::`;::::::::;:::#                OO\n" +
                        "                                       `:::::`::::::::::::;'`:;::#                O\n" +
                        "                                        `:::::`::::::::;' /  / `:#\n" +
                        "                                         ::::::`:::::;'  /  /   `#");
                System.out.println("\t\t\t\t\t\t\t >>>>>>>>>> OH NO! " + pet.getName().toUpperCase() + " HAS DIED! <<<<<<<<<<<<<<");

            }
        }
    }

}
