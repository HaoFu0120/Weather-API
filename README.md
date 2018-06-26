# Weather-API
A Spring boot weather application, sending request to openweathermap and showing reply at html.
Exporting weather data to excel and pdf is possible. In each request, weather datas are automatically written to mongodb, and at another page it shows history of requests to api and datas at database.
Uploading file to server is possible. Shows all uploaded files and downloading them is possible via html page by clicking.


## Getting Started



### Prerequisites

Browser is needed to use this software.
Must to be connected to internet in order to send request to Openweathermap Api. 


### Installing

No need to install. 

## Running the tests 


Go to localhost:8080;

http://localhost:8080/

Type a city name to "Enter city" textbox. For example london, or istanbul.

Web page will be redirected to http://localhost:8080/searchCity/london and datas will be shown as a table.

In this web page it is possible to export datas to excel or pdf, and by show database button, it is possible to see search and data history at mongodb embedded database.

In index.html page it is possible to upload files to server. By "Get All Files" button, all files could be downloaded.
By "Show Files" button all files that uploaded to server could be shown.
By "Weathers From Database" button all search and data history could be seen.


## Deployment



## Built With

* [Spring Boot](https://projects.spring.io/spring-boot/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
Openweathermap Api
Thymeleaf
Jstl
Google Gson
Apache Poi
ItextPdf
flapdoodle.embed.mongo


## Contributing


## Versioning

No versioning.

## Authors

* **Onur Tas** - *Initial work* - (https://github.com/Onur232)


## License

This project has no license.

## Acknowledgments


