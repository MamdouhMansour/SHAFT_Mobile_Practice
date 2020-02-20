# using_SHAFT_ENGINE
<img src="https://drive.google.com/uc?export=download&id=1VHD9VsVHDndMjSV-wTVtCXUPHZ9AryO7" alt="SHAFT_ENGINE" style="display:block; margin-left:auto; margin-right:auto;"/>

**using_SHAFT_ENGINE** is a sample project to showcase how to get started using [SHAFT_Engine](https://github.com/MohabMohie/SHAFT_ENGINE/), and how to use some of its rich features, while applying the best practices for Test Automation project design. For a full list of the Supported features that you can use or try out, please refer to this [Read Me](https://github.com/MohabMohie/SHAFT_ENGINE/blob/master/README.md) file.

### Running your first sample test:
1. Simply import this project to your eclipse (or favorite JAVA IDE).
2. Watch this simple 5-minute live-demo:
https://drive.google.com/file/d/1NxBpObvbBHdMjL4tl7PlpRNi7U9lMfW8/view

### Creating your own project based on using_SHAFT_ENGINE:
1. Make your own fork from the project <img src="https://drive.google.com/uc?export=download&id=1TIHfU4OamNjqEHFhasxw6tUw8YJwrItX" alt="using_SHAFT_ENGINE" style="display:block; margin-left:auto; margin-right:auto;"/>
2. You can refer to this sample tutorial on how to import your new project into your workspace: https://tools.jboss.org/documentation/howto/git_import_projects.html#clone_uri
3. After your project is successfully imported, you can explore the file structure, and add your own tests or test suites as needed.

### Important Notes:
- Always use the latest version of SHAFT_Engine in your pom.xml file [![Maven Central](https://img.shields.io/maven-central/v/io.github.mohabmohie/SHAFT_ENGINE.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.mohabmohie%22%20AND%20a:%22SHAFT_ENGINE%22)
- Refer to the published SHAFT_Engine javadocs for detailed information on the available functions/classes/packages https://mohabmohie.github.io/SHAFT_ENGINE/
- Refer to TestNG [https://testng.org/doc/documentation-main.html] and Allure Reporting [https://docs.qameta.io/allure/] documentation for using annotations

### IntelliJ:
- As of the latest version of SHAFT_Engine '4.0.20200220-beta' you can now use IntelliJ in addition to Eclipse to manage your test project.
- After checking out the project to your IntelliJ you may face an exception that prevents tests execution.
- In that case you need to add the SHAFT_Engine custom listeners to your TestNG execution template, as IntelliJ doesn't natively inherit this list from the pom.xml file.
- Here are the steps you need to follow:
  - This is the error that you may see <img src="https://drive.google.com/uc?export=download&id=1ZOyhYrTczLDVSO7wJzKoEghiYm9yDrhM" alt="1 of 6" style="display:block; margin-left:auto; margin-right:auto;"/>
  - In that case you need to Edit your Run/Debug configuration <img src="https://drive.google.com/uc?export=download&id=1m0gvqFMz0YqTaM28DKyZUiCUHWRpwOdC" alt="2 of 6" style="display:block; margin-left:auto; margin-right:auto;"/>
  - Navigate to Templates > TestNG > Configuration > Listeners <img src="https://drive.google.com/uc?export=download&id=1-WqbA2EPvMXX55Dr7pnQLUtnZ4OWwfAN" alt="3 of 6" style="display:block; margin-left:auto; margin-right:auto;"/>
  - Type com.shaft.tools.* into your search box to find the required listeners and add them one by one <img src="https://drive.google.com/uc?export=download&id=17lykJyCaCTYgnmZY0NBzfWxWLQGzxOyU" alt="4 of 6" style="display:block; margin-left:auto; margin-right:auto;"/>
  - This is the desired output for your listeners configuration <img src="https://drive.google.com/uc?export=download&id=1h047bFULAzItLr2yJ_LNnIToJjRttUDX" alt="5 of 6" style="display:block; margin-left:auto; margin-right:auto;"/>
  - Success! <img src="https://drive.google.com/uc?export=download&id=1TiFuFW2s2hozOtkM9t-ZBWbOEdQssV6g" alt="6 of 6" style="display:block; margin-left:auto; margin-right:auto;"/>
