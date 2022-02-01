package Boilerplate;

import acm.graphics.GImage;

public class Tile {
	boolean hasCollision; 
	private GImage img;
	public MainApplication program;
	
	public Tile(MainApplication program, boolean hasCollision, GImage img) {
		this.hasCollision = hasCollision;
		this.img = img;
		this.program = program;
		
	}
	
	public void show() {
		program.add(img);
	}
	public void hide() {
		program.remove(img);
	}
	public void setLocation(int x, int y) {
		img.setLocation(x, y);
	}
}
