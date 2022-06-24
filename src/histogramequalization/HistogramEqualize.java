/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package histogramequalization;

/**
 *
 * @author Jonathan Gonzalez
 */
public class HistogramEqualize {
    
    
    
    public byte[][] equalize(byte[][] grayLevelImage) {
        
        int h = grayLevelImage.length;
        int w = grayLevelImage[0].length;
        byte[][] equalizedGrayLevelImage = new byte[h][w];
        int[] LUT = createLUT(grayLevelImage);
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                equalizedGrayLevelImage[i][j] = (byte) LUT[(grayLevelImage[i][j] & 0xFF)];
            }
        }
        return equalizedGrayLevelImage;
    }
    
    // creates histogram from gray image
    public int[] getHistogram(byte[][] inArray) {
        int h = inArray.length;
        int w = inArray[0].length;
        int[] histogram = new int[256];
        
        for (int i = 0; i < h; i++){
            for (int j = 0; j < w; j++) {
                histogram[(inArray[i][j] & 0xFF)]++;
            }
        }
        
        return histogram;
    }
    
    private int[] createLUT(byte[][] grayLevelImage) {
        int [] LUT = new int[256];
        float[] HC = new float[256];
        float[] HCN = new float[256];
        int[] H = getHistogram(grayLevelImage);
        
        HC[0] = H[0];
        for (int i = 1; i <H.length; i++) {
            HC[i] = HC[i-1] + H[i];
        }
        for (int i = 0; i <H.length; i++) {
            HCN[i] = HC[i] / (float) (grayLevelImage.length * grayLevelImage[0].length);
            LUT[i] = Math.round((HCN[i] * 255));
            System.out.println("LUT is");
            System.out.println("i " + i + "     LUT-v: " + LUT[i]);
        }
        return LUT;
    }
}
