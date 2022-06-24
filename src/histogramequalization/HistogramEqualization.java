/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package histogramequalization;

import java.awt.image.BufferedImage;

/**
 *
 * @author Jonathan Gonzalez
 */
public class HistogramEqualization {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // 1- Read an image:
        BufferedImage inImage = ImageIo.readImage("UTB.jpg");
        ImageIo.getBufferedImageType(inImage,"UTB Image: InImage");
        
        // 2- Convert to Gray (3-channels go to one)
        BufferedImage grayImage = ImageIo.toGray(inImage);
        
        //3 Extract 2-d byte arrays
        //Get 1 array
        byte[][] byteData = ImageIo.getGrayByteImageArray2DFromBufferedImage(grayImage);
        
        // processing
        HistogramEqualize thobject = new HistogramEqualize();
        int[] orgHistogram = thobject.getHistogram(byteData);
        
        System.out.println("Original Histogram:");
        for (int i = 0; i < orgHistogram.length; i++) {
            System.out.println(i + "\t" + orgHistogram[i]);
        }
        
        byte[][] equalizedData = thobject.equalize(byteData);
        int[] newHistogram = thobject.getHistogram(equalizedData);
        
        System.out.println("New Histogram:");
        for (int i = 0; i < newHistogram.length; i++) {
            System.out.println(i + "\t" + newHistogram[i]);
        }
        
        //5- Put back in a buffered image
        BufferedImage outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(equalizedData);
        
        //6- Write out as a file
        ImageIo.writeImage(grayImage, "jpg", "UTB-gray.jpg");
        ImageIo.writeImage(outImage, "jpg", "UTB-gray-equalized.jpg");
    }
    
}
