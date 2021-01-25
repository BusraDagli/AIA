package org.uha.ensisa.fanfan.APIvols;

import java.util.ArrayList;
import java.util.List;


public class VolsBD {
	private static List<Vol> vols = new ArrayList<Vol>();
	static {
		vols.add(new Vol("SXB123", "Strasbourg", "Paris", 1250));
		vols.add(new Vol("SXB127", "Strasbourg", "Paris", 1420));
		vols.add(new Vol("CDC129", "Poitiers", "Paris", 1710));
		// ...
	}

	public static List<Vol> getVols() {
		return vols;
	}
}