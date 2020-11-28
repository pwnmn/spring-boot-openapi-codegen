package com.github.pwnmn.client.petstore.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="${pet.name:pet}", url="${pet.url}")
public interface PetApiClient extends PetApi {
}
