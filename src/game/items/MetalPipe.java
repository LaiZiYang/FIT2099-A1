package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;

/**
 * A class that represents a metal pipe.
 */
public class MetalPipe extends WeaponItem {

    /**
     * Constructor.
     */
    public MetalPipe(){
        super("Metal Pipe", '!', 1, "smack", 20);
    }

    /**
     * Returns a list of allowable actions that the actor holding the weapon can do to another actor at target location.
     * 
     * @param otherActor the actor to be attacked
     * @param location the location of the other actor
     * @return a list of allowable actions that the actor holding the weapon can do to another actor at target location
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = new ActionList();

        actions.add(new AttackAction(otherActor, "(" + (location.x()) + ", " + (location.y()) + ")", this));
        return actions;
    }

    @Override
    public ActionList allowableActions(Location location) {
        return super.allowableActions(location);
    }
}
