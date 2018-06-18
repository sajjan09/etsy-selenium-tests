# etsy-selenium-tests
etsy selenium tests

Author: Shobha Sajjan

This project is to run the Selenium tests for the Etsy website on Firefox browser. 

# Steps to run
> Download the geckodriver.exe file and edit the location of the file in com.etsy.tests.TestBaseSetup.initializeTestBaseSetup() method
(This exe file has been copied to /etsy-selenium/src/docs/geckodriver-v0.20.1-win64.zip folder for your reference. 
> Unzip to your local folder and edit the location in the above method)

> Close all the firefox browser instances before you run the test

> Run: mvn clean install from the project root folder (where pom.xml is present).


# Original Instructions
Selenium Web driver and Java. (Optional Cucumber)

- Open etsy.com

- Search for sports shoes

- Select one of the suggested options while you type 

- On search page sort by price 

- print the prices of top 10 items.

Use necessary assumption. Recommended to use some abstraction techniques like Page Objects.



