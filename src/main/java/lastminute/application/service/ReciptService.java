package lastminute.application.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lastminute.application.dao.ProductDao;
import lastminute.application.utils.CartUtils;

public class ReciptService {

	private CartUtils cartUtils = new CartUtils();

	private final double TAX_FOR_TOTAL = 0.1;
	private final double IMPORTED_TAX_FOR_TOTAL = 0.05;

	public List<String> showReciptCart1() {
		List<ProductDao> cart1 = new ArrayList<ProductDao>();
		cart1 = cartUtils.getCart1();

		return createRecipt(cart1, 1);

	}

	public List<String> showReciptCart2() {
		List<ProductDao> cart2 = new ArrayList<ProductDao>();
		cart2 = cartUtils.getCart2();

		return createRecipt(cart2, 2);

	}

	public List<String> showReciptCart3() {
		List<ProductDao> cart3 = new ArrayList<ProductDao>();
		cart3 = cartUtils.getCart3();

		return createRecipt(cart3, 3);
	}

	private List<String> createRecipt(List<ProductDao> cart, int index) {

		HashMap<ProductDao, Double> priceAndTax = new HashMap<ProductDao, Double>();

		for (ProductDao productDao : cart) {

			Double taxValue = 0d;
			Double impTaxValue = 0d;

			if (productDao.getUseTax()) {
				taxValue = (productDao.getPrice() * TAX_FOR_TOTAL);

				Double taxValueTemp = taxValue * 100;
				Long taxValueRound = Math.round(taxValueTemp);
				taxValue = (taxValueRound / 100d);

			}

			if (productDao.isImported()) {

				impTaxValue = (productDao.getPrice()) * IMPORTED_TAX_FOR_TOTAL;

				Double impTaxValueTemp = impTaxValue * 100;
				Long impTaxValueRound = Math.round(impTaxValueTemp);
				impTaxValue = (impTaxValueRound / 100d);

			}

			taxValue += impTaxValue;
			priceAndTax.put(productDao, taxValue);

		}

		double taxTotal = 0d;
		double priceTotal = 0d;
		List<String> retString = new ArrayList<String>();
		retString.add("Output " + index + ":");

		for (ProductDao productDao : cart) {

			Double priceTaxed = (productDao.getPrice() + priceAndTax.get(productDao));

			Double priceTaxedTemp = priceTaxed * 100;

			Long priceTaxedRound = Math.round(priceTaxedTemp);
			priceTaxedRound = roundToFive(priceTaxedRound);
			double priceTaxedOk = (priceTaxedRound / 100d);

			String priceTaxedString = String.valueOf(priceTaxedOk);
			priceTaxedString = zerFill(priceTaxedString);

			taxTotal += priceAndTax.get(productDao);
			priceTotal += priceTaxedOk;
			retString.add(productDao.getQuantity() + " " + productDao.getDescription() + ": " + priceTaxedString);

		}

		Double taxTotalTemp = taxTotal * 100;
		Long taxTotalRound = Math.round(taxTotalTemp);
		taxTotalRound = roundToFive(taxTotalRound);
		double taxTotalOk = 0d;
		if ((taxTotalRound % 5) != 0) {
			taxTotalOk = (taxTotalRound / 10d);
			taxTotalOk = Math.round(taxTotalOk);
			taxTotalOk = (taxTotalOk / 10d);
		} else {
			taxTotalOk = (taxTotalRound / 100d);
		}

		String taxTaxedString = String.valueOf(taxTotalOk);
		taxTaxedString = zerFill(taxTaxedString);
		retString.add("Sales Taxes: " + taxTaxedString);

		Double priceTotalTemp = (priceTotal * 100);
		Long priceTotalRound = Math.round(priceTotalTemp);
		double priceTotalOk = (priceTotalRound / 100d);

		String priceTotalOkString = String.valueOf(priceTotalOk);
		priceTotalOkString = zerFill(priceTotalOkString);
		retString.add("Total: " + priceTotalOkString);
		retString.add("\n");

		return retString;
	}

	private String zerFill(String priceTaxedString) {
		String[] splitted = priceTaxedString.split("\\.");
		if (splitted[1].length() == 1) {
			priceTaxedString = new String();
			priceTaxedString = splitted[0] + "." + splitted[1] + "0";
		}
		return priceTaxedString;

	}

	private Long roundToFive(double value) {

		int resto = (int) (value % 10);
		if (resto > 0 && resto < 5) {
			int valueToAdd = 5 - resto;
			value = value + valueToAdd;
		}

		return (long) value;
	}

}
