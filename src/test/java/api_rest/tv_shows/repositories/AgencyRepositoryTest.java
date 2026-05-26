package api_rest.tv_shows.repositories;

import api_rest.tv_shows.models.Agency;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class AgencyRepositoryTest {

    @Autowired
    AgencyRepository agencyRepository;

    @Test
    @DisplayName("Leer Agency por id")
    public void getAgency(){
        Optional<Agency> agencyOptional = agencyRepository.findById(1);

        if (agencyOptional.isPresent()){
            System.out.println(agencyOptional.get());
        }
    }
}

