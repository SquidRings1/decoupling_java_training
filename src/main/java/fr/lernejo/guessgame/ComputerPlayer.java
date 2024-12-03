package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("computer");
    private long low = 0;
    private long up = 100;
    private long a_number;

    @Override
    public long askNextGuess() {
        a_number = (low + up) / 2;
        logger.log("Is the number " + a_number + " ?");
        return a_number;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            low = a_number + 1;
            logger.log("The number is greater.");
        } else {
            up = a_number - 1;
            logger.log("The number is lower.");
        }
    }
}
