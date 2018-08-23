package data;

public class Procesor extends Part implements Overclocking {
    private final double STARTING_TIMING;
    private double timing;
    private double temp;

    public Procesor(String model, String producer, String serialNumber, double timing) {
        super(model, producer, serialNumber);
        this.timing = timing;
        this.STARTING_TIMING = timing;
        this.temp = timing / 100;
    }

    public double getTiming() {
        return timing;
    }

    public void setTiming(double timing) {
        this.timing = timing;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getSTARTING_TIMING() {
        return STARTING_TIMING;
    }

    @Override
    public String toString() {
        return super.toString() + ", Taktowanie(MHz): " + STARTING_TIMING;
    }

    @Override
    public void overclockUp(int speedUp) throws TemperatureToHigh {
        double checkTemp = temp;
        checkTemp += speedUp / 10;
        if (checkTemp > 100) {
            throw new TemperatureToHigh();
        }else {
            timing += speedUp;
            temp += speedUp / 10;
        }
    }

    @Override
    public void overclockDown(int speedDown) throws BelowTheInitialState {
        double checkTiming = timing;
        checkTiming -= speedDown;
        temp -= speedDown / 10;
        if (checkTiming < STARTING_TIMING) {
            throw new BelowTheInitialState();
        }else {
            timing -= speedDown;
            temp -= speedDown / 10;
        }
    }
}
