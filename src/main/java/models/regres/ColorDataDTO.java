package models.regres;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data-класс, хранящий данные о цвете, полученные из ответа JSON
 *
 * @author Чаплушкин В.
 * @see PageColorsDTO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ColorDataDTO {
    private Integer id;
    private String name;
    private Integer year;
    private String color;
    private String pantone_value;
}
