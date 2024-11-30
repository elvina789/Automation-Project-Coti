package com.test.hooks;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class MockAPIHook {

    private static WireMockServer wireMockServer;
    private static final String VALID_TOKEN = "valid-token";
    private static final String VALID_USER = "testuser";
    private static final String VALID_PASSWORD = "password123";

    @Before("@MockAPI")
    public void startMockAPI() {
        if (wireMockServer == null) {
            wireMockServer = new WireMockServer(options().port(8080));
            wireMockServer.start();
            WireMock.configureFor("localhost", wireMockServer.port());
            System.out.println("MockAPI server started at: http://localhost:8080");

            // Set up the login API
            wireMockServer.stubFor(post(urlEqualTo("/api/login"))
                    .withRequestBody(matchingJsonPath("$.username", equalTo(VALID_USER)))
                    .withRequestBody(matchingJsonPath("$.password", equalTo(VALID_PASSWORD)))
                    .willReturn(aResponse()
                            .withHeader("Content-Type", "application/json")
                            .withBody("{\"token\": \"" + VALID_TOKEN + "\"}")
                            .withStatus(200)));

            // Set up the get all products API
            wireMockServer.stubFor(get(urlEqualTo("/api/products"))
                    .withHeader("Authorization", equalTo(VALID_TOKEN))
                    .willReturn(aResponse()
                            .withHeader("Content-Type", "application/json")
                            .withBody("[{\"id\": 1, \"name\": \"Product A\"}, {\"id\": 2, \"name\": \"Product B\"}]")
                            .withStatus(200)));
        }
    }

    @After("@MockAPI")
    public void stopMockAPI() {
        if (wireMockServer != null && wireMockServer.isRunning()) {
            wireMockServer.stop();
            wireMockServer = null;
            System.out.println("MockAPI server stopped.");
        }
    }

    public static String getBaseUrl() {
        return "http://localhost:8080";
    }
}
