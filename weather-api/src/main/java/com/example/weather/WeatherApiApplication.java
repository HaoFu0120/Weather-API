package com.example.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.repository.WeatherRepository;

@SpringBootApplication
/*
 * enable demezsen mongo repository class'ını bulamıyor. 
 */
@EnableMongoRepositories(basePackageClasses=WeatherRepository.class)
public class WeatherApiApplication {
	
	/*
	 * Login sayfası olarak bu projenin içindeki login.html i kullan.
	 * mongodb database'den getirme ekle.
	 * class'lar new ile değil hepsi component ile keşfedilsin.
	 */

	public static void main(String[] args) {
		SpringApplication.run(WeatherApiApplication.class, args);
	}
}
