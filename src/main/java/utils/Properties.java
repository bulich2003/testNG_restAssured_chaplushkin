package utils;

import org.aeonbits.owner.ConfigFactory;
import utils.gateway.autodns.GatewayTestsProperties;
import utils.regres.RegresTestsProperties;

/**
 * Класс с инициализацией объектов классов, хранящих настройки
 *
 * @author Чаплушкин В.
 */
public class Properties {
    /**
     * Переменная, хранящая константы, необходимые для тестов сайта Regres
     */
    public static RegresTestsProperties regresTestsProperties =
            ConfigFactory.create(RegresTestsProperties.class);

    /**
     * Переменная, хранящая константы, необходимые для тестов сайта Gateway.autodns
     */
    public static GatewayTestsProperties gatewayTestsProperties =
            ConfigFactory.create(GatewayTestsProperties.class);
}
