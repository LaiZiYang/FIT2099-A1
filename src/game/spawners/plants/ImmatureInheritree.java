package game.spawners.plants;

import edu.monash.fit2099.engine.positions.Location;
import game.items.Fruit;
import game.items.SmallFruit;

/**
 * A class that represents an immature inheritree.
 */
public class ImmatureInheritree extends Inheritree{

    private final static int INITIAL_AGE = 0;
    private final static int FRUIT_DROP_CHANCE = 30;
    private final static char DISPLAY_CHAR = 't';
    private Inheritree nextTree = new MatureTree();
    private Fruit fruit = new SmallFruit();
    private int age = INITIAL_AGE;

    /**
     * Constructor. Set the display character, fruit drop chance, initial age, fruit and next tree of the immature inheritree.
     */
    public ImmatureInheritree(){
        super(DISPLAY_CHAR, FRUIT_DROP_CHANCE, INITIAL_AGE);
        super.setFruit(this.fruit);
        super.setNextTree(this.nextTree);
    }

    /**
     * Grow the tree and drop fruit with certain chance at every tick.
     *
     * @param location location to be used to do something whenever the tree grows
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        this.grow(location);
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
