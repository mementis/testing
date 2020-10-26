package utils;

import java.lang.Math;

import page_objects.Account;
import page_objects.Address;
import page_objects.Phone;

public class TestUtils {

	public static String generateEmail() {

		int email = (int) Math.random() * 100;
		System.out.println(email);
		return String.format("troll%s@yahoo.com", email);

	}

	public static Account generateAccount() {

		Account account = new Account();
		account.setFirstName("Mara");
		account.setLastName("Popara");
		account.setPassword("kokoska");
		account.setAddress(generateAddress());
		account.setCity("Austin");
		account.setState("Texas");
		account.setZipCode(78702);
		account.setCountry("United States");
		account.setPhone(generatePhone());

		return account;

	}

	public static Address generateAddress() {

		Address address = new Address();
		address.setAddressName("Kerbey Ln");
		address.setPoBox(3003);
		address.setAliasAddress("homeaddress");

		return address;

	}

	public static Phone generatePhone() {

		Phone phone = new Phone();
		phone.setHome("2025550130");
		phone.setMobile("2025550130");

		return phone;

	}
}
