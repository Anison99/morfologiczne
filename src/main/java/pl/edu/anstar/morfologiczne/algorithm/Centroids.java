package pl.edu.anstar.morfologiczne.algorithm;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc.*;
import org.opencv.imgproc.Moments;
import pl.edu.anstar.morfologiczne.control.ImageGroupController;

import static org.opencv.imgproc.Imgproc.*;

public class Centroids extends MorphologicalOperation {
	ImageGroupController writableImage = new ImageGroupController();

	public Centroids(Mat source) {
		super(source);
	}

	@Override
	public void calculate() {

	}

	@Override
	public Mat calculate(Mat source) {
		Mat thr = new Mat();
		Mat gray = new Mat();
		Mat src = new Mat();

		cvtColor(src,gray,COLOR_BGR2GRAY); 									//convert to gray scale
		threshold(gray, thr, 100, 255, THRESH_BINARY); 		// convert grayscale to binary
		Moments m = moments(thr, true);							// find moments of the image
		Point point = new Point(m.m10/m.m00, m.m01/m.m00) ; 			// coordinates of centroid
		System.out.println(point);
		circle(src,point,5, new Scalar(128,0,0), -1);			// show the image with pont mark at the centroid

		//TODO print image

		return null;
	}
	
}
