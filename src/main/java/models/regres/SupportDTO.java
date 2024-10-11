package models.regres;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data-класс, хранящий вспомогательные данные на странице, полученные из ответа JSON
 *
 * @author Чаплушкин В.
 * @see PageColorsDTO
 * @see PageUsersDTO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupportDTO {
    private String url;
    private String text;
}
