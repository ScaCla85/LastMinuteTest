package lastminutetest.application;

import java.util.List;

import lastminute.application.service.ReciptService;

/**
 * Hello world!
 *
 */
public class App 
{ 
	
	
	public static void main( String[] args ){
    for (int i = 1; i < 4; i++) {
		String cart = String.valueOf(i);

		List<String> recipt = elaborateRecipt(cart);
		if (recipt != null) {

			for (String string : recipt) {
				System.out.println(string);
			}

		} else {
			System.out.println("Errore nell'elaborazione dei dati");
		}
	}
}

private static List<String> elaborateRecipt(String cart) {
			
	ReciptService reciptService = new ReciptService();
	
	switch (Integer.valueOf(cart)) {
	case 1:
		return reciptService.showReciptCart1();
	case 2:
		return reciptService.showReciptCart2();
	case 3:
		return reciptService.showReciptCart3();

	}
	return null;
}
}

