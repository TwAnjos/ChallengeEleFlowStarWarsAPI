package tw.ChallengeEleFlow.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tw.ChallengeEleFlow.domain.Planets;
import tw.ChallengeEleFlow.services.PlanetsService;

@RestController
@RequestMapping(value = "/planets")
public class PlanetsResource {
	
	@Autowired
	private PlanetsService planetsService;
	
	@RequestMapping(value = "/tw", method = RequestMethod.GET )
	public String getTw() {
		return "Thiago Waltrick Anjos";
	}

}
