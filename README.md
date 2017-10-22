# CucumberWithMavenHybridFrameWork
A Sample Hybrid Framework based on Cucumber JAVA


Getting Started:-

1.Clone or download this repository
2.Import this project into eclipse
3.Run the pom.xml file as  right click -> run as -> maven test

Adding Feature files,

Step 1.Add the feature file in the "Features" folder present in (src/test/resources)
Note: Recommended to group features in seperate sub folders

Step 2. Add the respective step definitions in (src/test/java/StepDefintions)
(Follow the same package structure as that of Features file)

NamingConventions:-

1.Feature file:-
Follow Pascal Case naming conventions for feature file names
Example: HomePage_feature

2.Step Defintions file
Follow adding "_SD" to each step definition file
Example: HomePage_SD.java

3.Package Name:-
Follow reverse domain convention

Syntax: com.companyName.packageName
Example: com.hificompany.pageobjects

