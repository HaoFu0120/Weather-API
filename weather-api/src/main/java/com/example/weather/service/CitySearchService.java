package com.example.weather.service;

import org.springframework.stereotype.Service;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.example.weather.domain.CityWeather;
import com.example.weather.domain.Coordinates;
import com.example.weather.domain.MainInfo;
import com.example.weather.domain.Place;
import com.example.weather.domain.Weather;
import com.example.weather.domain.Wind;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Service
public class CitySearchService {
	
	private CityWeather cityWeather;
	private JSONObject jsonObject;

	public CityWeather search(String city) {
		cityWeather = getCityInformation(city);
		return cityWeather;
	}

	private CityWeather getCityInformation(String city) {
		cityWeather=new CityWeather();
		initializeCityWeather();
		Client client = Client.create();

//		WebResource webResource = client.resource("https://jsonplaceholder.typicode.com/albums");
		//yukardaki adres sample json çıktısı veriyor.
		
		String endpointAddress = "https://api.openweathermap.org/data/2.5/weather?q=" + city;
		String key = "a9413a5d111ce43441f6a5213218162a";
		endpointAddress+="&appid="+key;
		//  https://api.openweathermap.org/data/2.5/weather?q=London&appid=a9413a5d111ce43441f6a5213218162a
		System.out.println(endpointAddress);
		
		WebResource webResource = client.resource(endpointAddress);

		//siteden bilgi response olarak alındı.
		ClientResponse response = webResource.accept("application/json")
                   .get(ClientResponse.class);

		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}
		System.out.println("Output from Server .... \n");
		//string'e çevrildi.
		String output = response.getEntity(String.class);
		MediaType type = response.getType();
//		System.out.println("type:"+type);
		System.out.println(output);
		
		//jsonObject'e çevrildi.
		try {
			jsonObject=new JSONObject(output);
			
//			String object = jsonObject.getString("data");
			//jsonObject'in içinde data isminde bir field var. json olarak alındı.
//			JSONObject jsonObject2 = jsonObject.getJSONObject("data");
			
			//data'daki field'lar parse ediliyor ve object field'larına set ediliyor.
			
			//base field
//			JSONObject jsonObject2 = jsonObject.getJSONObject("base");
//			System.out.println(jsonObject2);	
			cityWeather.setBase(jsonObject.getString("base"));
	
			//coord adında ana jsonobject'in içinde bir jsonobject var. onun lat field'ını al.
			cityWeather.getCoordinates().setLat(jsonObject.getJSONObject("coord").getString("lat"));
			
			//coord adında ana jsonobject'in içinde bir jsonobject var. onun lon field'ını al.
			cityWeather.getCoordinates().setLongitude(jsonObject.getJSONObject("coord").getString("lon"));
			
			//main içindeki field'lar alınıyor ve set ediliyor.
			cityWeather.getMainInfo().setHumidity(Integer.parseInt(jsonObject.getJSONObject("main").getString("humidity")));
			cityWeather.getMainInfo().setPressure(Float.parseFloat(jsonObject.getJSONObject("main").getString("pressure")));
			cityWeather.getMainInfo().setTemp(Float.parseFloat(jsonObject.getJSONObject("main").getString("temp")));
			cityWeather.getMainInfo().setTemp_max(Float.parseFloat(jsonObject.getJSONObject("main").getString("temp_max")));
			cityWeather.getMainInfo().setTemp_min(Float.parseFloat(jsonObject.getJSONObject("main").getString("temp_min")));
			
			//sys içinden country alınıyor.
			cityWeather.getPlace().setCountry(jsonObject.getJSONObject("sys").getString("country"));
			
			//name field
			cityWeather.getPlace().setCity(jsonObject.getString("name"));
			
			//visibility
			//bir json elemanı yoksa patlamasın diye, böyle bir key var mı bakılır. eğer varsa metot çalışsın.
			//bütün key'lere koymak lazım.
			if (jsonObject.has("visibility")) {
				cityWeather.setVisibility(Integer.parseInt(jsonObject.getString("visibility")));
			}
			
			
			
			//weather bir jsonobject değil bir jsonarray o yüzden getJSONObject("weather") ile alınamaz.
			JSONArray jsonArray = jsonObject.getJSONArray("weather");
			for (int i = 0; i < jsonArray.length(); i++) {
//				System.out.println(i+": "+ jsonArray.get(0));
			}
			
			JSONObject weatherObject = (JSONObject) jsonObject.getJSONArray("weather").get(0);
			//weather içinden main 
//			cityWeather.getWeather().setMain(jsonObject.getJSONObject("weather").getString("main"));
			cityWeather.getWeather().setMain(weatherObject.getString("main"));
			
			
			//weather içinden description 
//			cityWeather.getWeather().setDescription(jsonObject.getJSONObject("weather").getString("description"));
			cityWeather.getWeather().setDescription(weatherObject.getString("description"));
			
			
			//weather içinden icon 
//			cityWeather.getWeather().setIcon(jsonObject.getJSONObject("weather").getString("icon"));
//			cityWeather.getWeather().setMain(jsonObject.getString("weather"));
			cityWeather.getWeather().setIcon(weatherObject.getString("icon"));
			
			
			//wind içinden speed
			cityWeather.getWind().setSpeed(Float.parseFloat(jsonObject.getJSONObject("wind").getString("speed")));
			
			//wind içinden deg. bu field kaldırmışlar.
//			cityWeather.getWind().setDeg(Integer.parseInt(jsonObject.getJSONObject("wind").getString("deg")));
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return cityWeather;
		
	}

	private void initializeCityWeather() {
		cityWeather.setCoordinates(new Coordinates());
		cityWeather.setMainInfo(new MainInfo());
		cityWeather.setPlace(new Place());
		cityWeather.setWeather(new Weather());
		cityWeather.setWind(new Wind());
	}
	

}
