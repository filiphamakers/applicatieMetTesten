package be.vdab.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import be.vdab.entities.Land;
import be.vdab.repositories.LandRepository;

public class LandServiceTest {

	private LandRepository landRepository;
	private LandService landService;

	@Before
	public void before() {
		landRepository = mock(LandRepository.class);
		when(landRepository.findOppervlakteAlleLanden()).thenReturn(20); 
		when(landRepository.read("B")).thenReturn(new Land("B", 5)); 
		landService = new LandService(landRepository);
	}

	@Test
	public void findVerhoudingOppervlakteLandTovOppervlakteAlleLanden() {
		assertEquals(0, BigDecimal.valueOf(0.25)
				.compareTo(landService.findVerhoudingOppervlakteLandTovOppervlakteAlleLanden("B")));
		verify(landRepository).findOppervlakteAlleLanden(); 
		verify(landRepository).read("B");
	}

}
