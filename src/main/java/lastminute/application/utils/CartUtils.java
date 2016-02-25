package lastminute.application.utils;

import java.util.ArrayList;
import java.util.List;



import lastminute.application.costants.ProductType;
import lastminute.application.dao.ProductDao;

public class CartUtils {

	
	public List<ProductDao> getCart1(){
		
		ProductDao book = new ProductDao();
		book.setDescription("book at");
		book.setPrice(12.49);
		book.setImported(false);
		book.setQuantity(1);
		book.setType(ProductType.BOOK.getValue());
		book.setUseTax(false);
		
		ProductDao musicCd = new ProductDao();
		musicCd.setDescription("music CD at");
		musicCd.setPrice(14.99);
		musicCd.setImported(false);
		musicCd.setQuantity(1);
		musicCd.setType(ProductType.MUSICCD.getValue());
		musicCd.setUseTax(true);
		
		ProductDao chocolate = new ProductDao();
		chocolate.setDescription("chocolate bar at");
		chocolate.setPrice(0.85);
		chocolate.setImported(false);
		chocolate.setQuantity(1);
		chocolate.setType(ProductType.CHOCOLATE.getValue());
		chocolate.setUseTax(false);
		
		List<ProductDao> retVal = new ArrayList<ProductDao>();
		retVal.add(book);
		retVal.add(musicCd);
		retVal.add(chocolate);
		
		return retVal;
	}
	
	public List<ProductDao> getCart2(){
		
		ProductDao chocolate = new ProductDao();
		chocolate.setDescription("imported box of chocolates at");
		chocolate.setPrice(10.00);
		chocolate.setImported(true);
		chocolate.setQuantity(1);
		chocolate.setType(ProductType.CHOCOLATE.getValue());
		chocolate.setUseTax(false);
		
		ProductDao perfume = new ProductDao();
		perfume.setDescription("imported bottle of perfume at");
		perfume.setPrice(47.50);
		perfume.setImported(true);
		perfume.setQuantity(1);
		perfume.setType(ProductType.PERFUME.getValue());
		perfume.setUseTax(true);
		
		List<ProductDao> retVal = new ArrayList<ProductDao>();
		retVal.add(chocolate);
		retVal.add(perfume);
		
		return retVal;
	}
	
	public List<ProductDao> getCart3(){
		
		ProductDao impPerfume = new ProductDao();
		impPerfume.setDescription("imported bottle of perfume at");
		impPerfume.setPrice(27.99);
		impPerfume.setImported(true);
		impPerfume.setQuantity(1);
		impPerfume.setType(ProductType.PERFUME.getValue());
		impPerfume.setUseTax(true);
		
		ProductDao perfume = new ProductDao();
		perfume.setDescription("bottle of perfume at");
		perfume.setPrice(18.99);
		perfume.setImported(false);
		perfume.setQuantity(1);
		perfume.setType(ProductType.PERFUME.getValue());
		perfume.setUseTax(true);
		
		ProductDao headachePills = new ProductDao();
		headachePills.setDescription("packet of headache pills at");
		headachePills.setPrice(9.75);
		headachePills.setImported(false);
		headachePills.setQuantity(1);
		headachePills.setType(ProductType.PERFUME.getValue());
		headachePills.setUseTax(false);
		
		ProductDao chocolate = new ProductDao();
		chocolate.setDescription("box of imported chocolates at");
		chocolate.setPrice(11.25);
		chocolate.setImported(true);
		chocolate.setQuantity(1);
		chocolate.setType(ProductType.CHOCOLATE.getValue());
		chocolate.setUseTax(false);
		
		List<ProductDao> retVal = new ArrayList<ProductDao>();
		retVal.add(impPerfume);
		retVal.add(perfume);
		retVal.add(headachePills);
		retVal.add(chocolate);
				
		return retVal;
	}
	
}
