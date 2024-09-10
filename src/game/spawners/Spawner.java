package game.spawners;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Interface for spawners.
 */
public interface Spawner {

    /**
     * Spawn the actor or item around the given location.
     *
     * @param location the location to spawn the actor or item
     */
    void spawnAround(Location location);

}
