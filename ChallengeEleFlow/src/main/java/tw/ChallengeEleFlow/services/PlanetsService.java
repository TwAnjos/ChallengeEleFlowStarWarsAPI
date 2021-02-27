package tw.ChallengeEleFlow.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import tw.ChallengeEleFlow.domain.Planets;
import tw.ChallengeEleFlow.repositories.PlanetsRepository;

@Service
public class PlanetsService {
	
	@Autowired
	private PlanetsRepository iPlanetsRepository;
	
	public Planets getPlanetsById(Integer planetId) {
		
		Optional<Planets> optional = iPlanetsRepository.findById(planetId);
		
		return optional.get();
	}
}
