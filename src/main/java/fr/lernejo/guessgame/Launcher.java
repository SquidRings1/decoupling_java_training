package fr.lernejo.guessgame;

import java.security.SecureRandom;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        Player player = new HumanPlayer();
        Simulation simulation = new Simulation(player);

        SecureRandom random = new SecureRandom();
        // long randomNumber = random.nextLong(); // génère un nombre entre Long.MIN_VALUE et Long.MAX_VALUE
        long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)
        //simulation.initialize(randomNumber);
        //simulation.loopUntilPlayerSucceed(42);
        //System.out.println("The number to guess was: " + randomNumber);

        if (args[0].equals("-interactive")) {
            // run HumanPlayer
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
            System.out.println("The number to guess was: " + randomNumber);
        }else if (args[0].equals("-auto") && args.length == 2) {
            // run automode
            player = new ComputerPlayer();
            simulation = new Simulation(player);
            long secondnumber = Long.parseLong(args[1]);
            simulation.initialize(secondnumber);
            simulation.loopUntilPlayerSucceed(1000);
        } else {
            System.out.println("Usage: java -jar decoupling_java_training.jar -interactive or -auto {a number}");
        }
    }
}
