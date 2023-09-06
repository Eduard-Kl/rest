package hr.assignment.rest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class RestApplicationTests {

	@Test
	void exchangeRateTest() {

		BigDecimal eur = BigDecimal.TEN;
		double usd = ExchangeRate.convertToUSD(eur).floatValue();

		// Exchange rate changes daily
		assert usd > 10.0;
		assert usd < 11.0;

		assert ExchangeRate.convertToUSD(BigDecimal.ZERO).intValue() == 0;
	}
}
