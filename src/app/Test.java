package app;

import data.*;


public class Test {
    public static void main(String[] args) {

        Part procesor1 = new Procesor("I5", "Intel", "axasan1323js", 3000);
        Part memoryRAM1 = new MemoryRAM("XPG", "ADATA", "dqwe233rfwes", 2000, 4096);
        Part hardDrive1 = new HardDrive("DKSHP4", "StarTech", "7738757234", 1024);

        Computer computer = new Computer((Procesor) procesor1, (MemoryRAM) memoryRAM1, (HardDrive) hardDrive1);

        String computerInfo = computer.toString();


        //INFORMACJE O KOMPUTERZE
        System.out.println(computerInfo);
        System.out.println("Temp Procesora " + computer.getProcesor().getTemp() +
                ", Taktowanie" + computer.getProcesor().getTiming());
        System.out.println("Temp Pamięci RAM " + computer.getMemoryRAM().getTemp() +
                ", Taktowanie" + computer.getMemoryRAM().getTiming() + "\n");


        //PODKRĘCANIE PROCESORA I RAMU o 200 MHz:

        computer.getProcesor().overclockUp(200);
        computer.getMemoryRAM().overclockUp(200);

        System.out.println("Temp Procesora: " + computer.getProcesor().getTemp() +
                ", Taktowanie: " + computer.getProcesor().getTiming());
        System.out.println("Temp Pamięci RAM: " + computer.getMemoryRAM().getTemp() +
                ", Taktowanie: " + computer.getMemoryRAM().getTiming() + "\n");

        //POWRÓT DO STANU POCZĄTKOWEGO

        computer.getProcesor().overclockDown(200);
        computer.getMemoryRAM().overclockDown(200);

        //PRÓBA PODKRĘCENIA POWYŻEJ 100 STOPNI

        computer.getProcesor().overclockUp(1000);
        computer.getMemoryRAM().overclockUp(1500);


    }
}
