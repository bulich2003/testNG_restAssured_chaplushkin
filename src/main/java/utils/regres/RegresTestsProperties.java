package utils.regres;


import org.aeonbits.owner.Config;

/**
 * Интерфейс, содержащий путь к настройкам переменных для тестирования сайта Regres
 *
 * @author Чаплушкин В.
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:src/main/resources/tests.properties"})
public interface RegresTestsProperties extends Config {

    /**
     * GET-метод к URL ко второй странице с пользователями
     *
     * @return URL ко второй странице с пользователями
     */
    @Config.Key("url.regres.secondPage")
    String urlToSecondPage();

    /**
     * GET-метод к URL к странице логина
     *
     * @return URL к странице логина
     */
    @Config.Key("url.regres.login")
    String urlToLogin();

    /**
     * GET-метод к URL к странице с ресурсами
     *
     * @return URL к странице с ресурсами
     */
    @Config.Key("url.regres.resources")
    String urlToResources();

    /**
     * GET-метод к базовому URI
     *
     * @return базовый URI
     */
    @Config.Key("url.regres")
    String baseURI();
}
