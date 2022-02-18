package one;

public class callingmethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Basemethods base = new Basemethods();
		String uid = "admin";
		String pwd = "master";
		
		String url = "http://orangehrm.qedgetech.com/webapp/login.php";
		
		base.openBrowser("chrome");
		base.launchERP(url);
		base.loginERP(uid, pwd);

		
	}

}
