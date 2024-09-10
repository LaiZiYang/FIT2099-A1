package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import game.capabilities.Accessibiliy;

/**
 * A class that represents bare dirt.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * @author Lai Zi Yang
 *
 */
public class Dirt extends Ground {

    /**
     * Constructor.
     */
    public Dirt() {
        super('.');
        this.addCapability(Accessibiliy.ACCESSIBLE);
    }
}