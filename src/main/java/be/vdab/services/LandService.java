package be.vdab.services;

import java.math.BigDecimal;
import be.vdab.repositories.LandRepository;
import be.vdab.entities.Land;

public class LandService {
	private final LandRepository landRepository;

	public LandService(LandRepository landRepository) {
		this.landRepository = landRepository;
	}

	public BigDecimal findVerhoudingOppervlakteLandTovOppervlakteAlleLanden(String landcode) {
		Land land = landRepository.read(landcode);
		int oppervlakteAlleLanden = landRepository.findOppervlakteAlleLanden();
		return new BigDecimal(land.getOppervlakte()).divide(BigDecimal.valueOf(oppervlakteAlleLanden));
	}
}
