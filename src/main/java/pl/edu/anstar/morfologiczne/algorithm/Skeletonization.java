package pl.edu.anstar.morfologiczne.algorithm;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class Skeletonization extends MorphologicalOperation {
	
	@Override
	public Mat calculate(Mat input) {
		Mat source = input.clone();
		try {
			Imgproc.cvtColor(source, source, Imgproc.COLOR_RGB2GRAY);
			// source.convertTo(source, CvType.CV_8UC1);
			// Imgproc.threshold(source, source, 127, 255, CvType.CV_8UC1);
			// Imgproc.morphologyEx(source, source, Imgproc.MORPH_DILATE, source);
			int size = source.cols() * source.rows();
			Size size2 = new Size(source.cols(), source.rows());
			var skel = Mat.zeros(size2, CvType.CV_8UC1);
			
			// Mat kernel = new Mat(3, 3, CvType.CV_16S);
			var kernel = Imgproc.getStructuringElement(Imgproc.MORPH_CROSS, new Size(3, 3));
			kernel.convertTo(kernel, CvType.CV_8UC1);
			boolean done = false;
			var eroded = Mat.zeros(size2, CvType.CV_8UC1);
			var temp = Mat.zeros(size2, CvType.CV_8UC1);
			while (!done) {
				// Imgproc.morphologyEx(source, eroded, Imgproc.MORPH_ERODE, kernel);
				
				Imgproc.erode(source, eroded, kernel);
				// Imgproc.morphologyEx(eroded, temp, Imgproc.MORPH_DILATE, kernel);
				Imgproc.dilate(eroded, temp, kernel);
				
				Core.subtract(source, temp, temp);
				
				Core.bitwise_or(skel, temp, skel);
				
				System.out.println("Dupa");
				
				eroded.copyTo(source);
				source.convertTo(source, CvType.CV_8UC1);
				var zeros = size - Core.countNonZero(source);
				if (zeros == size) {
					done = true;
				}
			}
			return skel;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	@SuppressWarnings("unused")
	private void debug(Mat skel, Mat temp) {
		System.out.println(skel);
		System.out.println(temp);
	}
	
}
