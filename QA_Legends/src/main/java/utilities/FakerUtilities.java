package utilities;

import java.util.Random;

public class FakerUtilities {
	public static int randomNumberCreation() {
		Random randomobbj = new Random();
		int randomNumber = randomobbj.nextInt(10000);
		return randomNumber;
	}
}

