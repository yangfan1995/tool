package com.pawn.weather;

import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@RestController
public class WeatherController {
    public static final String CUR_WEATHER_URL = "https://devapi.qweather.com/v7/weather";

    @GetMapping(value = "customer/getWeather")
    public void getWeather() {
        //创建webclient
        WebClient webClient = WebClient
                .builder()
                .baseUrl(CUR_WEATHER_URL)
                .build();

        //构造请求参数
        //定义query参数
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("key", "fc83365944d74619be41b2cf9c1af8c8");
        params.add("location", "101210106");


        String uriStr = UriComponentsBuilder.fromUriString("/now")
                .queryParams(params)
                .toUriString();
        String jsonString = webClient.get()
                .uri(uriStr)
                .acceptCharset(StandardCharsets.UTF_8)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(jsonString);

    }
}
























