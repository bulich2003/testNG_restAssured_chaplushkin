package models.regres;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Data-класс, хранящий данные о странице с пользователями, полученные из ответа JSON
 *
 * @author Чаплушкин В.
 * @see SupportDTO
 * @see UserDataDTO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageUsersDTO {
    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private List<UserDataDTO> data;
    private SupportDTO support;
}
