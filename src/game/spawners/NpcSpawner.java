package game.spawners;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.capabilities.Accessibiliy;
import game.npcs.NPC;
import game.Utility;

/**
 * Abstract class for NPC spawner.
 */
public abstract class NpcSpawner extends Ground implements Spawner {

    private NPC NPC;
    private int spawnChance;

    /**
     * Constructor.
     * 
     * @param displayChar the character to display the spawner
     * @param spawnChance the chance for the NPC to spawn
     */
    public NpcSpawner(char displayChar, int spawnChance){
        super(displayChar);
        this.spawnChance = spawnChance;
        this.addCapability(Accessibiliy.ACCESSIBLE);
    }

    /**
     * Set the NPC to spawn.
     */
    public void setNPC(NPC NPC) {
        this.NPC = NPC;
    }

    /**
     * Spawn the NPC around the given location. The NPC will spawn at a random exit that can be access by the NPC of the location if the spawn chance is met.
     * 
     * @param location the location to spawn the NPC around
     */
    @Override
    public void spawnAround(Location location) {
        int randomInt = Utility.generateRandomIntBetweeen(0, 100);
        if (randomInt < this.spawnChance){
            Exit randomExit;
            do{
                randomExit = Utility.getRandomExit(location);
            } while (randomExit.getDestination().containsAnActor() || !randomExit.getDestination().canActorEnter(this.NPC));

            this.NPC.spawnAt(randomExit.getDestination());
        }
    }
}
