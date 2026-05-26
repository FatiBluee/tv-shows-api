package api_rest.tv_shows.repositories;

import api_rest.tv_shows.models.Shows;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowsRepository extends JpaRepository<Shows, Integer>{
}
