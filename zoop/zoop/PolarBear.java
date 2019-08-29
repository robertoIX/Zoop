class PolarBear {
    private int energy;
    private final int starvationEnergyThreshold = 150;

    PolarBear(int energy) {
        this.energy = energy;
    }

    boolean isAlive() {
        return energy > 0;
    }

    boolean isStarving() {
        return energy < starvationEnergyThreshold;
    }

    void eat(int fish) {
        energy += fish;
    }

    void hunt(Penguin penguin) {
        energy += penguin.energy;
    }

    void sleep(int cost) {
        energy =- cost;
    }
}