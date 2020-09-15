package wiremock.mock;

import org.junit.After;
import org.junit.Before;

import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

// To Start Wiremock in local with http @8089 and https @ 8043
public class WireMockHook {
    public static final int WIREMOCK_PORT_NUMBER = 8089;
    public static final int WIREMOCK_SECURE_PORT_NUMBER = 8043;
    public static final String WIREMOCK_HOST = "localhost";
    private WireMockServer wireMockServer;

    @Before
    public void startWireMock() {
        wireMockServer = new WireMockServer(wireMockConfig().httpsPort(WIREMOCK_SECURE_PORT_NUMBER).port(WIREMOCK_PORT_NUMBER));
        wireMockServer.start();
        configureFor(WIREMOCK_HOST, WIREMOCK_PORT_NUMBER);
    }

    @After
    public void stopWireMock() {
        wireMockServer.stop();
    }
}
