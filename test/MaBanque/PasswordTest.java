package MaBanque;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import fr.ynov.function.PasswordHelper;

class PasswordTest {

	@Test
	void test8Chars() {
		assertEquals(false, PasswordHelper.verifyPassword("aku(Em"));
	}
	
	@Test
	void test1Chiffre() {
		assertEquals(false, PasswordHelper.verifyPassword("aku(Emeu#"));
	}
	
	@Test
	void test1Maj() {
		assertEquals(false, PasswordHelper.verifyPassword("ak3(ume8#"));
	}
	
	@Test
	void test1CharSpe() {
		assertEquals(false, PasswordHelper.verifyPassword("ak3uEme8u"));
	}
	
	@Test
	void testBonPassword() {
		assertEquals(true, PasswordHelper.verifyPassword("ak3(Eme8#"));
	}
}
