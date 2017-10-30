package be.vdab.entities;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class RekeningTest {

	private Rekening rekening;

	@Before
	public void before() {
		rekening = new Rekening();
	}

	@Test
	public void hetSaldoVanEenNieuweRekeningIsNul() {
		assertEquals(0, BigDecimal.ZERO.compareTo(rekening.getSaldo()));
	}

	@Test
	public void hetSaldoNaEenEersteStortingIsHetBedragVanDieStorting() {
		BigDecimal bedrag = BigDecimal.valueOf(2.5);
		rekening.storten(bedrag);
		assertEquals(0, bedrag.compareTo(rekening.getSaldo()));
	}

	@Test
	public void hetSaldoNaTweeStortingenIsDeSomVanDeBedragenVanDieStortingen() {
		rekening.storten(BigDecimal.valueOf(2.5));
		rekening.storten(BigDecimal.valueOf(1.2));
		assertEquals(0, BigDecimal.valueOf(3.7).compareTo(rekening.getSaldo()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void hetBedragVanEenStortingMagNietNulZijn() {
		rekening.storten(BigDecimal.ZERO);
	}

	@Test(expected = IllegalArgumentException.class)
	public void hetBedragVanEenStortingMagNietNegatiefZijn() {
		rekening.storten(BigDecimal.valueOf(-1));
	}

	@Test(expected = NullPointerException.class)
	public void hetBedragVanEenStortingMagNietNullZijn() {
		rekening.storten(null);
	}

}
