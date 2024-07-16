package controller;

import view.View;
import controller.controller;

public class launch {

	public static void main(String[] args) {

		View vue = new View();
		controller controlleur = new controller(vue);
		try {
			vue.getFrameAppli().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
