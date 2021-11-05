package shelter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetTest {

    @Test
    public void shouldSetPetNamePerUserChoice() {
        String inputPetName = "Randy";
        VirtualPet underTest = new VirtualPet(inputPetName, "", "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        underTest.getName();
        assertEquals(inputPetName, "Randy");
    }

    @Test
    public void shouldReturnColorOfPet() {
        String inputPetColor = "golden";
        VirtualPet underTest = new VirtualPet("", "", inputPetColor, "", 100, 100, 100, 0, 100, 0, 0, 25);
        underTest.getColor();
        assertEquals(inputPetColor, "golden");
    }

    @Test
    public void shouldReturnBodySize() {
        String inputPetSize = "small";
        VirtualPet underTest = new VirtualPet("", inputPetSize, "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        underTest.getSize();
        assertEquals(inputPetSize, "small");
    }

    @Test
    public void shouldReturnPetBreed() {
        String inputPetBreed = "Schnauzer";
        VirtualPet underTest = new VirtualPet("", "", "", inputPetBreed, 100, 100, 100, 0, 100, 0, 0, 25);
        underTest.getBreed();
        assertEquals(inputPetBreed, "Schnauzer");
    }


    @Test
    public void shouldReturnFullDescriptionIncludingSizeColorBreed() {
        String inputPetSize = "small";
        String inputPetColor = "white";
        String inputPetBreed = "Schnauzer";
        VirtualPet underTest = new VirtualPet("", inputPetSize, inputPetColor, inputPetBreed, 100, 100, 100, 0, 100, 0, 0, 25);
        underTest.getDescription();
        assertEquals(inputPetSize + " " + inputPetColor + " " + inputPetBreed, "small white Schnauzer");
    }

    @Test
    public void shouldHaveADefaultHealthLevelOf100() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        int actualHealthLevel = underTest.getHealthLevel();
        assertEquals(100, actualHealthLevel);

    }

    @Test
    public void shouldHaveDefaultHungerLevelOf100() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        int actualHungerLevel = underTest.getHungerLevel();
        assertEquals(100, actualHungerLevel);
    }

    @Test
    public void shouldHaveDefaultThirstLevelOf100() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        int actualThirstLevel = underTest.getThirstLevel();
        assertEquals(100, actualThirstLevel);
    }

    @Test
    public void shouldHaveDefaultWasteLevelOf0() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 110, 50, 25, 0);
        int actualWasteLevel = underTest.getWasteLevel();
        assertEquals(0, actualWasteLevel);
    }

    @Test
    public void shouldHaveDefaultHappinessLevelOf100() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        int actualHappinessLevel = underTest.getHappinessLevel();
        assertEquals(100, actualHappinessLevel);
    }

    @Test
    public void shouldHaveDefaultSleepinessLevelOf0() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        int actualSleepinessLevel = underTest.getSleepinessLevel();
        assertEquals(0, actualSleepinessLevel);
    }

    @Test
    public void shouldHaveDefaultLonelinessLevelOf0() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        int actualLonelinessLevel = underTest.getLonelinessLevel();
        assertEquals(0, actualLonelinessLevel);
    }

    @Test
    public void shouldHaveADefaultActivityLevelOf25() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        int actualActivityLevel = underTest.getActivityLevel();
        assertEquals(25, actualActivityLevel);
    }

    @Test
    public void shouldDecreaseThirstLevelWhenSetTo100By80WhenWatered() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        underTest.water();
        int actualThirstLevel = underTest.getThirstLevel();
        assertEquals(20, actualThirstLevel);
    }

    @Test
    public void shouldIncreaseHappinessLevelBy15WhenPlaying() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        underTest.play();
        int actualHappinessLevel = underTest.getHappinessLevel();
        assertEquals(115, actualHappinessLevel);
    }

    @Test
    public void shouldIncreaseSleepinessLevelBy9WhenPlaying() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        underTest.play();
        int actualSleepinessLevel = underTest.getSleepinessLevel();
        assertEquals(9, actualSleepinessLevel);
    }

    @Test
    public void shouldIncreaseThirstLevelBy11WhenPlaying() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        underTest.play();
        int actualThirstLevel = underTest.getThirstLevel();
        assertEquals(111, actualThirstLevel);
    }

    @Test
    public void shouldIncreaseHungerLevelBy7WhenPlaying() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        underTest.play();
        int actualHungerLevel = underTest.getHungerLevel();
        assertEquals(107, actualHungerLevel);
    }

    @Test
    public void shouldDecreaseLonelinessLevelBy85WhenCuddling() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 0, 85, 25);
        underTest.cuddle();
        int actualLonelinessLevel = underTest.getLonelinessLevel();
        assertEquals(0, actualLonelinessLevel);
    }

    @Test
    public void shouldIncreaseSleepinessLevelBy15WhenCuddling() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 0, 50, 25);
        underTest.cuddle();
        int actualSleepinessLevel = underTest.getSleepinessLevel();
        assertEquals(15, actualSleepinessLevel);
    }

    @Test
    public void shouldDecreaseActivityLevelWhenCuddling() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 0, 50, 25);
        underTest.cuddle();
        int actualActivityLevel = underTest.getActivityLevel();
        assertEquals(13, actualActivityLevel);
    }

    @Test
    public void shouldDecreaseHealthLevelBy10WhenHungerLevelIsAt0() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 0, 100, 0, 100, 0, 50, 25);
        int actualHealthLevel = underTest.getHealthLevel();
        assertEquals(90, actualHealthLevel);
    }

    @Test
    public void shouldDecreaseHealthLevelBy20WhenThirstLevelIsAt0() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 0, 0, 100, 0, 50, 25);
        int actualHealthLevel = underTest.getHealthLevel();
        assertEquals(80, actualHealthLevel);
    }

    @Test
    public void shouldDecreaseHealthLevelBy10WhenSleepinessLevelIsAt110() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 110, 50, 25);
        int actualHealthLevel = underTest.getHealthLevel();
        assertEquals(90, actualHealthLevel);
    }

    @Test
    public void shouldIncreaseWasteLevelBy10WhenWateringOrFeeding() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 110, 50, 25);
        underTest.feed();
        underTest.water();
        int actualWasteLevel = underTest.getWasteLevel();
        assertEquals(70, actualWasteLevel);
    }

    @Test
    public void shouldDecreaseWasteLevelToZeroWhenGoingPotty() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 80, 100, 0, 0, 25);
        underTest.goPotty();
        int actualWasteLevel = underTest.getWasteLevel();
        assertEquals(0, actualWasteLevel);
    }

    @Test
    public void shouldIncreaseLonelinessLevelBy23WhenTickMethodIsCalled() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        underTest.tick();
        int actualLonelinessLevel = underTest.getLonelinessLevel();
        assertEquals(23, actualLonelinessLevel);
    }

    @Test
    public void shouldIncreaseHungerLevelBy5WhenTickMethodIsCalled() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        underTest.tick();
        int actualHungerLevel = underTest.getHungerLevel();
        assertEquals(105, actualHungerLevel);
    }

    @Test
    public void shouldIncreaseThirstLevelBy7WhenTickMethodIsCalled() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        underTest.tick();
        int actualThirstLevel = underTest.getThirstLevel();
        assertEquals(107, actualThirstLevel);
    }

    @Test
    public void shouldIncreaseSleepinessLevelBy6WhenTickMethodIsCalled() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        underTest.tick();
        int actualSleepinessLevel = underTest.getSleepinessLevel();
        assertEquals(6, actualSleepinessLevel);
    }

    @Test
    public void shouldDecreaseHealthLevelBy3WhenTickMethodIsCalled() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        underTest.tick();
        int actualHealthLevel = underTest.getHealthLevel();
        assertEquals(97, actualHealthLevel);
    }

    @Test
    public void shouldDecreaseActivityLevelBy5WhenTickMethodIsCalled() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 100, 0, 0, 25);
        underTest.tick();
        int actualActivityLevel = underTest.getActivityLevel();
        assertEquals(20, actualActivityLevel);
    }

    @Test
    public void shouldSetHealthLevelToo100WhenTakenToVet() {
        VirtualPet underTest = new VirtualPet("", "", "", "", 0, 100, 100, 0, 100, 0, 0, 25);
        underTest.goToVet();
        int actualHealthLevel = underTest.getHealthLevel();
        assertEquals(100, actualHealthLevel);
    }

    @Test
    public void shouldReturnSleepinessLevelAtZero(){
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 100, 100, 0, 110, 50, 25, 0);
        underTest.sleep();
        int actualSleepinessLevel = underTest.getSleepinessLevel();
        assertEquals(0, actualSleepinessLevel);
    }

    @Test
    public void shouldReturnHungerStatusOfStarvingWithHungerLevelAt150(){
        VirtualPet underTest = new VirtualPet("", "", "", "", 100, 150, 100, 0, 110, 50, 25, 0);
        String hungerStatus = underTest.hungerStatus();
        assertEquals(hungerStatus, "STARVING");
    }
}
