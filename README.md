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
--The record is creating but the status code (202) indicated that the request is not completed.
-- Not giving a clear response.

4.As the Bookkeeper, I should be able to query the amount of tax relief for each person in the database so that I can report the
   figures to my Bookkeeping Manager
-- when adding count to the system. each time it gets increased by 100. Not have the control over a length of the system.
* TC 1 - Test GET endpoint
* TC 2 - Verify that Bookkeeper can see the tax relief list
* TC 3 - Verify that the 'natid' field of each record in the response is masked from the 5th character " +
  "onwards with a dollar sign '$'
* TC 4 - Verify the Computation of Tax Relief Amount is correct.
* TC 5 - Check that tax relief summary is shown correctly.
* TC 6 - Verify that the computed 'tax relief amount' is rounded off using normal rounding rule to remove any decimal places.
* TC 7 - Verify that if the calculated tax relief amount after subjecting to normal rounding rule is more than 0.00 but less than 50.00, the final tax relief amount should be 50.00.
* TC 8 - Verify that if the calculated tax relief amount before applying the normal rounding rule gives a value with more than 2 decimal places, it should be truncated at the second decimal place and then subjected to normal rounding rule.
* 