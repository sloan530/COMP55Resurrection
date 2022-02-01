package Boilerplate;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import acm.graphics.GImage;

public class TileMap {
	public Tile[][] tiles = new Tile[25][20];
	public MainApplication program;
	
	public TileMap(MainApplication program, String path) {
		this.program = program;
		String str = readTxttoString(path);
		String[] splitStr = str.split("\\s+");
		int counter=0;
		for (int i=0; i<20; i++) {
			System.out.println();
			for(int j=0; j<25; j++) {
				System.out.print(splitStr[counter]);
				counter++;
			}
			
		}
		
		buildMap(splitStr);
	}
	
	public void show() {
		for(int i=0; i<20; i++) {
			for(int j=0; j<25; j++) {
				tiles[j][i].show();
				}
			}
	}
	
	public void hide() {
		for(int i=0; i<20; i++) {
			for(int j=0; j<25; j++) {
				tiles[j][i].hide();
				}
			}
	}
	
	public String readTxttoString(String str) {
		StringBuilder builder = new StringBuilder();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(str));
			String line;
			while((line=reader.readLine())!=null) {
				builder.append(line+"\n");
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
	public int parseInt(String str) {
		return Integer.parseInt(str);
	}
	
	public void buildMap(String[] str) {
		int counter=0;
		for(int i=0; i<20; i++) {
			for(int j=0; j<25; j++) {
				if(parseInt(str[counter])==1) {
					tiles[j][i] = new Tile(program, false, new GImage("res/tile1.png"));
				}else {
					tiles[j][i] = new Tile(program, true, new GImage("res/tile0.png"));
				}
				counter++;
				tiles[j][i].setLocation(j*32,i*32);
			}
		}
	}
	
}
