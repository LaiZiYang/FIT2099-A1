package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.grounds.Dirt;
import game.grounds.Floor;
import game.grounds.Puddle;
import game.grounds.Wall;
import game.npcs.HuntsmanSpider;
import game.items.LargeBolt;
import game.items.MetalPipe;
import game.items.MetalSheet;
import game.spawners.plants.ImmatureInheritree;
import game.spawners.plants.MatureTree;
import game.spawners.Crater;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author Lai Zi Yang
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(), new ImmatureInheritree(), new MatureTree(), new Crater());

        List<String> map = Arrays.asList(
                        "...~~~~.........~~~...........",
                        "...~~~~.......................",
                        "...~~~........................",
                        "..............................",
                        "...u.........#####............",
                        "............u#___#...........~",
                        ".............#___#..........~~",
                        ".............##_##.........~~~",
                        "..............tu.~~........~~~",
                        "................~~~~.......~~~",
                        ".............~~~~~~~........~~",
                        "......~.....~~~~~~~~.........~",
                        ".....~~~...~~~~~~~~~..........",
                        ".....~~~~~~~~~~~~~~~~........~",
                        ".....~~~~~~~~~~~~~~~~~~~....~~");

        GameMap gameMap = new GameMap(groundFactory, map);
        world.addGameMap(gameMap);

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        gameMap.at(7, 9).addActor(new HuntsmanSpider());

        Player player = new Player("Intern", '@', 4);
        world.addPlayer(player, gameMap.at(15, 6));


        // Add Item to the GameMap
        Item largeBolt1 = new LargeBolt();
        Item largeBolt2 = new LargeBolt();
        Item metalSheet = new MetalSheet();
        Item metalPipe = new MetalPipe();
        gameMap.at(15,8).addItem(largeBolt1);
        gameMap.at(15,9).addItem(largeBolt2);
        gameMap.at(15,10).addItem(metalSheet);
        gameMap.at(15,7).addItem(metalPipe);

        // Add Inheritree
//        Ground inheritree = new Inheritree();

        world.run();

        for (String line : FancyMessage.YOU_ARE_FIRED.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
