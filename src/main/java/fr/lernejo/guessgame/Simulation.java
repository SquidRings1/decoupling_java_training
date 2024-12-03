package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long a_number = player.askNextGuess();
        if (a_number == numberToGuess) {
            logger.log("Player have guessed the right number!");
            return true;
        } else if (a_number > numberToGuess) {
            player.respond(false);
        } else if (a_number < numberToGuess) {
            player.respond(true);
        }
        return false;
    }

    public void loopUntilPlayerSucceed(long maxIterations) {
        long start = System.currentTimeMillis();
        boolean success = false;
        // while (!success) {
        //     success = nextRound();
        // }
        for(long i = 0; i < maxIterations; i++) {
            success = nextRound();
            if (success) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        long time = end - start;
        logger.log("time: " + (time / 60000) + ":" + (time % 60000) / 1000 + "." + (time % 1000));
        if (success) {
            logger.log("you won !");
        }
    }
}
