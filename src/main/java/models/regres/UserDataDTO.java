package models.regres;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data-класс, хранящий данные о пользователях, полученные из ответа JSON
 *
 * @author Чаплушкин В.
 * @see PageUsersDTO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDataDTO {
    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
