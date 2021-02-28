package tw.ChallengeEleFlow.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sun.el.parser.ParseException;

import tw.ChallengeEleFlow.services.H2dbService;

@Configuration
@Profile("h2dbtest")
public class h2dbConfig {
	
	@Autowired
	private H2dbService h2dbConfig;

//instancia o servidor alocado na memoria apenas para fins de testes
	@Bean
	public boolean instantiateH2dbTest() throws ParseException {
		h2dbConfig.instantiateH2dbTest();
		return true;
	}
}
