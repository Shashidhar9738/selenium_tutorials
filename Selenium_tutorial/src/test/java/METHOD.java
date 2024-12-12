
public class METHOD {

	@SuppressWarnings({ "static-access", "unused" })
	public static void main(String[] args) {
		methods_with_different_classes D1 = new methods_with_different_classes();
		String name = D1.getuserdata();
		
		METHOD D2= new METHOD();
		D2.getdata();
		getdata1();
		METHOD D3= new METHOD();
		D3.getdata2();
	}
	public static    String getdata() {

		System.out.println("The values are coming the same class with out string values ");
		return "The return values sugan";

	}

	public static   String getdata1() {
		
		String name = METHOD.getdata();
		System.out.println(name +"    SHASHI   ");
		System.out.println("The values are coming the same class uiuiuiu");
		return "The return values";

	}

	public void  getdata2() {

		System.out.println("The values are coming the same class");
		

	}
}
