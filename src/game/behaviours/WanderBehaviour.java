package game.behaviours;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.actors.Behaviour;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: 
 * @author Lai Zi Yang
 *
 */
public abstract class WanderBehaviour implements Behaviour {

    private final Random random = new Random();

    /**
     * Returns a MoveAction to wander to a random location, if possible.
     * If no movement is possible, returns null.
     *
     * @param actor the Actor enacting the behaviour
     * @param map the map that actor is currently on
     * @return an Action, or null if no MoveAction is possible
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        ArrayList<Action> actions = new ArrayList<>();

        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
                actions.add(exit.getDestination().getMoveAction(actor, "around", exit.getHotKey()));
            }
        }

        if (!actions.isEmpty()) {
            return actions.get(random.nextInt(actions.size()));
        }
        else {
            return null;
        }

    }

    /**
     * Check if the player is nearby the actor.
     *
     * @param actor the actor to check
     * @param map the map that the actor is currently on
     * @return true if the player is nearby the actor, false otherwise
     */
    public boolean playerIsNearby(Actor actor, GameMap map){
        Location creatureLocation = map.locationOf(actor);
        for (Exit exit: creatureLocation.getExits()){
            Location destination = exit.getDestination();
            if(destination.containsAnActor()){
                if(destination.getActor().getDisplayChar() == '@'){
                    return true;
                }
            }
        }

        return false;
    }
}
