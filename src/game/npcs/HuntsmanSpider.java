package game.npcs;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.behaviours.HostileNPCAttackBehaviour;
import game.behaviours.HostileNPCWanderBehavior;
import game.capabilities.Status;

import java.util.HashMap;
import java.util.Map;

/**
 * A class that represents the Huntsman Spider.
 */
public class HuntsmanSpider extends HostileNPC {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Constructor. Initialize its display character, hit points, intrinsic damage and add the behaviours.
     */
    public HuntsmanSpider() {
        super("Huntsman Spider", '8', 1, 1);
        this.behaviours.put(999, new HostileNPCWanderBehavior());
        this.behaviours.put(998, new HostileNPCAttackBehaviour());
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * The huntsman spider can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return           a list of actions that can be performed by the other Actor
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }

    /**
     * Get the intrinsic weapon of the Huntsman Spider.
     *
     * @return IntrinsicWeapon the intrinsic weapon of the Huntsman Spider
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        int dmg = Math.round(this.getIntrinsicDamage() * this.damageMultiplier);
        return new IntrinsicWeapon(dmg, "uses its long leg to attack", 25);
    }

    /**
     * Spawn the Huntsman Spider at the given location.
     *
     * @param location the location to spawn the Huntsman Spider
     */
    @Override
    public void spawnAt(Location location) {
        location.addActor(new HuntsmanSpider());
    }
}
