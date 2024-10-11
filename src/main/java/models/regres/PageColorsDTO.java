package models.regres;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Data-класс, хранящий данные о странице с цветами, полученные из ответа JSON
 *
 * @author Чаплушкин В.
 * @see SupportDTO
 * @see ColorDataDTO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageColorsDTO {
    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private List<ColorDataDTO> data;
    private SupportDTO support;
}
