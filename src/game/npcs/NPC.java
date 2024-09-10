package game.npcs;

import edu.monash.fit2099.engine.actors.Actor;
import game.CanSpawn;

/**
 * An abstract class that represents a non-playable character.
 */
public abstract class NPC extends Actor implements CanSpawn {

    /**
     * Constructor.
     * 
     * @param name the name of the NPC
     * @param displayChar the character to display the NPC
     * @param hitPoint the hit point of the NPC
     */
    public NPC(String name, char displayChar, int hitPoint){
        super(name, displayChar, hitPoint);
    }
}
