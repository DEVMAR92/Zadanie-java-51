package data;

public abstract class Part {
    private String model;
    private String producer;
    private String serialNumber;


    public Part(String model, String producer, String serialNumber) {
        this.model = model;
        this.producer = producer;
        this.serialNumber = serialNumber;

    }

    @Override
    public String toString() {
        return "\nModel: " + model + ", Producent: " + producer + ", Numer Seryjny:" + serialNumber;
    }
}
