package api_rest.tv_shows.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ActorUpdateNameDTO {
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 20)
    private String name;
}
