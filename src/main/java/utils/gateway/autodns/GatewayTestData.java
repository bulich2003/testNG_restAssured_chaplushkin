package utils.gateway.autodns;

import org.testng.annotations.DataProvider;

/**
 * Класс с тестовыми данными для сайта Gateway.autodns
 *
 * @author Чаплушкин В.
 */
public class GatewayTestData {

    /**
     * DataProvider для тестового метода checkAmountOfTags
     *
     * @return ожидаемое количество двойных тегов в ответе
     */
    @DataProvider(name = "getExpectedTagsAmount")
    public static Object[][] getExpectedTagsAmount() {
        return new Object[][] {
                {15}
        };
    }
}
