Feature: Todo software positive/Negative scenarios 
 
 Scenario: Check if the given link is valid and application is gettin downloaded without any problem 
 Given Open Firefox and start application 
 When User click on valid link
 Then I should be able to get into and see Todos as a header
 
 Scenario: Check if user is able to enter into text box
 Given User on home page
 When Enter valid Value on empty text box and Hit Enter button
 Then Value should get added in the TODO box 

 
Scenario: Check the radio button functionality
 Given User on home page and there is a value in todo table
 When User clicks on radio button
 Then that particular selected value should get strikeout and we see clear complete 
 
 Scenario: Check if User can add more than one value in TO-do
 Given User on home page
 When User enter more than one values and hit enter
 | Please call samit |
 | Inform DAD about the meeting |
 Then More than one value should get added into table
 
#Negative--

 Scenario: User should not be able to add empty string in the text box
 Given User on home page and there is not any value in the textbox
 When User enters empty string and try to Hit Enter button
 Then Value should get added in the TODO box 
 
 Scenario: User should not only enter special chars in the text box
 Given User on home page
 When User enters only special chars and Hit Enter button
 Then error message should be shown of entering valid value  

