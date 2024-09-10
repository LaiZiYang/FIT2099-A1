package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.AttackAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * An abstract class that represents the attack behaviour.
 */
public abstract class AttackBehaviour implements Behaviour {

    /**
     * Get the action to attack a random target around the actor.
     * This is the default implementation of the attack behaviour.
     *
     * @param actor the actor that performs the attack
     * @param map the game map
     * @return the action to attack the target around the actor
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Random random = new Random();
        List<Exit> exits = map.locationOf(actor).getExits();
        ArrayList<Action> actions = new ArrayList<>();

        for (Exit exit: exits){
            Location destination = exit.getDestination();
            if (destination.containsAnActor()){
                Actor target = destination.getActor();
                actions.add(new AttackAction(target, "Around"));
            }
        }
        if (!actions.isEmpty()){
            return actions.get(random.nextInt(actions.size()));
        }

        return null;
    }
}
