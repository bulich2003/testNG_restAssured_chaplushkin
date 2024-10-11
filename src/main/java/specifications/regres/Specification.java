package specifications.regres;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utils.Properties;
import utils.regres.RegresTestsProperties;

/**
 * Класс со спецификациями для запросов/ответов сайта Regres
 *
 * @author Чаплушкин В.
 */
public class Specification {

    /**
     * Метод сборки спецификации запроса
     *
     * @return спецификацию запроса, в которой установлен базовый URI сайта Regres
     * @see RegresTestsProperties#baseURI()
     */
    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(Properties.regresTestsProperties.baseURI())
                .build();
    }

    /**
     * Метод, устанавливающий спецификацию
     *
     * @param requestSpecification: спецификация запроса, устанавливающая базовый URI
     */
    public static void installSpecification(RequestSpecification requestSpecification) {
        RestAssured.requestSpecification = requestSpecification;
    }

    /**
     * Метод, удаляющий спецификацию
     */
    public static void deleteSpecification() {
        RestAssured.requestSpecification = null;
    }
}
