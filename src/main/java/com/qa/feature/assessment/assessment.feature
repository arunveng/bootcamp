Feature: Assessment
Scenario: Assesment on cucumber

Given Click on AppLauncher button and click view all
Then Click Service Console from App Launcher
Then Select Files from the DropDown
Then Click on the latest modified item link
Then Click on Public link
Then Verify the new link text field is disabled to create public link
Then Download the file into a specified folder inside the project
Then Click on Share 
Then Click on search user and select the Derrick Dsouza
And Verify the Error message "Can't share file with the file owner."
Then  Remove Derrick Dsouza and Select the second user in the list
Then  Add a message as "Bootcamp_Nupela_<your name>"
Then Verify "You shared <item> with <shared user>" message
Then Click on Upload Files and browse a file from your local 
Then Click on DrowDown for the newly uploaded file and select View File Details
And Verify the file name and extension of the newly uploaded file
Then Close the file window tab
Then Click on DropDown for the newly uploaded file and select Delete
Then Confirm Delete
And Verify the success message displayed for the delete