import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    private static Penguin[] penguins = new Penguin[3];
    private static PolarBear polarBear;
    private static int initialNumberOfPenguins = penguins.length;
    private static int numberOfPenguins = penguins.length;
    private static int numberOfDaysLeft;

    private Game()
    {
        numberOfDaysLeft = 7;

        for(int i = 0; i < numberOfPenguins; i++) {
            penguins[i] = new Penguin(100);
        }
        polarBear = new PolarBear(1000);
    }

    private static boolean IsGameWon()
    {
        return numberOfDaysLeft<=0 && numberOfPenguins == initialNumberOfPenguins;
    }

    private static boolean IsGameOver()
    {
        return numberOfDaysLeft<=0 || (numberOfPenguins == 0 && !polarBear.isAlive());
    }

    private static void CheckForDeadPenguins() {
        numberOfPenguins = initialNumberOfPenguins;
        for(int i = 0; i < numberOfPenguins; i++) {
            if(!penguins[i].isAlive()) {
                numberOfPenguins--;
            };
        }
    }

    private static void DayChange()
    {
        numberOfDaysLeft -= 1;

        if(IsGameWon())
        {
            Show.ShowFullScreen();
            return;
        }

        if(IsGameOver())
        {
            Helper.Say("You lose!.. Try again.");
            return;
        }

        int penguinEnergyUsedForADay = 30;
        int polarBearEnergyUsedForADay = 300;

        for(int i = 0; i < numberOfPenguins; i++) {
            Controls.penguinNight(penguins[i], penguinEnergyUsedForADay);
        }

        int RandomPenguin = Helper.RandNumber(numberOfPenguins);
        Controls.polarBearNight(polarBear, polarBearEnergyUsedForADay, penguins[RandomPenguin -1]);
        CheckForDeadPenguins();

        Helper.Say(" *** A new day is comming. ***");
    }

    private static void CloseApp()
    {
        Show.ShowGoodBye();
//        Environment.Exit(0);
    }

    public static void main(String[] args) throws IOException {
        new Game();

        // Start with message
        Show.ShowWelcome();

        // listen for commands
        while(numberOfDaysLeft > 0)
        {
            String cmd = new BufferedReader(new InputStreamReader(System.in)).readLine();

            switch (cmd)
            {
                // close command
                case "close": case "quit": case "exit":
                CloseApp();
                break;

                // feed penguin command
                case "feed penguin":
                    int RandomPenguin = Helper.RandNumber(numberOfPenguins);
                    Controls.FeedPenguin(50, penguins[RandomPenguin - 1], RandomPenguin);
//                    Helper.Say(penguins[RandomPenguin]);
                    break;

                // feed penguin command
                case "feed polar bear":
                    Controls.FeedPolarBear(50, polarBear);
                    break;

                // help command
                case "help": case "?":
                Show.ShowInstructions();
                break;

                // new day command
                case "new day":
                    DayChange();
                    Show.ShowStatus(numberOfPenguins);
                    break;

                // unknown command
                default:
                    Show.ShowWhatDoYouWant(cmd);
                    break;

            }
        }
    }

}