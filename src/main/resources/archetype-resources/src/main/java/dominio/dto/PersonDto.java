package ${package}.dominio.dto;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private Integer id;
    private String nombre;
    private String apellido;
    private String edad;
}