Pre-requisite
--------------------
1) Download Selenium folder and TVOWebProject folders from the link of git hub repository - https://github.com/abisvijimiru/tvoproject

2) Place the Selenium folder under "d:" driver (Since this folder path is used by this assignment to use chrome.exe,InternetExplorer.exe , etc. Which we can't keept in the project work space)
Example:
Selenium folder should be present under D:\Selenium - To refer .exe and excel files.
and this folder path is used by  D:\TVOWebProject\src\com\tvo\util\Constants.java file. If there is any change in this folder path, please update the Constants.java file also

3) Place the TVOWebProject in your local driver.
Example:
C:\TVOWebProject

Importing Existing Project into workspace using Eclipse
---------------------------------------------------------------------------------------
1. Go to File Menu --> Import --> General --> Exisitng Project(TVOWebProject) into Workspace.

2. Need to Browse to select the Project Root directory (TVOWebProject)

3. In the Projects needs to select the TVOWebProject and click Finish to import the existing project into eclipse.

4. TVOWebProject must contains the file structure similar to the TVOWebProjectFile Structure in the attachment.
       
5. Intiate the test case execution from src\com\tvo\testsuite\TVOWebProTestSuit  file to run all the test cases.

6. Observe the testcase pass/fail result in the junit window and check logs in the console.