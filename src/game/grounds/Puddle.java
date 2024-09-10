package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import game.capabilities.Accessibiliy;

/**
 * A class that represents a puddle.
 */
public class Puddle extends Ground {

    /**
     * Constructor.
     */
    public Puddle() {
        super('~');
        this.addCapability(Accessibiliy.ACCESSIBLE);
    }
}
