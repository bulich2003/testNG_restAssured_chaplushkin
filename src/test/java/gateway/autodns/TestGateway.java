package gateway.autodns;

import org.testng.annotations.Test;
import utils.Properties;
import utils.gateway.autodns.GatewayTestData;
import utils.gateway.autodns.GatewayTestsProperties;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

/**
 * Тест-кейс API сервиса Gateway.autodns
 *
 * @author Чаплушкин В.
 */
public class TestGateway {

    /**
     * Тест, проверяющий количество тегов в ответе сервиса на соответствие заданному
     *
     * @param expectedAmountOfTags: ожидаемое количество двойных тегов
     * @see GatewayTestData
     * @see GatewayTestsProperties#urlToAutodns()
     */
    @Test(testName = "Задание 2.4",
            dataProvider = "getExpectedTagsAmount", dataProviderClass = GatewayTestData.class)
    public void checkAmountOfTags(int expectedAmountOfTags) {
        String xmlTreeInString = given()
                .when()
                .get(Properties.gatewayTestsProperties.urlToAutodns())
                .then()
                .extract().xmlPath().prettify();

        int amountOfTags =
                (xmlTreeInString.length() - xmlTreeInString.replaceAll("</", "").length()) / 2;

        assertEquals(amountOfTags, expectedAmountOfTags,
                "Текущее количество парных тегов в ответе '" + amountOfTags +
                        "' не равно ожидаемому '" + expectedAmountOfTags + "'");
    }
}
