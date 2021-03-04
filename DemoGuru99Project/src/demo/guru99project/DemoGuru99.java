package demo.guru99project;

public class DemoGuru99 {

	public static void main(String[] args) {

		Guru99 wc = new Guru99();
		/*
		 * wc.invokeBrowser(); //intiates chrome instance and deletes all cookies
		 * wc.getTitle(); wc.navigateCommands(); wc.closeBrowser();
		 */
		wc.invokeBrowser();
		wc.getTitle();
		wc.login("mngr310484","hYrYjuz");
		wc.addingNewCustomer("Sahil", "HL 135 Phase 2 Mohali", "Sahil@765");
		String customerID = wc.getCustomerId();
		System.out.println("Customer Id "+customerID);
		wc.addNewAccount(customerID);
		String AccountID = wc.getAccountId();
		System.out.println("Acco Id "+AccountID);
		//wc.closeBrowser();
	}

}
