package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.CanSpawn;
import game.actions.ConsumeAction;

/**
 * An abstract class that represents a fruit.
 */
public abstract class Fruit extends Consumable implements CanSpawn {

    int healing;

    /**
     * Constructor.
     * 
     * @param name the name of the fruit
     * @param displayChar the character to display the fruit
     * @param portable whether the fruit is portable
     * @param healing the healing point of the fruit
     */
    public Fruit(String name, char displayChar, boolean portable, int healing){
        super(name, displayChar, portable);
        this.healing = healing;
    }

    /**
     * Make the actor consume the fruit.
     * 
     * @param actor the actor that consumes the fruit
     * @return the message when the fruit is consumed by the actor
     */
    @Override
    public String consumedBy(Actor actor) {
        actor.heal(this.healing);
        return actor + " healed by consuming " + this + " for " + (this.healing) + " points ";
    }

    /**
     * Get all the allowable actions that can be done to the fruit by the owner.
     * 
     * @param owner the actor that owns the fruit
     * @return a list of allowable actions that can be done to the fruit by the owner
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = super.allowableActions(owner);
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * Spawn the fruit at a location.
     * 
     * @param location the location to spawn the fruit
     */
    @Override
    public void spawnAt(Location location) {
        location.addItem(this);
    }
}
