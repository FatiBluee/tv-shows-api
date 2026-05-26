package api_rest.tv_shows.repositories;

import api_rest.tv_shows.models.Shows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ShowsRepositoryTest {
    @Autowired
    ShowsRepository showsRepository;

    @Test
    @DisplayName("Mostrar show con sus actores")
    public void getShowById(){
        Optional<Shows> showsOptional = showsRepository.findById(1);

        if (showsOptional.isPresent()){
            System.out.println(showsOptional.get());
        }
    }
}
