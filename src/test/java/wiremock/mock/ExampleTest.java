package wiremock.mock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class ExampleTest {
    //public static final int WIREMOCK_PORT_NUMBER = 8089;
    //public static final int WIREMOCK_SECURE_PORT_NUMBER = 8043;
    public static final String WIREMOCK_HOST = "ss-wiremock.herokuapp.com";

	@Test
	public void exampleTest() {
		
		//WireMockServer wireMockServer = new WireMockServer(8080);
		//WireMockServer wireMockServer = new WireMockServer(wireMockConfig().httpsPort(WIREMOCK_SECURE_PORT_NUMBER).port(WIREMOCK_PORT_NUMBER));
		//WireMockServer wireMockServer = new WireMockServer(8081);
		//wireMockServer.start();
        configureFor(WIREMOCK_HOST, 80);
        //configureFor("ss-wiremock.herokuapp.com", 26351);
		//wireMockServer.start();
		
/*		stubFor(get(urlEqualTo("/some/thing"))
	            .willReturn(aResponse()
	                .withHeader("Content-Type", "text/plain")
	                .withBody("Hello world1!")));*/
		
/*		stubFor(get(urlEqualTo("/v1/employees"))
	            .willReturn(aResponse().proxiedFrom("http://dummy.restapiexample.com/api")
	                ));*/
        
/*		final Response theResponse = RestAssured
	            .given()
	            .relaxedHTTPSValidation()
	            //.keyStore(CLIENT_KEYSTORE_PATH, CLIENT_KEYSTORE_PASSWORD)
	            .contentType("text/plain")
	            .accept(ContentType.TEXT)
	            .when()
	            .get("https://ss-wiremock.herokuapp.com/api/v1/employees");
	        theResponse
	            .then()
	            .statusCode(is(200))
	            .contentType(ContentType.TEXT);*/
		
		final Response theResponse = RestAssured
	            .given()
	            .relaxedHTTPSValidation()
	            //.keyStore(CLIENT_KEYSTORE_PATH, CLIENT_KEYSTORE_PASSWORD)
	            .contentType("text/plain")
	            .accept(ContentType.TEXT)
	            .when()
	            .get("https://ss-wiremock.herokuapp.com/some/thing");
	        theResponse
	            .then()
	            .statusCode(is(200))
	            .contentType(ContentType.TEXT);

		//assertThat(200, is(200));
	}
	
}
