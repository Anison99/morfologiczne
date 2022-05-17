package pl.edu.anstar.morfologiczne.control;

public abstract class ChildController {
	
	protected MorfEditController parentController;
	
	public void setParentController(MorfEditController parentController) {
		this.parentController = parentController;
	}
	
}
