package tesseract;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ReadImages2 {
	
	public static void main(String[] args){
		
		ITesseract tess = new Tesseract();
		tess.setDatapath("C:/Programming/4. Tesseract/tessdata/");
		tess.setLanguage("eng+kor");
		
		
		try {
			Image original = ImageIO.read(new File("C:/Programming/4. Tesseract/testImage/tessTest04.jpg"));
			int ratio = 2;
			int resizeWidth = original.getWidth(null) * ratio;
			int resizeHeight = original.getHeight(null) * ratio;
			
			try {
				String str = tess.doOCR(new File("C:/Programming/4. Tesseract/testImage/tessTest04.jpg"));
				System.out.println("Result");
				System.out.println(str);
			} catch (TesseractException e) {
				System.out.println("Exception " + e.getMessage());
			}
			
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


	}

}
