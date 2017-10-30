package be.vdab.entities;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;

public class RekeningTest {

	@Test
	public void hetSaldoVanEenNieuweRekeningIsNul() {
		Rekening rekening = new Rekening();
		assertEquals(0, BigDecimal.ZERO.compareTo(rekening.getSaldo()));
	}

	@Test
	public void hetSaldoNaEenEersteStortingIsHetBedragVanDieStorting() {
		Rekening rekening = new Rekening();
		BigDecimal bedrag = BigDecimal.valueOf(2.5);
		rekening.storten(bedrag);
		assertEquals(0, bedrag.compareTo(rekening.getSaldo()));
	}

	@Test
	public void hetSaldoNaTweeStortingenIsDeSomVanDeBedragenVanDieStortingen() {
		Rekening rekening = new Rekening();
		rekening.storten(BigDecimal.valueOf(2.5));
		rekening.storten(BigDecimal.valueOf(1.2));
		assertEquals(0, BigDecimal.valueOf(3.7).compareTo(rekening.getSaldo()));
	}

}
