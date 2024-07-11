
@tag
Feature: Simple form fillup

 

  @tag1
  Scenario Outline: Test the form fillup functionality
    Given User visit Simple Form web application
    When User enter "<FirstName>","<LastName>","<Email>","<ContactNumber>","<Message>"
    And User click the submit button 
    Then User should get Thank You popup

    Examples: 
      | FirstName | LastName | Email				   | ContactNumber | Message		         |
      | Sagar 	  |     Jana | jana@gmail.com  | 1234567890		 | Hello! This is test |
      | Raju      |    Koley | koley@gmail.com | 7894561230		 | Issue with login		 |
