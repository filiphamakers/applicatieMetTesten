package be.vdab.util;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Test;
import be.vdab.util.Converter;

public class ConverterTest {
	@Test
	public void eenInchIs2Punt54Centimeters() {
		Converter converter = new Converter();
		assertEquals(0, BigDecimal.valueOf(2.54).compareTo(converter.inchesNaarCentimeters(BigDecimal.ONE)));
	}

	@Test
	public void tweehonderdInchesIsVijfhonderdenachtCentimeters() {
		Converter converter = new Converter();
		assertEquals(0, BigDecimal.valueOf(508).compareTo(converter.inchesNaarCentimeters(BigDecimal.valueOf(200))));
	}
}
