package data;

public class Computer {
    private Procesor procesor;
    private MemoryRAM memoryRAM;
    private HardDrive hardDrive;

    public Computer(Procesor procesor, MemoryRAM memoryRAM, HardDrive hardDrive) {
        this.procesor = procesor;
        this.memoryRAM = memoryRAM;
        this.hardDrive = hardDrive;
    }

    public Procesor getProcesor() {
        return procesor;
    }

    public void setProcesor(Procesor procesor) {
        this.procesor = procesor;
    }

    public MemoryRAM getMemoryRAM() {
        return memoryRAM;
    }

    public void setMemoryRAM(MemoryRAM memoryRAM) {
        this.memoryRAM = memoryRAM;
    }

    public HardDrive getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(HardDrive hardDrive) {
        this.hardDrive = hardDrive;
    }

    @Override
    public String toString() {
        return "Komputer PC\nPodzespoly:\nProcesor:" + procesor.toString() + "\nPamiec RAM:" + memoryRAM.toString() + "\nDysk Twardy:" + hardDrive.toString();
    }
}
