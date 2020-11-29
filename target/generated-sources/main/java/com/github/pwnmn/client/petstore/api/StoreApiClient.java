package com.github.pwnmn.client.petstore.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.github.pwnmn.client.petstore.config.ClientConfiguration;

@FeignClient(name="${store.name:store}", url="${store.url:http://localhost/api/v3}", configuration = ClientConfiguration.class)
public interface StoreApiClient extends StoreApi {
}
