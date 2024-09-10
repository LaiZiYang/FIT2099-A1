package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.capabilities.Status;
import game.actions.AttackAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A class that represents the attack behaviour of hostile NPCs.
 */
public class HostileNPCAttackBehaviour extends AttackBehaviour{

    /**
     * Get the action to attack a random target around the hoslile actor if the target is hostile to hostile actor.
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
                if (target.hasCapability(Status.HOSTILE_TO_ENEMY)){
                    actions.add(new AttackAction(target, "Around"));
                }
            }
        }
        if (!actions.isEmpty()){
            return actions.get(random.nextInt(actions.size()));
        }

        return null;
    }
}
