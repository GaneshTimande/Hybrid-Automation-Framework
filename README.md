
FinalHybridFramework - Complete Selenium Grid POM framework

How to run:
1. Extract this project and open in Eclipse (Import -> Maven -> Existing Maven Projects).
2. Update src/test/resources/config.properties (hubURL, mail settings).
3. Start Grid: docker-compose up -d
4. Run tests: mvn clean test -DsuiteXmlFile=testng-parallel.xml
5. Reports in reports/ and will be emailed after the suite finishes.
