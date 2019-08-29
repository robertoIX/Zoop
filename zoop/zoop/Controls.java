import java.rmi.activation.ActivationGroup_Stub;

class Controls {

    static void FeedPenguin(int fish, Penguin penguin, int penguinNumber)
    {

        if(penguin.isAlive()) {
            penguin.eat(fish);
            Helper.Say("Penguin " + penguinNumber + " snatches a fish.");
        } else {
            Helper.Say("The zoo caretaker ate the fish himself.");
        }
    }

    static void FeedPolarBear(int fish, PolarBear polarBear)
    {
        polarBear.eat(fish);
        Helper.Say("Polar bear snatches a fish.");
    }

    static void PolarBearHunts(Penguin penguin, PolarBear polarBear){
        if (penguin.isAlive()) {
            polarBear.hunt(penguin);
            penguin.die();
            Helper.Say("The polar bear has eaten a penguin!");
        } else {
            Helper.Say("There is no penguin left to hunt for the polar bear. You better be careful!");
        }
    }

    static void penguinNight(Penguin penguin, int cost) {
        penguin.sleep(cost);
    }

    static void polarBearNight(PolarBear polarBear, int cost, Penguin penguin) {
        polarBear.sleep(cost);
        if(polarBear.isStarving()) {
            polarBear.hunt(penguin);
        }
    }
}