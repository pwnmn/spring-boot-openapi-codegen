package com.github.pwnmn.client.petstore.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="${user.name:user}", url="${user.url}")
public interface UserApiClient extends UserApi {
}
