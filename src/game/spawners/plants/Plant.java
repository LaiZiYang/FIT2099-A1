package game.spawners.plants;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Interface for plants.
 */
public interface Plant {

    /**
     * Get the age of the plant.
     * 
     * @return the age of the plant
     */
    int getAge();

    /**
     * Get the initial age of the plant. 
     * 
     * For example: if the plant is a seed, the initial age is 0. If the plant is a tree, the initial age is 10.
     * 
     * @return the initial age of the plant
     */
    int getInitialAge();

    /**
     * Set the age of the plant.
     *
     * @param age the age of the plant
     */
    void setAge(int age);

    /**
     * Grow the plant at the given location.
     *
     * @param location location to be used to do something whenever the plant grows
     */
    void grow(Location location);

}
