# iSkilloApp_AutoTest

### Working with test automation framework with JAVA Maven

#### This project is part of the Skillo Academy program for Automation QA

#### The project is created with the below-mentioned technologies:
* TestNG
* Selenium WebDriver

### Short Description of the project:
The project iSilloApp_AutoTest is focused on finding bugs and checking the functionallity of the iSkillo webpage.
The project is based on the design pattern of Page Objet Model and Page Factory.  It contains 5 Automation Tests.

### Description of the requirements:
1. Project must be made based on Page Object Model design pattern and PageFactory for project organization.
2. To automate no less than 5 different test scenarios against the following website: http://training.skillo-bg.com:4200/posts/all
3. Project must contain testng.xml file.
4. All tests can be run with the 'mvn clean test' command against Chrome browser.
5. On test failure, save a screenshot to a selected directory in the project.

### testng.xml
All test classes are added in a test suite to the testng.xml file (/src/test/resources/testng.xml). All test cases can be executed in bulk by running the testng.xml file.

### Test Cases
- RegistrationTest - testing the registration functionality with different credentials.
- LoginTest - testing navigation to home page, selecting login button, validation of URL, checking if Sign In header is displayed, entering credentials.
- ProfileTest - testing validation of url, profile name, clickable buttons such as 'all, followers, following'.
- AvatarTest - updating avatar/profile picture.
- ModifyProfilePage - testing if modify pop-up window shows and inserting new text into the public info field.
- PostsTest- testing the upload function a post picture with caption text. 

