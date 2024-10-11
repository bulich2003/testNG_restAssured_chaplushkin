package utils.gateway.autodns;

import org.aeonbits.owner.Config;

/**
 * Интерфейс, содержащий путь к настройкам переменных для тестирования сайта Gateway.autodns
 *
 * @author Чаплушкин В.
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:src/main/resources/tests.properties"})
public interface GatewayTestsProperties extends Config {
    /**
     * GET-метод к URL к странице с ошибкой ?
     *
     * @return URL к странице с ошибкой
     */
    @Config.Key("url.gateway.autodns.com")
    String urlToAutodns();
}
