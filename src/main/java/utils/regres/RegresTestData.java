package utils.regres;

import org.testng.annotations.DataProvider;

/**
 * Класс с тестовыми данными для сайта Regres
 *
 * @author Чаплушкин В.
 */
public class RegresTestData {

    /**
     * DataProvider для тестового метода testSuccessfulLogin
     *
     * @return данные для успешного логина на сайте Regres, а также ожидаемый ответ от сервера
     */
   @DataProvider(name = "getSuccessfulLoginValues")
   public static Object[][] getSuccessfulLoginValues() {
       return new Object[][] {
               {"eve.holt@reqres.in", "cityslicka", 200}
       };
   }

    /**
     * DataProvider для тестового метода testUnsuccessfulLogin
     *
     * @return данные для неуспешного логина на сайте Regres, а также ожидаемый ответ от сервера
     */
   @DataProvider(name = "getUnsuccessfulLoginValues")
    public static Object[][] getUnsuccessfulLoginValues() {
       return new Object[][] {
               {"peter@klaven", 400}
       };
   }
}
