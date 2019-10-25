package tesseract;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ReadImages {
	
	public static void main(String[] args){
		
		ITesseract tess = new Tesseract();
		tess.setDatapath("C:/Programming/4. Tesseract/tessdata/");
		tess.setLanguage("eng+kor");
		
		try{

			String originalImage = "C:/Programming/4. Tesseract/testImage/tessTest08.png";
			String resizeImage = "C:/Programming/4. Tesseract/testImage/tessTest08_resize.png";
			//String imgFormat = "jpg";
			
			Image image = ImageIO.read(new File(originalImage));
			int imageWidth = image.getWidth(null);
			int imageHeight = image.getHeight(null);
			int ratio = 2;
			int resizeWidth = imageWidth * ratio;
			int resizeHeight = imageHeight * ratio;
			
			Image resized = image.getScaledInstance(resizeWidth, resizeHeight, Image.SCALE_SMOOTH);
			BufferedImage newImage = new BufferedImage(resizeWidth, resizeHeight, BufferedImage.TYPE_INT_RGB);
			Graphics g = newImage.getGraphics();
			g.drawImage(resized, 0, 0, null);
			g.dispose();
			//ImageIO.write(newImage, imgFormat, new File(resizeImage));
			ImageIO.write(newImage, "png", new File(resizeImage));

			try {
				String str = tess.doOCR(new File(resizeImage));
				//String str = tess.doOCR(new File("C:/Programming/4. Tesseract/testImage/tessTest03_resize.jpg"));
				System.out.println(str);
			} catch (TesseractException e) {
				System.out.println("Exception " + e.getMessage());
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
