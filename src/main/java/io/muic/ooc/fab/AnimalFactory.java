package io.muic.ooc.fab;

import java.io.ObjectStreamClass;
import java.util.HashMap;
import java.util.Map;

public class AnimalFactory {
    private static Map<AnimalType, Class> animalClassMap = new HashMap<AnimalType, Class>(){{
        AnimalType[] animalTypes = AnimalType.values();
        for (int i = 0; i < animalTypes.length; i++) {
            put(animalTypes[i], animalTypes[i].getAnimalClass());
        }
    }};
    public static Animal createAnimal(AnimalType animalType, Field field, Location location){
        Class animalClass = animalClassMap.get(animalType);
//        if (animalClass != null){
//            try {
//                Animal animal = (Animal) animalClass.newInstance();
//                animal.initialize(true,field,location);
//                return animal;
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
        return createAnimal(animalClass, field, location);
    }
        public static Animal createAnimal(Class animalClass, Field field, Location location){
            //Class animalClass = animalClassMap.get(animalType);
            if (animalClass != null){
                try {
                    Animal animal = (Animal) animalClass.newInstance();
                    animal.initialize(true,field,location);
                    return animal;
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
//        switch (animalType){
//            case RABBIT:
//                return new Rabbit(true, field, location);
//            case FOX:
//                return new Fox(true, field, location);
//            default:
//                throw new IllegalArgumentException("Unknown animal type");
//        }
//        if (animalType.equals(AnimalType.RABBIT)){
//            return new Rabbit(true, field, location);
//        }else if (animalType.equals(AnimalType.FOX)){
//            return new Fox(true, field, location);
//        }else{
//            throw new IllegalArgumentException("Unknown animal type");
//        }
        throw new IllegalArgumentException("Unknown animal type");
    }
}
