package MaBanque;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import fr.ynov.function.Password;

class PasswordTest {

	@Test
	void test8Chars() {
		assertEquals(false, Password.verifyPassword("aku(Em"));
	}
	
	@Test
	void test1Chiffre() {
		assertEquals(false, Password.verifyPassword("aku(Emeu#"));
	}
	
	@Test
	void test1Maj() {
		assertEquals(false, Password.verifyPassword("ak3(ume8#"));
	}
	
	@Test
	void test1CharSpe() {
		assertEquals(false, Password.verifyPassword("ak3uEme8u"));
	}
	
	@Test
	void testBonPassword() {
		assertEquals(true, Password.verifyPassword("ak3(Eme8#"));
	}
}
