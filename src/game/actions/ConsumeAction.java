package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Consumable;

/**
 * An action that represents consuming a consumable item.
 */
public class ConsumeAction extends Action {

    /**
     * The consumable item to be consumed.
     */
    Consumable item;

    /**
     * Constructor.
     *
     * @param item the consumable item to be consumed
     */
    public ConsumeAction(Consumable item){
        this.item = item;
    }

    /**
     * Execute the action of consuming the item.
     * 
     * @param actor the actor that consumes the item
     * @param map the game map
     * @return a description of the result of consuming the item
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = this.item.consumedBy(actor);
        actor.removeItemFromInventory(this.item);
        return result;
    }

    /**
     * Describe the action of consuming the item.
     *
     * @param actor the actor that consumes the item
     * @return a description of the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consume " + this.item;
    }
}
