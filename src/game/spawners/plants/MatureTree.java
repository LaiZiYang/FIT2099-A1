package game.spawners.plants;

import edu.monash.fit2099.engine.positions.Location;
import game.items.Fruit;
import game.items.LargeFruit;

/**
 * A class that represents a mature tree.
 */
public class MatureTree extends Inheritree{

    private final static int INITIAL_AGE = 5;
    private final static int FRUIT_DROP_CHANCE = 20;
    private final static char DISPLAY_CHAR = 'T';
    private Inheritree nextTree;
    private Fruit fruit = new LargeFruit();
    private int age = INITIAL_AGE;

    /**
     * Constructor. Set the display character, fruit drop chance, initial age and fruit of the mature tree.
     */
    public MatureTree(){
        super(DISPLAY_CHAR, FRUIT_DROP_CHANCE, INITIAL_AGE);
        super.setFruit(this.fruit);
    }

    /**
     * Grow the tree and drop fruit with certain chance at every tick.
     *
     * @param location location to be used to do something whenever the tree grows
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        grow(location);
    }

    /**
     * Get the initial age of the tree.
     * 
     * @return the initial age of the tree
     */
    @Override
    public int getInitialAge() {
        return INITIAL_AGE;
    }
}
