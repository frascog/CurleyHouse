/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClasses;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Greg
 */
public class IDXFileReader {
    
    public static int[] readFiles(FileInputStream inImage, FileInputStream inLabel){
        int[] hashMap = new int[10];
        int[] imgPixels = null;
        try {
            int magicNumberImages = (inImage.read() << 24) | (inImage.read() << 16) | (inImage.read() << 8) | (inImage.read());
            int numberOfImages = (inImage.read() << 24) | (inImage.read() << 16) | (inImage.read() << 8) | (inImage.read());
            int numberOfRows  = (inImage.read() << 24) | (inImage.read() << 16) | (inImage.read() << 8) | (inImage.read());
            int numberOfColumns = (inImage.read() << 24) | (inImage.read() << 16) | (inImage.read() << 8) | (inImage.read());
            int magicNumberLabels = (inLabel.read() << 24) | (inLabel.read() << 16) | (inLabel.read() << 8) | (inLabel.read());
            int numberOfLabels = (inLabel.read() << 24) | (inLabel.read() << 16) | (inLabel.read() << 8) | (inLabel.read());
            BufferedImage image = new BufferedImage(numberOfColumns, numberOfRows, BufferedImage.TYPE_INT_ARGB);
            int numberOfPixels = numberOfRows * numberOfColumns;
            imgPixels = new int[numberOfPixels];
            for(int i = 0; i < numberOfImages; i++) {
                if(i % 100 == 0) {System.out.println("Number of images extracted: " + i);}
                for(int p = 0; p < numberOfPixels; p++) {
                    int gray = 255 - inImage.read();
                    imgPixels[p] = 0xFF000000 | (gray<<16) | (gray<<8) | gray;
                }
                image.setRGB(0, 0, numberOfColumns, numberOfRows, imgPixels, 0, numberOfColumns);
                int label = inLabel.read();
                hashMap[label]++;
                //File outputfile = new File(outputPath + label + "_0" + hashMap[label] + ".png");

                //ImageIO.write(image, "png", outputfile);
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(IDXFileReader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (inImage != null) {
                try {
                    inImage.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (inLabel != null) {
                try {
                    inLabel.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return imgPixels;
    }

    private byte[] getPixelArrayToBmpByteArray(byte[] pixelData, int width, int height, int depth) throws Exception {
        int[] pixels = byteToInt(pixelData);

        BufferedImage image = null;
        if (depth == 8) {
            image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        } else if (depth == 24) {
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        }

        WritableRaster raster = (WritableRaster) image.getData();
        raster.setPixels(0, 0, width, height, pixels);
        image.setData(raster);
        return getBufferedImageToBmpByteArray(image);
    }

    private byte[] getBufferedImageToBmpByteArray(BufferedImage image) {
        byte[] imageData = null;
        try {
            ByteArrayOutputStream bas = new ByteArrayOutputStream();
            ImageIO.write(image, "bmp", bas);
            imageData = bas.toByteArray();
            bas.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return imageData;
    }

    private int[] byteToInt(byte[] data) {
        int[] ints = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            ints[i] = (int) data[i] & 0xff;
        }
        return ints;
    }
}
