package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

/**
 * An abstract class that represents a consumable item.
 */
public abstract class Consumable extends Item {

    /**
     * Constructor.
     * 
     * @param name the name of the consumable item
     * @param displayChar the character to display the consumable item
     * @param portable whether the consumable item is portable
     */
    public Consumable(String name, char displayChar, boolean portable){
        super(name, displayChar, portable);
    }

    /**
     * Make the actor consume the consumable item.
     *
     * @param actor the actor that consumes the consumable item
     * @return the message when the consumable item is consumed by the actor
     */
    public abstract String consumedBy(Actor actor);
}
