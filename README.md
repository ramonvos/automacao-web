	# Desafio automação web com Selenium e Java (E-commerce)

	## Requirements

	Environment Windows
	Google chrome installed -- version 80 +

	## Project structure

	.
	├── ...
	├── src/main/java                    #Selenium project configuration
	│   ├── base              			 # Selenium TestBase setup project
	│   ├── constants              		 # Constants file
	│   ├── drivers                      # Selenium drivers - browsers
	│   ├── enums                        # Enumeration file
	│   ├── logger                       # Reporter .html file configuration
	│   ├── pages            			 # Page Object mapping and navigation methods
	│   ├── selenium            		 # Selenium get and set methods
	│   └── utilities  					 # Project and Generic helpers	
	├── src/test/java                    # Selenium Automated Tests Cases
	│   ├── tests             			 # Automated Tests
	└── ...

	## HOW TO RUN 


	Clone projet:
	```
	git clone https://github.com/ramonvos/automacao-web.git
	```

	In Command Prompt type:
	```
	cd [user-dir]\automacao-web
	mvn clean test -Dsurefire.suiteXmlFiles=testng.xml
	```


	> **Note:** The **Logger html file** is saved in the folder [user-dir]\automacao-web\report.

	## Log example (Extent Reports)
	
	 ![Reporter](https://imgur.com/m6il5ne)

