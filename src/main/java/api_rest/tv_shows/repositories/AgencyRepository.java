package api_rest.tv_shows.repositories;

import api_rest.tv_shows.models.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepository extends JpaRepository<Agency, Integer> {
}
