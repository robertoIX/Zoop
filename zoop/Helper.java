import java.util.Random;

class Helper {

    private static Random rand = new Random();

    static int RandNumber(int max)
    {

        int number = rand.nextInt(max);
        number += 1;
        return number;
    }

    static void Say(String msg) {
        System.out.println(msg);
    }
}