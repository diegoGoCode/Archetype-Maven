package  ${package}.persistencia.entities;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity {
    private Integer id;
    private String nombre;
    private String apellido;
    private String edad;
}