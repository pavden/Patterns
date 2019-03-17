
package ua.training.patterns.structural.bridge;

public class BridgeApp {

    public static void main(String[] args) {
        Car c = new Sedan(new Kia());
        c.showDetails();
    }

}

abstract class Car {
    Make make;

    public Car(Make m) {
        this.make = m;
    }

    abstract void showType();

    void showDetails() {
        showType();
        make.setMake();
    }
}

class Sedan extends Car {
    public Sedan(Make m) {
        super(m);
    }

    void showType() {
        System.out.println("Sedan");
    }
}

class Hatchback extends Car {
    public Hatchback(Make m) {
        super(m);
    }

    void showType() {
        System.out.println("Hatchback");
    }
}

class Coupe extends Car {
    public Coupe(Make m) {
        super(m);
    }

    void showType() {
        System.out.println("Coupe");
    }
}

interface Make {
    void setMake();
}

class Kia implements Make {
    public void setMake() {
        System.out.println("Kia");
    }
}

class Skoda implements Make {
    public void setMake() {
        System.out.println("Skoda");
    }
}

class Mercedes implements Make {
    public void setMake() {
        System.out.println("Mercedes");
    }
}
