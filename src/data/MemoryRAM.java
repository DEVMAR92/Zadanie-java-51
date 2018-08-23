package data;

public class MemoryRAM extends Part implements Overclocking {
    private final double STARTING_TIMING;
    private double timing;
    private int memoryAmount;
    private double temp;

    public MemoryRAM(String model, String producer, String serialNumber, double timing, int memoryAmount) {
        super(model, producer, serialNumber);
        this.timing = timing;
        this.memoryAmount = memoryAmount;
        this.STARTING_TIMING = timing;
        this.temp = timing / 150;
    }

    public double getTiming() {
        return timing;
    }

    public void setTiming(double timing) {
        this.timing = timing;
    }

    public int getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(int memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public double getTemp() {
        return temp;
    }

    public double getSTARTING_TIMING() {
        return STARTING_TIMING;
    }


    @Override
    public String toString() {
        return super.toString() + ", Taktowanie(MHz): " + STARTING_TIMING + ", Ilość Pamieci(MB): " + memoryAmount;
    }

    @Override
    public void overclockUp(int speedUp) throws TemperatureToHigh {

        double checkTemp = temp;
        checkTemp += speedUp / 15;
        if (checkTemp > 100) {
            throw new TemperatureToHigh();
        }else {
            timing += speedUp;
            temp += speedUp / 15;
        }
    }

    @Override
    public void overclockDown(int speedDown) throws BelowTheInitialState {

        double checkTiming = timing;
        checkTiming -= speedDown;
        if (checkTiming < STARTING_TIMING) {
            throw new BelowTheInitialState();
        }else {
            timing -= speedDown;
            temp -= speedDown / 15;
        }

    }

}
