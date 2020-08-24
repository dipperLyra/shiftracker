# shiftracker
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
