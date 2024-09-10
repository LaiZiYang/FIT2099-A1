package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.capabilities.Accessibiliy;
import game.capabilities.Status;

/**
 * A class that represents the floor inside a building.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * @author Lai Zi Yang
 *
 */
public class Floor extends Ground {

    /**
     * Constructor.
     */
    public Floor() {
        super('_');
        this.addCapability(Accessibiliy.ACCESSIBLE);
    }

    /**
     * Hostile actors cannot enter the floor.
     *
     * @param actor the actor to be checked
     * @return true if the actor can enter the floor
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        if (actor.hasCapability(Status.HOSTILE_TO_PLAYER)){
            return false;
        } else {
            return true;
        }
    }
}
