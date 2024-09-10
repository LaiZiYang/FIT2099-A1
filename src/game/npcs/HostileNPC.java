package game.npcs;

import game.capabilities.Status;

/**
 * An abstract class that represents a hostile non-playable character.
 */
public abstract class HostileNPC extends NPC {

    private int intrinsicDamage;

    /**
     * Constructor.
     *
     * @param name the name of the hostile NPC
     * @param displayChar the character to display the hostile NPC
     * @param hitPoint the hit point of the hostile NPC
     * @param intrinsicDamage the intrinsic damage of the hostile NPC
     */
    public HostileNPC(String name, char displayChar, int hitPoint, int intrinsicDamage){
        super(name, displayChar, hitPoint);
        this.intrinsicDamage = intrinsicDamage;
        this.addCapability(Status.HOSTILE_TO_PLAYER);
    }

    /**
     * Get intrinsic damage of the hostile NPC.
     *
     * @return the intrinsic damage of the hostile NPC
     */
    public int getIntrinsicDamage() {
        return intrinsicDamage;
    }
}
