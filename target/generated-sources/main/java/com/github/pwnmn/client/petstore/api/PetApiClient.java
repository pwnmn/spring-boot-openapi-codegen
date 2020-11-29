package com.github.pwnmn.client.petstore.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.github.pwnmn.client.petstore.config.ClientConfiguration;

@FeignClient(name="${pet.name:pet}", url="${pet.url:http://localhost/api/v3}", configuration = ClientConfiguration.class)
public interface PetApiClient extends PetApi {
}
