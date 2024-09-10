package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * A class that represents the behavior of a hostile NPC wandering around the map.
 */
public class HostileNPCWanderBehavior extends WanderBehaviour{

    /**
     * Get the action to wander around the map.
     * Hostile NPC will not wander if the player is nearby.
     *
     * @param actor the actor that performs the wander
     * @param map the game map
     * @return the action to wander around the map
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (this.playerIsNearby(actor, map)){
            return null;
        }

        return super.getAction(actor, map);
    }
}
