package game.spawners.plants;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.capabilities.Accessibiliy;
import game.spawners.Spawner;
import game.Utility;
import game.items.Fruit;

import java.util.ArrayList;

/**
 * Abstract class for Inheritree.
 */
public abstract class Inheritree extends Ground implements Plant, Spawner {

    private Fruit fruit;
    private int spawnChance;
    private Inheritree nextTree;
    private int age;

    /**
     * Constructor. Set the display character, spawn chance and age of the Inheritree.
     * 
     * @param displayChar the character to display the Inheritree
     * @param spawnChance the chance for the fruit to spawn
     * @param age the age of the Inheritree
     */
    public Inheritree(char displayChar, int spawnChance, int age){
        super(displayChar);
        this.spawnChance = spawnChance;
        this.age = age;
        this.addCapability(Accessibiliy.ACCESSIBLE);
    }

    /**
     * Grow the tree and drop fruit with certain chance at every tick. 
     * If current tree's age is the same as the next tree's initial age, replace the current tree with the next tree.
     * 
     * @param location location to be used to do something whenever the tree grows
     */
    @Override
    public void grow(Location location) {

        this.setAge(this.getAge() + 1);
        if (this.nextTree != null && this.nextTree.getInitialAge() == this.getAge()){
            location.setGround(this.nextTree);
            return;
        }

        this.spawnAround(location);
    }

    /**
     * Set the fruit to spawn.
     * 
     * @param fruit the fruit to spawn
     */
    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    /**
     * Set the next tree to spawn.
     * 
     * @param nextTree the next tree to spawn
     */
    public void setNextTree(Inheritree nextTree) {
        this.nextTree = nextTree;
    }

    /**
     * Spawn the fruit around the given location. The fruit will spawn at a random exit that can be access by the fruit of the location if the spawn chance is met.
     * 
     * @param location the location to spawn the fruit around
     */
    @Override
    public void spawnAround(Location location) {
        int randomInt = Utility.generateRandomIntBetweeen(0, 100);
        ArrayList<Exit> availableExits = new ArrayList<>();
        for (Exit exit: location.getExits()){
            if (!exit.getDestination().getGround().hasCapability(Accessibiliy.INACCESSIBLE)){
                availableExits.add(exit);
            }
        }
        if (randomInt < this.spawnChance){
            Exit exit = availableExits.get(Utility.generateRandomIntBetweeen(0, availableExits.size()));
            this.fruit.spawnAt(exit.getDestination());
        }
    }

    /**
     * Get the age of the Inheritree.
     * 
     * @return the age of the Inheritree
     */
    @Override
    public int getAge() {
        return this.age;
    }

    /**
     * set the age of the Inheritree.
     */
    @Override
    public void setAge(int age) {
        this.age = age;
    }
}
