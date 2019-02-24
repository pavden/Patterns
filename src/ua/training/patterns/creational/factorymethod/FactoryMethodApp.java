
package ua.training.patterns.creational.factorymethod;

import java.util.Date;

public class FactoryMethodApp {

    public static void main(String[] args) {
        WatchMaker watchMaker = getWatchMakerByName("Digital");
        Watch watch = watchMaker.createWatch();
        watch.showTime();
    }

    public static WatchMaker getWatchMakerByName(String watchMaker) {
        if (watchMaker.equals("Digital")) {
            return new DigitalWatchMaker();
        } else if (watchMaker.equals("Roman")) {
            return new RomanWatchMaker();
        }
        throw new RuntimeException("Неподдерживаемая производственная линия часов: " + watchMaker);
    }

}

interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomanWatch implements Watch {
    public void showTime() {
        System.out.println("VII-XX");
    }
}

interface WatchMaker {
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker {
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomanWatchMaker implements WatchMaker {
    public Watch createWatch() {
        return new RomanWatch();
    }
}
