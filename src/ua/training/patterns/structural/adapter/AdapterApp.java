
package ua.training.patterns.structural.adapter;

public class AdapterApp {

    public static void main(String[] args) {
        //1-й способ через наследование
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        g1.drawSquare();
        //2-й способ через композицию
        VectorGraphicsInterface g2 = new VectorAdapterFromRaster2(new RasterGraphics()); //new VectorAdapterFromRaster2();
        g2.drawLine();
        g2.drawSquare();
    }

}

interface VectorGraphicsInterface {
    void drawLine();
    void drawSquare();
}

class RasterGraphics {
    void drawRasterLine() {
        System.out.println("Рисуем линию");
    }
    void drawRasterSquare() {
        System.out.println("Рисуем квадрат");
    }
}

class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface {
    public void drawLine() {
        drawRasterLine();
    }
    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2 implements VectorGraphicsInterface {
    RasterGraphics raster; //= new RasterGraphics();

    public VectorAdapterFromRaster2(RasterGraphics raster) {
        this.raster = raster;
    }

    public void drawLine() {
        raster.drawRasterLine();
    }
    public void drawSquare() {
        raster.drawRasterSquare();
    }
}