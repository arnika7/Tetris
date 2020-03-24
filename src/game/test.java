package game;

import java.awt.Color;
import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		String[] st = new String[200];
		for (int i = 0; i < 200; i++) {
			st[i] =  Integer.toString(i);
		}
		String line = Arrays.toString(st);
		for (int i = 0; i < 200; i++) {
			System.out.println(line.substring(1, line.length()-1).split(", ")[i]+".");
		}
		
	}
}
