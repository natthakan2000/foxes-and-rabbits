package io.muic.ooc.fab;

import java.awt.*;

public enum AnimalType {
    RABBIT(0.1, Rabbit.class, Color.orange, 9),
    FOX(0.1, Fox.class, Color.blue, 20),
    TIGER(0.03, Tiger.class, Color.red, 60),
    HUNTER(0.00000000001, Hunter.class, Color.BLACK, 0);

    private double breedingProbability;

    private Class animalClass;

    private Color color;

    private int foodValue;

    AnimalType(double breedingProbability, Class animalClass, Color color, int foodValue) {
        this.breedingProbability = breedingProbability;
        this.animalClass = animalClass;
        this.color= color;
        this.foodValue = foodValue;
    }

    public Class getAnimalClass() {
        return animalClass;
    }

    public int getFoodValue() {
        return foodValue;
    }

//    AnimalType(double probability){
//        this.breedingProbability = probability;
//    }

    public Color getColor() {
        return color;
    }

    public double getBreedingProbability() {
        return breedingProbability;
    }
}
