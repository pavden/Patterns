
package ua.training.patterns.structural.facade;

public class FacadeApp {

    public static void main(String[] args) {
//        Power power = new Power();
//        power.on();
//
//        DVDROM dvd = new DVDROM();
//        dvd.load();
//
//        HDD hdd = new HDD();
//        hdd.copyFromDVD(dvd);

        Computer computer = new Computer();
        computer.copy();
    }

}

class Computer {
    Power power = new Power();
    DVDROM dvd = new DVDROM();
    HDD hdd = new HDD();

    void copy() {
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}

class Power {
    void on() {
        System.out.println("Включение питания");
    }

    void off() {
        System.out.println("Выключение питания");
    }
}

class DVDROM {
    private boolean data = false;

    public boolean hasData() {
        return data;
    }

    void load() {
        data = true;
    }

    void unload() {
        data = false;
    }
}

class HDD {
    void copyFromDVD(DVDROM dvd) {
        if (dvd.hasData()) {
            System.out.println("Происходит копирование данных с диска");
        } else {
            System.out.println("Вставьте диск с данными");
        }
    }
}
