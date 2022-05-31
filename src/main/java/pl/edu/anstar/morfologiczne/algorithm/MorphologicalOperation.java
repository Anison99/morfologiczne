package pl.edu.anstar.morfologiczne.algorithm;

import java.util.ResourceBundle;

import org.opencv.core.Mat;

import pl.edu.anstar.morfologiczne.MorfologiczneApplication;

public abstract class MorphologicalOperation {
	
	public enum MorphologicalAlgorithmChoice {
		SKEL, BRANCH, CENTROID;
		
		@Override
		public String toString() {
			ResourceBundle languageBundle = MorfologiczneApplication.getBundle();
			String keyString = "key." + super.toString().toLowerCase();
			if (languageBundle.containsKey(keyString)) {
				return languageBundle.getString(keyString);
			}
			return super.toString().toLowerCase();
		}
	}
	
	protected Mat[] results;
	
	public Mat getLastResult() {
		return results[results.length - 1];
	}
	
	public Mat getResult(int index) {
		return results[index];
	}
	
	public int getAmountofResults() {
		return results.length;
	}
	
	protected Mat structureElement;
	
	public Mat getStructureElement() {
		return structureElement;
	}
	
	public abstract Mat calculate(Mat source);
	
}
