/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curleyhouse;

/**
 *
 * @author frascog
 */
public class Point implements java.io.Serializable{
    
    private float x;
    private float y;
    private float z;
    private float red;
    private float blue;
    private float green;
    private float intensity;

    public Point(double x, double y, double z, double red, double blue, double green, double intensity) {
        this.x = (float) x;
        this.y = (float)y;
        this.z = (float)z;
        this.red = (float)red;
        this.blue = (float)blue;
        this.green = (float)green;
        this.intensity = (float)intensity;
    }

    public Point(String[] pointInfo) {
        this.x = (float)Double.parseDouble(pointInfo[0]);
        this.y = (float)Double.parseDouble(pointInfo[1]);
        this.z = (float)Double.parseDouble(pointInfo[2]);
        this.red = Integer.parseInt(pointInfo[3]);
        this.green = Integer.parseInt(pointInfo[4]);
        this.blue = Integer.parseInt(pointInfo[5]);
        this.red = this.red/255;
        this.green = this.green/255;
        this.blue = this.blue/255;
        this.intensity = (float)Double.parseDouble(pointInfo[6]);
    }

    public float getX() {
        return x;
    }

    public void setX(double x) {
        this.x = (float)x;
    }

    public float getY() {
        return y;
    }

    public void setY(double y) {
        this.y = (float)y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = (float)z;
    }

    public float getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public float getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public float getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public float getIntensity() {
        return intensity;
    }

    public void setIntensity(double intensity) {
        this.intensity = (float)intensity;
    }
    
    
}
