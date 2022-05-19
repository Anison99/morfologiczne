package pl.edu.anstar.morfologiczne.algorithm;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javafx.scene.image.Image;

public class Skeletonization {
	
	private static Mat skeleton(Mat sourceImg) {
		boolean done = false;
		Mat img = sourceImg.clone();
		
		Mat imgGray = new Mat();
		Imgproc.cvtColor(img, imgGray, Imgproc.COLOR_BGR2GRAY);
		
		Mat tresh = new Mat();
		/* double thresh = */Imgproc.threshold(imgGray, tresh, 100, 255,
				Imgproc.THRESH_BINARY_INV | Imgproc.THRESH_OTSU);
		
		Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_CROSS, new Size(3, 3));
		Mat eroded = new Mat();
		Mat temp = new Mat();
		Mat skel = new Mat(tresh.rows(), tresh.cols(), CvType.CV_8UC1, new Scalar(0));
		
		int size = sourceImg.cols() * sourceImg.rows();
		int zeros = 0;
		
		while (!done) {
			Imgproc.erode(tresh, eroded, element);
			Imgproc.dilate(eroded, temp, element);
			Core.subtract(tresh, temp, temp);
			Core.bitwise_or(skel, temp, skel);
			eroded.copyTo(tresh);
			
			zeros = size - Core.countNonZero(tresh);
			if (zeros == size) {
				done = true;
			}
		}
		return skel;
	}
	
//	public static Mat loadImage(String imagePath) {
//		return Imgcodecs.imread(imagePath);
//	}
	
	public static Image mat2Img(Mat mat) {
		MatOfByte bytes = new MatOfByte();
		Imgcodecs.imencode("img.bmp", mat, bytes);
		InputStream inputStream = new ByteArrayInputStream(bytes.toArray());
		return new Image(inputStream);
	}
	
}
