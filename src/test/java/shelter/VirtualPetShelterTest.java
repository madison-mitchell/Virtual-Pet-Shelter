package shelter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetShelterTest {

    VirtualPetShelter underTest;
    VirtualPet petOne;
    VirtualPet petTwo;
    VirtualPet petThree;
    VirtualPet petFour;
    VirtualPet petFive;

    String inputPetOneName = "Cole";
    String inputPetOneSize = "small";
    String inputPetOneColor = "white";
    String inputPetOneBreed = "mini Schnauzer";
    String inputPetTwoName = "Nymeria";
    String inputPetTwoSize = "medium";
    String inputPetTwoColor = "black";
    String inputPetTwoBreed = "Pit Bull";

    @BeforeEach
    public void setUp() {
        underTest = new VirtualPetShelter();
        petOne = new VirtualPet(inputPetOneName, inputPetOneSize, inputPetOneColor, inputPetOneBreed, 100, 100, 100, 0, 100, 0, 0, 25);
        petTwo = new VirtualPet(inputPetTwoName, inputPetTwoSize, inputPetTwoColor, inputPetTwoBreed, 100, 100, 100, 0, 100, 0, 0, 25);

    }


    @Test
    public void shouldBeAbleToAddPet() {
        underTest.add(petOne);
        VirtualPet retrievedPet = underTest.findPet("Cole");
        assertEquals(retrievedPet, petOne);

    }

    @Test
    public void shouldBeAbleToAddPetTwo() {
        underTest.add(petTwo);
        VirtualPet retrievedPet = underTest.findPet("Nymeria");
        assertEquals(retrievedPet, petTwo);
    }

    @Test
    public void shouldBeAbleToRemoveAPetFromShelterForAdoption() {
        underTest.add(petOne);
        underTest.adopt(petOne);
        VirtualPet retrievedPet = underTest.findPet("Cole");
        assertEquals(retrievedPet, null);
    }

    @Test
    public void shouldReturnAllPets() {
        underTest.add(petOne);
        underTest.add(petTwo);

        Collection<VirtualPet> allPets = underTest.getAllPets();
        assertThat(allPets, contains(petOne, petTwo));
    }

    @Test
    public void shouldFeedAllPets() {
        petThree = new VirtualPet("Shaggydog", "", "", "", 100, 150, 100, 0, 100, 0, 0, 25);
        petFour = new VirtualPet("Grey Wind", "", "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        underTest.add(petThree);
        underTest.add(petFour);
        underTest.getAllPets();
        underTest.feedAll();
        assertEquals(petThree.getHungerLevel(), 70);
        assertEquals(petFour.getHungerLevel(), 20);
    }

    @Test
    public void shouldWaterAllPets() {
        petThree = new VirtualPet("Shaggydog", "", "", "", 100, 100, 150, 0, 100, 0, 0, 25);
        petFour = new VirtualPet("Grey Wind", "", "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        underTest.add(petThree);
        underTest.add(petFour);
        underTest.getAllPets();
        underTest.waterAll();
        assertEquals(petThree.getThirstLevel(), 70);
        assertEquals(petFour.getThirstLevel(), 20);
    }

    @Test
    public void shouldRemovePetIfPetDiesDueToStarvation(){
        petFive = new VirtualPet("Summer", inputPetTwoSize, inputPetTwoColor, inputPetTwoBreed, 100, 251, 100, 0, 100, 0, 0, 25);
        underTest.add(petFive);
        underTest.unAlive();
        VirtualPet retrievedPet = underTest.findPet("Summer");
        assertEquals(retrievedPet, null);
    }

    @Test
    public void shouldRemovePetIfPetDiesDueToNoSleep(){
        petFive = new VirtualPet("Summer", inputPetTwoSize, inputPetTwoColor, inputPetTwoBreed, 100, 100, 100, 0, 100, 171, 0, 25);
        underTest.add(petFive);
        underTest.unAlive();
        VirtualPet retrievedPet = underTest.findPet("Summer");
        assertEquals(retrievedPet, null);
    }

    @Test
    public void shouldRemovePetIfPetDiesDueToDehydration(){
        petFive = new VirtualPet("Summer", inputPetTwoSize, inputPetTwoColor, inputPetTwoBreed, 100, 100, 231, 0, 100, 0, 0, 25);
        underTest.add(petFive);
        underTest.unAlive();
        VirtualPet retrievedPet = underTest.findPet("Summer");
        assertEquals(retrievedPet, null);
    }
}