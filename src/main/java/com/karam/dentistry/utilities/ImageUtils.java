/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.karam.dentistry.utilities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/*
 * The purpose of this class is to manage the profile pictures
 * set for the patients. It can scale, and convert images to a
 * database friendly format.
 */
public class ImageUtils {
    
    /* 
    * Scales the image to a 72 x 72 pixel image and returns the image as an icon.
    */
    public static ImageIcon scaleImage(Image image, int x, int y){
        Image newimg = image.getScaledInstance(72, 72, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }
    
    /*
    * This method takes in bytes as a parameter and attempts to read in into an image.
    * 
    */
    public static Image bytesToImage(byte[] imageData){
        if (imageData == null){
            System.out.println("Failed to convert bytes into an image!");
            return null;
        }
        
        try{
            ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
            Image image = ImageIO.read(bais);
            return image;
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Failed to convert bytes into an image!");
            return null;
        }
    }
    
    /*
    * This method converts the image into byte data. This is the "Blob" 
    * that will be stored in the database. 
    */
    public static byte[] ImageToBytes(Image image){
        try{
            BufferedImage bufferedImage = new BufferedImage(
                image.getWidth(null),
                image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB
            );
            
            Graphics2D graphics = bufferedImage.createGraphics();
            // 0 x and y because we want it to be 
            graphics.drawImage(image, 0, 0, null);
            graphics.dispose();
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            // writing the data of the buffered image into an array with a format of png
            ImageIO.write(bufferedImage, "png", baos);
            baos.flush();
            byte[] imageBytes = baos.toByteArray();
            baos.close();
            return imageBytes;
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Failed to convert image into an bytes!");
            // this is practically an empty array with nothing
            return new byte[0]; 
        }
    }
}
