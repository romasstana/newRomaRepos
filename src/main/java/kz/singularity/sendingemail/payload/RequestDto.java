package kz.singularity.sendingemail.payload;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestDto {
    @Size(min = 3, max = 8)
    private String firstName;
    @Size(min = 3, max = 8)
    private String lastName;
    private String email;
    private String password;
}
