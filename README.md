# Weather-Info-For-a-given-pincode
Finds the latitude longitude and retreives todays weather status using openweathermap api.

<h3>Rest Endpoints:</h3>

URI to get pin wise data: **localhost:8080/api?pin=110001** (GetMapping)<br/>

In problem it is stated to have a date as a request param but with **openweather api free tier** didn't supported history data so I have made date optional and uses LocalDate.now() to save data.

URI with date associated: **localhost:8080/api?pin=110001&date=2023-03-05**<br/>

I have used **geolocation api** to get the pincode latitude and longitude then made an api call to get todays weather and persisted that data so the next call we get persisted data, handled the exception in case of a wrong pin being given it throws Exception which is handled by a global exception handler.

URI to get all pin wise data: **localhost:8080/api/110001** gives list of all weather info with respect to the pincode.
<hr/>

Below are some successful tested endpoints screenshot:


![Screenshot (468)](https://user-images.githubusercontent.com/96864350/222978848-c9783fb4-23d0-4a97-abc2-0de5f39e385a.png)

Incase of wrong info:
![Screenshot (469)](https://user-images.githubusercontent.com/96864350/222978929-332d0e37-cf01-4bfc-9ba3-1a7c1eb53faa.png)

The other endpoint:
![Screenshot (470)](https://user-images.githubusercontent.com/96864350/222978964-4cf24160-433b-4d96-8675-9caaabe2889d.png)
