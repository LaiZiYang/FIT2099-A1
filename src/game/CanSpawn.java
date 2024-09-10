package game;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Interface for actors or items that can be spawn.
 */
public interface CanSpawn {

    /**
     * Spawn the actor or item at the given location.
     *
     * @param location the location to spawn the actor or item
     */
    void spawnAt(Location location);
}
