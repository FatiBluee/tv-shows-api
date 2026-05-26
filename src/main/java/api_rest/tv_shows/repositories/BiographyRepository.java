package api_rest.tv_shows.repositories;

import api_rest.tv_shows.models.Biography;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BiographyRepository extends JpaRepository<Biography, Integer> {
}
