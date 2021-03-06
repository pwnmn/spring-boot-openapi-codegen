package com.github.pwnmn.client.petstore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.token.grant.implicit.ImplicitResourceDetails;

@Configuration
@EnableConfigurationProperties
public class ClientConfiguration {

  @Value("${swaggerpetstoreopenapi30.security.apiKey.key:}")
  private String apiKeyKey;

  @Bean
  @ConditionalOnProperty(name = "swaggerpetstoreopenapi30.security.apiKey.key")
  public ApiKeyRequestInterceptor apiKeyRequestInterceptor() {
    return new ApiKeyRequestInterceptor("header", "api_key", this.apiKeyKey);
  }

  @Bean
  @ConditionalOnProperty("swaggerpetstoreopenapi30.security.petstoreAuth.client-id")
  public OAuth2FeignRequestInterceptor petstoreAuthRequestInterceptor(OAuth2ClientContext oAuth2ClientContext) {
    return new OAuth2FeignRequestInterceptor(oAuth2ClientContext, petstoreAuthResourceDetails());
  }

  @Bean
  @ConditionalOnProperty("swaggerpetstoreopenapi30.security.petstoreAuth.client-id")
  public OAuth2ClientContext oAuth2ClientContext() {
    return new DefaultOAuth2ClientContext();
  }

  @Bean
  @ConditionalOnProperty("swaggerpetstoreopenapi30.security.petstoreAuth.client-id")
  @ConfigurationProperties("swaggerpetstoreopenapi30.security.petstoreAuth")
  public ImplicitResourceDetails petstoreAuthResourceDetails() {
    ImplicitResourceDetails details = new ImplicitResourceDetails();
    details.setUserAuthorizationUri("https://petstore3.swagger.io/oauth/authorize");
    return details;
  }

}
