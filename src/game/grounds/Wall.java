package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.capabilities.Accessibiliy;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * @author Lai Zi Yang
 */
public class Wall extends Ground {

    /**
     * Constructor.
     */
    public Wall() {
        super('#');
        this.addCapability(Accessibiliy.INACCESSIBLE);
    }

    /**
     * Actors cannot enter the wall.
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}
