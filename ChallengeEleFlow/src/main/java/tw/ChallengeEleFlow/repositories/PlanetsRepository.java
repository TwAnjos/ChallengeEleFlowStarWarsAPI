package tw.ChallengeEleFlow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.ChallengeEleFlow.domain.Planets;

@Repository
public interface PlanetsRepository extends JpaRepository<Planets, Integer> {

}
