package nl.blue4it.weather.service.controller

import nl.blue4it.weather.service.`interface`.WeatherService
import nl.blue4it.weather.service.domain.Forecast
import okhttp3.OkHttpClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@RestController
@RequestMapping("/weather/service")
class ForecastController {

    @GetMapping()
    fun getForecast(): ResponseEntity<Forecast?> {
        val httpClient = OkHttpClient.Builder()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        val service: WeatherService = retrofit.create(WeatherService::class.java)
        val response = service.getForecast("524901", "caf52f742044f6c5a5d0b62cf4043e01")

        return ResponseEntity.ok().body(response?.execute()?.body())
    }

    // iterate on countries and get NL Nijmegen

    // get forecast based on city

    // Micrometer implementation

}