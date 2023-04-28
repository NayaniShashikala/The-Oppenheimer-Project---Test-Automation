# The-Oppenheimer-Project---Test-Automation
Oppenheimer Project - This is an Test automating which includes UI and API automation using Selenium for efficient testing and quality assurance. 

User Stories
1. As the Clerk, I should be able to insert a single record of working class hero into 
database via an API.
--While executing the single person insert end point, it showed the status code as 500 - Server side error.
-- Looked into the terminal and found the case as "Value too long for column """GENDER"" VARCHAR(1)": "'female' (6)"; 
-- After correcting it also has thrown an error like "StringIndexOutOfBoundsException has been thrown, with the range [0, 4) (i.e., the range from index 0 to index 3) being out of bounds for a string with length 3."
-- The record is creating but the status code (202) indicated that the request is not completed.
-- Not giving a clear response.


2. As the Clerk, I should be able to insert more than one working
   class hero into database via an API.
--

