using System;

namespace zoop
{
    public class Program
    {
        private int numberOfDaysLeft;

        private Random rand;

        public void ShowGoodBye()
        {
            Say("bye ...");
        }


        public bool AllAnimalsAreAlive()
        {
            bool allPenguinsAreAlive = GetNumberOfLivingPenguins() == 3;
            bool polarBearIsAlive = this.polarBearEnergy > 0;

            return allPenguinsAreAlive && polarBearIsAlive;
        }
    }
}
