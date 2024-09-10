package game;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;

import java.util.List;
import java.util.Random;

/**
 * A class that store static utility functions.
 */
public class Utility {

    /**
     * Generate a random integer between the lower and upper bound.
     * 
     * @param lower the lower bound
     * @param upper the upper bound
     * @return the random integer
     */
    public static int generateRandomIntBetweeen(int lower, int upper){
        Random random = new Random();
        int randomInt = random.nextInt(upper) + lower;
        return randomInt;
    }

    /**
     * Get a random exit from the location.
     * 
     * @param location the location to get the random exit
     * @return the random exit
     */
    public static Exit getRandomExit(Location location){
        List<Exit> exits = location.getExits();
        return exits.get(generateRandomIntBetweeen(0, exits.size()));
    }

}
