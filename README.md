1. The Project is spring boot application and uses spring security to authenticate user based on the Jwt token generated out of the user creds and Secret key.
2. Uses Restcontroller components to Create Rest end point 
Rest end point
1. http://localhost:8080/forecast/summary?locationName=Berlin 
returns the summary based on location
2. http://localhost:8080/forecast/summary/hourly?locationName=Berlin 
return the hourly summary for a location 
