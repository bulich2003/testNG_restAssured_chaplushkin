package regres;

import models.regres.*;
import org.testng.annotations.Test;
import utils.Properties;
import utils.regres.RegresTestData;
import utils.regres.RegresTestsProperties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static specifications.regres.Specification.*;

/**
 * Тест-кейс API сайта Regres
 *
 * @author Чаплушкин В.
 * @see specifications.regres.Specification
 */
public class TestRegres {

    /**
     * Тест, проверяющий названия файлов аватаров на уникальность
     * В случае неуспеха, выводит список повторяющихся названий файлов
     * @see PageUsersDTO
     * @see UserDataDTO
     * @see RegresTestsProperties#urlToSecondPage()
     */
    @Test(testName = "Задание 2.1")
    public void checkUniqueOfAvatarsFileNames() {
        installSpecification(requestSpecification());

        PageUsersDTO pageUsersDTO = given()
                .when()
                .get(Properties.regresTestsProperties.urlToSecondPage())
                .then()
                .log().body()
                .extract().body().as(PageUsersDTO.class);

        deleteSpecification();

        List<UserDataDTO> data = pageUsersDTO.getData();
        List<String> namesOfAvatarFile = new ArrayList<>();
        for (UserDataDTO userDataDTO : data) {
            namesOfAvatarFile.add(userDataDTO.getAvatar());
        }

        boolean isAllUniqueAvatarsFileName = true;
        List<String> nonUniqueAvatarFileNames = new ArrayList<>();

        for (String avatarFileName : namesOfAvatarFile) {
            if (Collections.frequency(namesOfAvatarFile, avatarFileName) > 1) {
                isAllUniqueAvatarsFileName = false;
                if (!nonUniqueAvatarFileNames.contains(avatarFileName))
                    nonUniqueAvatarFileNames.add(avatarFileName);
            }
        }
        assertTrue(isAllUniqueAvatarsFileName,
                "Не все имена файлов аватаров пользователей уникальны." +
                "\nПовторяющиеся названия файлов: " + nonUniqueAvatarFileNames);
    }

    /**
     * Тест, проверяющий корректность работы системы входа на сайт при верных данных для входа
     *
     * @param email: email для успешного логина на сайте
     * @param password: пароль для успешного логина на сайте
     * @param expectedStatusCode: ожидаемый статус-код ответа на запрос
     * @see UserLoginDTO
     * @see RegresTestData#getSuccessfulLoginValues()
     * @see RegresTestsProperties#urlToLogin()
     */
    @Test(testName = "Задание 2.2: Login - Successful",
    dataProvider = "getSuccessfulLoginValues", dataProviderClass = RegresTestData.class)
    public void testSuccessfulLogin(String email, String password, int expectedStatusCode) {
        installSpecification(requestSpecification());

        int status = given()
                .body(new UserLoginDTO(email, password))
                .contentType("application/json")
                .when()
                .post(Properties.regresTestsProperties.urlToLogin())
                .then()
                .log().body()
                .extract().statusCode();

        deleteSpecification();

        assertEquals(status, expectedStatusCode,
                "Операция авторизации завершилась с кодом: " + status +
                        ". Ожидаемый статус: " + expectedStatusCode);
    }

    /**
     * Тест, проверяющий корректность работы системы входа на сайт
     * при отсутствии пароля при отправке данных на сервер
     *
     * @param email: email для логина на сайте
     * @param expectedStatusCode: ожидаемый статус-код ответа на запрос
     * @see UserLoginDTO
     * @see RegresTestData#getUnsuccessfulLoginValues()
     * @see RegresTestsProperties#urlToLogin()
     */
    @Test(testName = "Задание 2.2: Login - Unsuccessful",
    dataProvider = "getUnsuccessfulLoginValues", dataProviderClass = RegresTestData.class)
    public void testUnsuccessfulLogin(String email, int expectedStatusCode) {
        installSpecification(requestSpecification());

        int status = given()
                .body(new UserLoginDTO(email, null))
                .contentType("application/json")
                .when()
                .post(Properties.regresTestsProperties.urlToLogin())
                .then()
                .log().body()
                .extract().statusCode();

        deleteSpecification();

        assertEquals(status, expectedStatusCode,
                "Операция авторизации завершилась с кодом: " + status +
                        ". Ожидаемый статус: " + expectedStatusCode);
    }

    /**
     * Тест, проверяющий, что данные в блоке data в ответе сервера отсортированы по годам.
     * В тестовом методе учитывается сортировка в обе стороны при помощи переменной isAscending
     *
     * @see PageColorsDTO
     * @see ColorDataDTO
     * @see RegresTestsProperties#urlToResources()
     */
    @Test(testName = "Задание 2.3")
    public void checkYearsInDataIsSorting() {
        installSpecification(requestSpecification());

        PageColorsDTO pageColorsDTO = given()
                .when()
                .get(Properties.regresTestsProperties.urlToResources())
                .then()
                .log().body()
                .extract().body().as(PageColorsDTO.class);

        deleteSpecification();

        List<ColorDataDTO> data = pageColorsDTO.getData();
        boolean isSorted = true;
        boolean isAscending = true;

        if (data.size() > 1)
            if (data.get(0).getYear() > data.get(1).getYear()) isAscending = false;

        for (int i = 0; i < data.size() - 1; i++) {
            if (isAscending && data.get(i).getYear() > data.get(i + 1).getYear() ||
                    !isAscending && data.get(i).getYear() < data.get(i + 1).getYear()) {
                isSorted = false;
                break;
            }
        }

        assertTrue(isSorted,
                "Запрос GET к " + Properties.regresTestsProperties.urlToResources() +
                        " возвращает данные, не отсортированные по годам");
    }
}
