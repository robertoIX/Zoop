class Penguin {
    int energy;

    Penguin(int energy) {
        this.energy = energy;
    }

    boolean isAlive() {
        return energy > 0;
    }

    void eat(int fish) {
        energy += fish;
    }

    void die() {
        energy = 0;
    }

    void sleep(int cost) {
        energy =- cost;
    }
}