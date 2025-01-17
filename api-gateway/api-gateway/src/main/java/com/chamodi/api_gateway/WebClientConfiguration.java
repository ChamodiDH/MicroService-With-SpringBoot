package com.chamodi.api_gateway;

// this file is added during the implementation of security.
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {

    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder(ReactiveClientRegistrationRepository clientRegistrations,
                                              ServerOAuth2AuthorizedClientRepository authorizedClients) {
        var oauth = new ServerOAuth2AuthorizedClientExchangeFilterFunction(clientRegistrations, authorizedClients);
        oauth.setDefaultClientRegistrationId("okta");
        return WebClient
                .builder()
                .filter(oauth);
    }
}

/*
*           issuer-uri: https://dev-10d0zago2suufdiw.us.auth0.com/
          audience: employee-mgt
* */