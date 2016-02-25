package lastminute.application.costants;

public enum ProductType {

		CHOCOLATE("chocolate"),
		
		MUSICCD("music"),
		
		BOOK("book"),
		
		PERFUME("perfume"),
		
		HEADACHE_PILLS("headache")
		;
		
		private String value;
		
		
		private ProductType(String value){
			this.value = value;
		}
		
		public String getValue(){
			return value;
		}
}
