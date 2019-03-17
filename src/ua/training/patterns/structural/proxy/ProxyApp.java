
package ua.training.patterns.structural.proxy;

public class ProxyApp {

    public static void main(String[] args) {
        //Image image = new RealImage("D:\\images\\my.jpg");
        Image image = new ProxyImage("D:\\images\\my.jpg");
        image.display();
    }

}

interface Image {
    void display();
}

class RealImage implements Image {
    private String file;

    RealImage(String file) {
        this.file = file;
        load();
    }

    private void load() {
        System.out.println("Загрузка " + file);
    }

    public void display() {
        System.out.println("Просмотр " + file);
    }
}

class ProxyImage implements Image {
    private String file;
    private RealImage image;

    ProxyImage(String file) {
        this.file = file;
    }

    public void display() {
        if (image == null) {
            image = new RealImage(file);
        }
        image.display();
    }
}
