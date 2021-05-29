package io.muic.ooc.fab;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Tiger extends Animal {
    // Characteristics shared by all foxes (class variables).

    // The age at which a fox can start to breed.
    private static final int BREEDING_AGE = 30;
    // The age to which a fox can live.
    private static final int MAX_AGE = 200;
    // The likelihood of a fox breeding.
    //private static final double BREEDING_PROBABILITY = 0.08;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 2;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a fox can go before it has to eat again.
    //private static final int RABBIT_FOOD_VALUE = 9;
    // Random generator
    private static final Random RANDOM = new Random();

    // The fox's food level, which is increased by eating rabbits.
    private int foodLevel;

    /**
     * Create a fox. A fox can be created as a new born (age zero and not
     * hungry) or with a random age and food level.
     *
     * @param randomAge If true, the fox will have random age and hunger level.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    @Override
    public void initialize(boolean randomAge, Field field, Location location) {
        setAlive(true);
        super.initialize(randomAge, field, location);
        foodLevel = RANDOM.nextInt(AnimalType.RABBIT.getFoodValue());
    }
//    }(boolean randomAge, Field field, Location location) {
//        super(randomAge, field, location);
//        //age = 0;
//        setAlive(true);
////        this.field = field;
////        setLocation(location);
////        if (randomAge) {
////            age = RANDOM.nextInt(MAX_AGE);
////            //foodLevel = RANDOM.nextInt(RABBIT_FOOD_VALUE);
////        }
////        } else {
////            // leave age at 0
////            foodLevel = RANDOM.nextInt(RABBIT_FOOD_VALUE);
////        }
//        foodLevel = RANDOM.nextInt(RABBIT_FOOD_VALUE);
//    }

    /**
     * This is what the fox does most of the time: it hunts for rabbits. In the
     * process, it might breed, die of hunger, or die of old age.
     *
     //* @param field The field currently occupied.
     * @param newAnimal A list to return newly born foxes.
     */
    @Override
    public void act(List<Animal> newAnimal) {
        //incrementAge();
        incrementHunger();
        super.act(newAnimal);
//        if (isAlive()) {
//            giveBirth(newFoxes);
//            // Move towards a source of food if found.
//            //Location newLocation = findFood();
//            Location newLocation = moveToNewLocation();
////            if (newLocation == null) {
////                // No food found - try to move to a free location.
////                newLocation = field.freeAdjacentLocation(location);
////            }
//            // See if it was possible to move.
//            if (newLocation != null) {
//                setLocation(newLocation);
//            } else {
//                // Overcrowding.
//                setDead();
//            }
//        }
    }

    /**
     * Make this fox more hungry. This could result in the fox's death.
     */
    private void incrementHunger() {
        foodLevel--;
        if (foodLevel <= 0) {
            setDead();
        }
    }

    /**
     * Look for rabbits adjacent to the current location. Only the first live
     * rabbit is eaten.
     *
     * @return Where food was found, or null if it wasn't.
     */
    private Location findFood() {
        List<Location> adjacent = field.adjacentLocations(location);
        Iterator<Location> it = adjacent.iterator();
        while (it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if (rabbit.isAlive()) {
                    rabbit.setDead();
                    foodLevel = AnimalType.RABBIT.getFoodValue();
                    return where;
                }
            }else if (animal instanceof Fox){
                Fox fox = (Fox) animal;
                if (fox.isAlive()){
                    fox.setDead();
                    foodLevel = AnimalType.FOX.getFoodValue();
                    return where;
                }
            }
        }
        return null;
    }

    @Override
    protected Location moveToNewLocation() {
        Location newLocation = findFood();
        if (newLocation == null) {
            // No food found - try to move to a free location.
            newLocation = field.freeAdjacentLocation(location);
        }
        return newLocation;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected double getBreedingProbability() {
        return AnimalType.TIGER.getBreedingProbability();
    }

    @Override
    protected int getMaxLitterSize() {
        return MAX_LITTER_SIZE;
    }

    @Override
    protected int getBreedingAge() {
        return BREEDING_AGE;
    }

//    @Override
//    protected Animal createYoung(boolean randomAge, Field field, Location location) {
////        Fox fox = new Fox();
////        fox.initialize(randomAge, field, location);
//        return AnimalFactory.createAnimal(this.getClass(), field, location);
//    }

//    @Override
//    protected Animal breedOne(boolean randomAge, Field field, Location location) {
////        Fox fox = new Fox();
////        fox.initialize(randomAge, field, location);
//        return AnimalFactory.createAnimal(this.getClass(), field, location);
//    }
}
