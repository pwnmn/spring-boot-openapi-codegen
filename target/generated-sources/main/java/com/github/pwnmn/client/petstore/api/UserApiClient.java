package com.github.pwnmn.client.petstore.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.github.pwnmn.client.petstore.config.ClientConfiguration;

@FeignClient(name="${user.name:user}", url="${user.url:http://localhost/api/v3}", configuration = ClientConfiguration.class)
public interface UserApiClient extends UserApi {
}
