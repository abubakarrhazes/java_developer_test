import java.time.LocalTime;
import java.util.Random;

public class PancakeShop {

    public static void main(String[] args) {
        final int PANCAKES_USER_CAN_EAT = 5;
        final int PANCAKES_SHOPKEEPER_CAN_MAKE = 12;

        Random random = new Random();

        // Starting time of the 30-second slot
        LocalTime startTime = LocalTime.now();
        System.out.println("Starting time: " + startTime);

        // Simulating shopkeeper making pancakes
        int pancakesMade = random.nextInt(PANCAKES_SHOPKEEPER_CAN_MAKE + 1);
        System.out.println("Number of pancakes made by the shopkeeper: " + pancakesMade);

        // Simulating users eating pancakes
        int[] pancakesToEat = new int[3];
        int totalPancakesEaten = 0;
        for (int i = 0; i < 3; i++) {
            pancakesToEat[i] = random.nextInt(PANCAKES_USER_CAN_EAT + 1);
            totalPancakesEaten += pancakesToEat[i];
            System.out.println("User " + (i + 1) + " wants to eat " + pancakesToEat[i] + " pancakes.");
        }
        System.out.println("Total pancakes eaten by users: " + totalPancakesEaten);

        // Ending time of the 30-second slot
        LocalTime endTime = LocalTime.now();
        System.out.println("Ending time: " + endTime);

        // Determine if shopkeeper met the needs of users
        boolean shopkeeperMetNeeds = totalPancakesEaten <= pancakesMade;
        System.out.println("Shopkeeper met the needs of the users: " + shopkeeperMetNeeds);

        // Calculate wasted pancakes
        int wastedPancakes = Math.max(0, pancakesMade - totalPancakesEaten);
        System.out.println("Number of wasted pancakes: " + wastedPancakes);
        if (!shopkeeperMetNeeds) {
            int unmetOrders = totalPancakesEaten - pancakesMade;
            System.out.println("Unmet pancake orders: " + unmetOrders);
        }
    }
}
