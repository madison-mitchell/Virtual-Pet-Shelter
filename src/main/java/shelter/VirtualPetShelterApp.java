package shelter;

import java.util.Locale;
import java.util.Scanner;

public class VirtualPetShelterApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userChoice = "";
        String petChoice = "";

        String inputPetName = "";
        String inputPetSize = "";
        String inputPetColor = "";
        String inputPetBreed = "";

        VirtualPet petOne;
        VirtualPet petTwo;
        VirtualPet petThree;
        VirtualPet petFour;
        VirtualPet petFive;

        VirtualPetShelter myShelter = new VirtualPetShelter();
        petOne = new VirtualPet("Ghost", "Extra large", "albino", "Direwolf", 121, 112, 99, 50, 100, 0, 150, 80);
        petTwo = new VirtualPet("Lady", "Large", "grey", "Direwolf", 93, 101, 113, 50, 70, 20, 40, 70);
        petThree = new VirtualPet("Nymeria", "Large", "grey", "Direwolf", 112, 93, 94, 30, 80, 15, 130, 30);
        petFour = new VirtualPet("Summer", "Medium", "silvery grey", "Direwolf", 102, 84, 92, 10, 75, 25, 90, 40);
        petFive = new VirtualPet("Grey Wind", "Large", "smoke grey", "Direwolf", 126, 103, 108, 15, 85, 5, 5, 20);
        myShelter.add(petOne);
        myShelter.add(petTwo);
        myShelter.add(petThree);
        myShelter.add(petFour);
        myShelter.add(petFive);


        System.out.println("\n\nThank you for volunteering at Big Al\'s Virtual Pet Shelter and Delicatessen!");
        System.out.println("" +
                "                                  +&-\n" +
                "                                                           _.-^-._    .--.\n" +
                "                                                        .-'   _   '-. |__|\n" +
                "                                                       /     |_|     \\|  |\n" +
                "                                                      /               \\  |\n" +
                "                                                     /|     _____     |\\ |\n" +
                "                                                      |    |==|==|    |  |\n" +
                "                                  |---|---|---|---|---|    |--|--|    |  |\n" +
                "                                  |---|---|---|---|---|    |==|==|    |  |\n\n");
        System.out.println("Let's get started!");

        do {
            System.out.println("\n_____________________________________________________________________________________________________________________");
            System.out.println("\t\t\t\t\t\t\t\tThis is the status of the pets in the shelter:");
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            myShelter.showPetMap();
            System.out.println("____________________________________________________________________________________________________________________\n");

            System.out.println("What would you like to do next?");
            System.out.println("1. Feed the pets\n" +
                    "2. Water the pets\n" +
                    "3. Play with a pet\n" +
                    "4. Adopt a pet\n" +
                    "5. Admit a pet\n" +
                    "6. Take a pet to the vet\n" +
                    "7. Cuddle a pet\n" +
                    "8. Let the pets out to go potty\n" +
                    "9. Lights out! Pet bed time\n" +
                    "10. Quit");
            userChoice = input.nextLine();
            System.out.println("");

            //Feed All Pets
            if (userChoice.equals("1")) {
                myShelter.feedAll();
                System.out.println("You've fed the pets! Their bellies are happy!");
            }

            //Water All Pets
            if (userChoice.equals("2")) {
                myShelter.waterAll();
                System.out.println("You've watered the pets! Feeling hydrated!");
            }

            //Play with Pets
            if (userChoice.equals("3")) {
                System.out.println("Ok, so you\'d like to play with a pet. Please choose one by typing in the pet\'s name or type \"all\": \n");
                for (VirtualPet pet : myShelter.getAllPets()) {
                    System.out.println(" >>> \"" + pet.getName() + "\" is a " + pet.getDescription().toLowerCase(Locale.ROOT) + " who is currently " + pet.activityStatus().toLowerCase().trim() + " and loves to play.");
                }
                petChoice = input.nextLine();
                System.out.println("");

                if (petChoice.equals("all")) {
                    myShelter.playAll();
                    System.out.println("Your pets love playing with you!");
                } else if (petChoice.equals(petChoice)) {
                    myShelter.pets.get(petChoice).play();
                    System.out.println(petChoice + "'s tails wagging as they chase the frisbee.");
                }
            }

            //Adopt a Pet
            if (userChoice.equals("4")) {
                System.out.println("Enter the name of the pet you wish to adopt.");
                String petToAdoptName = input.nextLine();
                VirtualPet petToAdopt = myShelter.findPet(petToAdoptName);
                myShelter.adopt(petToAdopt);

                System.out.println("");
                System.out.println("You've adopted " + petToAdoptName + "!");
            }

            //Admit a Pet
            if (userChoice.equals("5")) {
                System.out.println("Please enter your pet\'s name: ");
                inputPetName = input.nextLine();
                System.out.println("Enter " + inputPetName + "\'s description in the following order, pressing \"Enter\" after each requirement: " +
                        "\nSize" +
                        "\nColor" +
                        "\nBreed");
                inputPetSize = input.nextLine();
                inputPetColor = input.nextLine();
                inputPetBreed = input.nextLine();
                VirtualPet newPet = new VirtualPet(inputPetName, inputPetSize, inputPetColor, inputPetBreed, 100, 100, 100, 0, 100, 0, 0, 25);
                myShelter.add(newPet);
            }

            // Take pet to vet
            if (userChoice.equals("6")) {
                System.out.println("Which pet needs a vet visit? Please choose one by typing in the pet\'s name or type \"all\": \n");
                for (VirtualPet pet : myShelter.getAllPets()) {
                    System.out.println(" >>> \"" + pet.getName() + "\" is a " + pet.getDescription().toLowerCase(Locale.ROOT) + ".");
                }
                petChoice = input.nextLine();
                System.out.println("");

                if (petChoice.equals("all")) {
                    myShelter.vetAll();
                    System.out.println("Your pets are feeling much better!");
                } else if (petChoice.equals(petChoice)) {
                    myShelter.pets.get(petChoice).goToVet();
                    System.out.println(petChoice + " is feel much better!");
                }
            }

            // Cuddle pet
            if (userChoice.equals("7")) {
                System.out.println("Which pet needs some cuddles? Please choose one by typing in the pet\'s name or type \"all\": \n");
                for (VirtualPet pet : myShelter.getAllPets()) {
                    System.out.println(" >>> \"" + pet.getName() + "\" is a " + pet.getDescription().toLowerCase() + ".");
                }
                petChoice = input.nextLine();
                System.out.println("");

                if (petChoice.equals("all")) {
                    myShelter.cuddleAll();
                    System.out.println("Your pets loves snuggling with you!");
                } else if (petChoice.equals(petChoice)) {
                    myShelter.pets.get(petChoice).cuddle();
                    System.out.println(petChoice + " is snuggling closer to you, never wanting to leave your side!");
                }
            }

            // Let pet to outside to potty
            if (userChoice.equals("8")) {
                myShelter.pottyAll();
                System.out.println("Crisis averted! No messes in the shelter. Tanks are empty!");
            }

            // Pet bedtime
            if (userChoice.equals("9")) {
                System.out.println("Which pet needs some sleep? Please choose one by typing in the pet\'s name or type \"all\": \n");
                for (VirtualPet pet : myShelter.getAllPets()) {
                    System.out.println(" >>> \"" + pet.getName() + "\" is a " + pet.getDescription().toLowerCase(Locale.ROOT) + ".");
                }
                petChoice = input.nextLine();
                System.out.println("");

                if (petChoice.equals("all")) {
                    myShelter.sleepAll();
                    System.out.println("Your pets love playing with you!");
                } else if (petChoice.equals(petChoice)) {
                    myShelter.pets.get(petChoice).sleep();
                    System.out.println(petChoice + " is snuggling closer to you, never wanting to leave your side!");
                }
                myShelter.tick();
                System.out.println("\n\n");
            }
            myShelter.tick();
            myShelter.unAlive();
            if (myShelter.getAllPets().isEmpty() == true) {
                break;
            }
            System.out.println("\n\n\n");
        }
        while (!userChoice.equals("10") || myShelter.getAllPets().isEmpty());
        if (userChoice.equals("10")) {
            System.out.println("Thank you for volunteering!");
        } else if (myShelter.getAllPets().isEmpty()) {
            System.out.println("" +
                    "                               __ _  __ _ _ __ ___   ___      _____   _____ _ __ \n" +
                    "                              / _` |/ _` | '_ ` _ \\ / _ \\    / _ \\ \\ / / _ \\ '__|\n" +
                    "                             | (_| | (_| | | | | | |  __/   | (_) \\ V /  __/ |   \n" +
                    "                              \\__, |\\__,_|_| |_| |_|\\___|    \\___/ \\_/ \\___|_|   \n" +
                    "                               __/ |                                             \n" +
                    "                              |___/         \n");
            System.out.println("\t\t\t\t\t\t\t\t____________________________________________");
            System.out.println("\t\t\t\t\t\t\t\t| YOU HAVE BEEN ARRESTED FOR PET NEGLECT! |");
            System.out.println("\t\t\t\t\t\t\t\t____________________________________________");
            System.out.println("" +
                    "                                          ________________\n" +
                    "                                          \\      __      /         __\n" +
                    "                                           \\_____()_____/         /  )\n" +
                    "                                           '============`        /  /\n" +
                    "                                            #---\\  /---#        /  /\n" +
                    "                                           (# @\\| |/@  #)      /  /\n" +
                    "                                            \\   (_)   /       /  /\n" +
                    "                                            |\\ '---` /|      /  /\n" +
                    "                                    _______/ \\\\_____// \\____/ o_|\n" +
                    "                                   /       \\  /     \\  /   / o_|\n" +
                    "                                  / |           o|        / o_| \\\n" +
                    "                                 /  |  _____     |       / /   \\ \\\n" +
                    "                                /   |  |===|    o|      / /\\    \\ \\\n" +
                    "                               |    |   \\@/      |     / /  \\    \\ \\\n" +
                    "                               |    |___________o|__/----)   \\    \\/\n" +
                    "                               |    '              ||  --)    \\     |\n" +
                    "                               |___________________||  --)     \\    /\n" +
                    "                                    |           o|   ''''   |   \\__/\n" +
                    "                                    |            |          |\n");
        }
    }
}