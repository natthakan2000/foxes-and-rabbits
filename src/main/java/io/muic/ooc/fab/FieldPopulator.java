package io.muic.ooc.fab;

import io.muic.ooc.fab.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FieldPopulator {
    private static final Random RANDOM = new Random();
    // The probability that a fox will be created in any given grid position.
//    private static final double FOX_CREATION_PROBABILITY = 0.02;
    // The probability that a rabbit will be created in any given position.
//    private static final double RABBIT_CREATION_PROBABILITY = 0.08;
    private Map<AnimalType, Double> probabilityMap = new HashMap<AnimalType, Double>(){{
        AnimalType[] animalTypes = AnimalType.values();
        for (int i = 0; i < animalTypes.length; i++) {
            put(animalTypes[i], animalTypes[i].getBreedingProbability());
        }
    }};
//    public FieldPopulator(){
//        AnimalType[] animalTypes = AnimalType.values();
//        for (int i = 0; i < animalTypes.length; i++) {
//            probabilityMap.put(animalTypes[i], animalTypes[i].getBreedingProbability());
//        }
////        probabilityMap.put(AnimalType.FOX, FOX_CREATION_PROBABILITY);
////        probabilityMap.put(AnimalType.RABBIT, RABBIT_CREATION_PROBABILITY);
//    }
    public void populate(Field field, List<Animal> animals) {
        field.clear();
        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                for (Map.Entry<AnimalType, Double> entry:probabilityMap.entrySet()){
                    if (RANDOM.nextDouble() <= entry.getValue()){
                        Location location = new Location(row, col);
                        Animal animal = AnimalFactory.createAnimal(entry.getKey(), field, location);
                        animals.add(animal);
                        break;
                    }
                }
//                if (RANDOM.nextDouble() <= FOX_CREATION_PROBABILITY) {
//                    Location location = new Location(row, col);
//                    //Fox fox = new Fox(true, field, location);
//                    Animal animal = AnimalFactory.createAnimal(AnimalType.FOX, field, location);
//                    animals.add(animal);
//                } else if (RANDOM.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
//                    Location location = new Location(row, col);
//                    //Rabbit rabbit = new Rabbit(true, field, location);
//                    Animal animal = AnimalFactory.createAnimal(AnimalType.RABBIT, field, location);
//                    animals.add(animal);
//                }
                // else leave the location empty.
            }
        }
    }
}
