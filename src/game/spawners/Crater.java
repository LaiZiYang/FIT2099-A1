package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.npcs.NPC;
import game.npcs.HuntsmanSpider;

/**
 * A class that represents a crater spawner that can spawn HuntsmanSpider.
 */
public class Crater extends NpcSpawner {

    private final static int SPAWN_CHANCE = 5;

    private NPC npc = new HuntsmanSpider();

    /**
     * Constructor. Set the spawn chance and the NPC to spawn.
     */
    public Crater(){
        super('u', SPAWN_CHANCE);
        super.setNPC(this.npc);
    }

    /**
     * Tick the crater spawner. In every tick, Spawn the HuntsmanSpider around the location with certain chance.
     * 
     * @param location the location of the crater spawner
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        this.spawnAround(location);
    }
}
