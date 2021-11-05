package shelter;

public class VirtualPet {
    private String petName;
    private String petSize;
    private String petColor;
    private String petBreed;
    private int healthLevel = 100;
    private int hungerLevel = 100;
    private int thirstLevel = 100;
    private int wasteLevel = 0;
    private int happinessLevel = 100;
    private int sleepinessLevel = 0;
    private int lonelinessLevel = 0;
    private int activityLevel = 25;
    private boolean isAlive = true;


    public VirtualPet(String inputPetName, String inputPetSize, String inputPetColor, String inputPetBreed, int healthLevel, int hungerLevel, int thirstLevel, int wasteLevel, int happinessLevel, int sleepinessLevel, int lonelinessLevel, int activityLevel) {
        this.petName = inputPetName;
        this.petSize = inputPetSize;
        this.petColor = inputPetColor;
        this.petBreed = inputPetBreed;
        this.healthLevel = healthLevel;
        this.hungerLevel = hungerLevel;
        this.thirstLevel = thirstLevel;
        this.wasteLevel = wasteLevel;
        this.happinessLevel = happinessLevel;
        this.sleepinessLevel = sleepinessLevel;
        this.lonelinessLevel = lonelinessLevel;
        this.activityLevel = activityLevel;
    }

    public String getName() {
        return petName;
    }

    public String getSize() {
        return petSize;
    }

    public String getColor() {
        return petColor;
    }

    public String getBreed() {
        return petBreed;
    }

    public String getDescription() {
        return petSize + " " + petColor + " " + petBreed;
    }

    public int getHealthLevel() {
        if (hungerLevel <= 0) {
            healthLevel -= 10;
        }
        if (thirstLevel <= 0) {
            healthLevel -= 20;
        }
        if (sleepinessLevel >= 90) {
            healthLevel -= 10;
        }
        return healthLevel;
    }

    public int getHungerLevel() {
        if (hungerLevel < 0) {
            hungerLevel = 0;
        }
        return hungerLevel;
    }

    public int getThirstLevel() {
        if (thirstLevel < 0) {
            thirstLevel = 0;
        }
        return thirstLevel;
    }

    public int getWasteLevel() {
        if (wasteLevel < 0) {
            wasteLevel = 0;
        }
        return wasteLevel;
    }

    public int getHappinessLevel() {
        return happinessLevel;
    }

    public int getSleepinessLevel() {
        if (sleepinessLevel < -10) {
            sleepinessLevel = 0;
        }
        return sleepinessLevel;
    }

    public int getLonelinessLevel() {
        if (lonelinessLevel > 150) {
            lonelinessLevel = 150;
        }
        return lonelinessLevel;
    }

    public int getActivityLevel() {
        if (activityLevel > 150) {
            activityLevel = 150;
        }
        return activityLevel;
    }

    public boolean isPetAlive() {
        if (hungerLevel > 250) {
            isAlive = false;
        }
        if (thirstLevel > 230) {
            isAlive = false;
        }
        if (healthLevel < -10) {
            isAlive = false;
        }
        if (sleepinessLevel > 170) {
            isAlive = false;
        }
        return isAlive;
    }


    public void feed() {
        if (hungerLevel > 200) {
            hungerLevel = 130;
            wasteLevel += 35;
        }
        hungerLevel -= 80;
        wasteLevel += 35;
    }

    public void water() {
        if (thirstLevel > 200) {
            thirstLevel = 130;
            wasteLevel += 35;
        }
        thirstLevel -= 80;
        wasteLevel += 35;
    }

    public void play() {
        activityLevel += 35;
        happinessLevel += 15;
        sleepinessLevel += 9;
        thirstLevel += 11;
        hungerLevel += 7;
    }

    public void cuddle() {
        lonelinessLevel -= 85;
        happinessLevel += 13;
        sleepinessLevel += 15;
        activityLevel -= 12;
    }

    public void goPotty() {
        wasteLevel = 0;
    }

    public void goToVet() {
        healthLevel = 100;
        hungerLevel = 100;
        thirstLevel = 100;
        wasteLevel = 0;
        sleepinessLevel = 50;
    }

    public void sleep() {
        sleepinessLevel = 0;
        activityLevel = 80;
        lonelinessLevel = 80;
    }

    public void tick() {
        lonelinessLevel += 23;
        hungerLevel += 5;
        thirstLevel += 7;
        sleepinessLevel += 6;
        healthLevel -= 3;
        activityLevel -= 5;
    }

    public String healthStatus() {
        if (healthLevel <= 50 || hungerLevel > 230 || thirstLevel > 220 || sleepinessLevel > 150) {
            return "DYING\t";
        }
        if (healthLevel < 60 || hungerLevel > 215 || thirstLevel > 205 || sleepinessLevel > 135) {
            return "SICK\t";
        }
        if (healthLevel < 70 || hungerLevel > 200 || thirstLevel > 190 || sleepinessLevel > 140) {
            return "UNWELL";
        }
        return "ok\t";
    }

    public String hungerStatus() {
        if (hungerLevel >= 150) {
            return "STARVING";
        }
        if (hungerLevel > 130) {
            return "RAVENOUS\t";
        }
        if (hungerLevel > 110) {
            return "HUNGRY\t";
        }
        return "ok\t\t";
    }

    public String thirstStatus() {
        if (thirstLevel >= 150) {
            return "DEHYDRATED";
        }
        if (thirstLevel > 130) {
            return "THIRSTY";
        }
        if (thirstLevel > 110) {
            return "PARCHED";
        }
        return "ok\t\t";
    }

    public String wasteStatus() {
        if (wasteLevel >= 150) {
            return "FULL TANK";
        }
        if (wasteLevel >= 100) {
            return "HALF TANK";
        }
        return "ok\t\t";
    }

    public String happinessStatus() {
        if (happinessLevel <= 40) {
            return "MISERABLE";
        }
        if (happinessLevel < 70) {
            return "JOYLESS";
        }
        return "ok\t\t";
    }

    public String sleepinessStatus() {
        if (sleepinessLevel >= 150) {
            return "EXHAUSTED";
        }
        if (sleepinessLevel > 120) {
            return "TRIED\t";
        }
        return "ok\t\t";
    }

    public String lonelinessStatus() {
        if (lonelinessLevel >= 150) {
            return "LONELY\t";
        }
        if (lonelinessLevel > 120) {
            return "ISOLATED";
        }
        if (lonelinessLevel > 100) {
            return "SAD\t";
        }
        return "ok\t\t";
    }

    public String activityStatus() {
        if (activityLevel <= 50) {
            return "IDLE\t";
        }
        if (activityLevel < 80) {
            return "BORED\t";
        }
        return "ok\t\t";
    }
}