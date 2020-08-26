# Shiftracker
For workers that pull shifts. It could be helpful to track the work done during your shift and also have your roster in  a calendar


Set up

- Clone the repo

- Create a directory and file

    `mkdir ~/data && touch ~/data/shiftmonitor`

- edit application.properties.sample
Change the file name to application.properties
Change the H2 <username> and <password>

- Check that the java target in your system corresponds to what's in pom.xml

    `java --version #uses java 14`

- Install all mvn dependencies [if you don't have maven pull it from here: https://maven.apache.org/]

    `mvn install && mvn compile`

- Run the Spring application with maven

    `mvn exec:java -Dexec.mainClass=com.example.shiftmonitor.ShiftmonitorApplication`

### Api doc
#### Create Activity
- sample request: 
```
curl -X POST -H "Content-Type: application/json" -d '{"actionTaken": "Emergency", "status": "Not okay", "recommended": "Air the lab", "description": "The ammonia is heating beyond the normal temperature"}' http://localhost:8050/api/v1/activity
```

- sample responses:
1. "successful" 
2. "Please fill mandatory fields"
3. "unsuccessful"


- Mandatory fields
1. actionTaken //acceptable values: ["emergency", "customer call", "observation made", "job done"]
2. status //acceptable values: ["okay", "not okay"]
3. description
-Optoinal field
1. recommended

#### Show Activity
- sample request:

`curl http://localhost:8050/api/v1/activity/3`

- sample response: 

```
{
    "id":3,
    "description":"The ammonia was overheating",
    "status":"Not okay",
    "actionTaken":"Customer Call",
    "recommended":"Air the lab"
}
```
