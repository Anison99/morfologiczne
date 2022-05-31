package pl.edu.anstar.morfologiczne.algorithm;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class Skeletonization extends MorphologicalOperation {
	
	@Override
	public Mat calculate(Mat source) {
		try {
			// TODO
			source.convertTo(source, CvType.CV_8UC3);
			// Imgproc.threshold(source, source, 127, 255, CvType.CV_8UC3);
			
			int size = source.cols() * source.rows();
			Size size2 = new Size(source.cols(), source.rows());
			var skel = Mat.zeros(size2, CvType.CV_8UC3);
			var kernel = Imgproc.getStructuringElement(Imgproc.MORPH_CROSS, new Size(3, 3));
			boolean done = false;
			var eroded = Mat.zeros(size2, CvType.CV_8UC3);
			var temp = Mat.zeros(size2, CvType.CV_8UC3);
			while (!done) {
				System.out.println("1");
				debug(skel, temp);
				
				Imgproc.erode(source, eroded, kernel);
				
				System.out.println("initial");
				debug(skel, temp);
				
				Imgproc.dilate(eroded, temp, kernel);
				System.out.println("after dilation");
				debug(skel, temp);
				
				Core.subtract(source, temp, temp);
				System.out.println("after subtraction");
				debug(skel, temp);
				
				Core.bitwise_or(skel, temp, skel);
				System.out.println("Dupa");
				eroded.copyTo(source);
				var zeros = size - Core.countNonZero(source);
				if (zeros == size) {
					done = true;
				}
			}
			return skel;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			return null;
		}
		
	}
	
	private void debug(Mat skel, Mat temp) {
		System.out.println("Skel:");
		System.out.println(skel);
		System.out.println("Skel size");
		System.out.println(skel.size());
		System.out.println("Temp:");
		System.out.println(temp);
		System.out.println(temp.size());
	}
	
}
