# The Oppenheimer Project- Test Automation
 This is an sample Test automating project which includes UI and API automation using Selenium for efficient testing and quality assurance.  

## Oppenheimer Project
The Oppenheimer Project is a software system designed to support the taxation relief initiative for working class heroes in the City of Carson. This system allows clerks to populate a list of working class heroes, bookkeepers to retrieve the payable taxation relief for each working class hero, and the governor to dispense money to each working class hero at her discretion.

## Getting Started
To use the Oppenheimer Project, follow these steps:

1. Navigate to the project through this link: <a href = "https://bit.ly/3RGTBrV">strengthandwill/oppenheimer-project-dev</a>
2. Download and clone above mentioned repository to your desktop. You may also choose to download the jar `OppenheimerProjectDev.jar`.
3. To run the application, issue the following to your terminal. Replace `{path-to-this-jar}` with your actual path to the folder containing the jar.
   `java -jar {path-to-this-jar}/OppenheimerProjectDev.jar`
4. Give it a min or two to boot up and you should be able to visit the app and API interface here:
- <a href = "http://localhost:8080/" target = "blank"> To the Portal </a>
- <a href = "http://localhost:8080/swagger-ui.html" target = "blank"> To the Swagger </a>
5. Then you can clone this repository and make any necessary tweaks for your own use. 

## User Stories
The following user stories have been implemented in the Oppenheimer Project:

1. As the Clerk, I should be able to insert a single record of a working class hero into the database via an API.
2. As the Clerk, I should be able to insert more than one working class hero into the database via an API.
3. As the Clerk, I should be able to upload a CSV file to a portal so that I can populate the database from a UI.
4. As the Bookkeeper, I should be able to query the amount of tax relief for each person in the database so that I can report the figures to my Bookkeeping Manager.
5. As the Governor, I should be able to see a button on the screen so that I can dispense tax relief for my working class heroes.

## Testing Strategy
The testing strategy for this system includes:

- Testing for functional requirements: Both UI and API testing to ensure that each feature works as expected. The POISED strategy has been used to do the API testing.
- Testing for non-functional requirements: UI testing to ensure that the system is user-friendly and meets performance and security standards.
- Test cases: several test cases have been covered to verify correctness and quality.

## Conclusion
The Oppenheimer Project is a successful system designed to support the taxation relief initiative for working class heroes in the City of Carson. It provides clerks with an easy way to populate a list of working class heroes, bookkeepers with an efficient way to retrieve the payable taxation relief for each working class hero, and the governor with a simple way to dispense money to each working class hero at her discretion. With its user-friendly interface, reliable performance, and robust error handling, the Oppenheimer Project is sure to be a valuable tool for the City of Carson for years to come.
