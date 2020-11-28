package com.github.pwnmn.client.petstore.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="${store.name:store}", url="${store.url}")
public interface StoreApiClient extends StoreApi {
}
