# challenge_ui_automation
Configuration file: 
src/test/resources/application-qa.properties

    remote.execution = (true: execution on Saucelabs, false: execution locally) - If true, driver.manager will be ignored
    driver.manager = (true: WebDriverManager will be used for driver management - don't require driver bin files , false: Webdriver will be used, requires driver bin files )
    driver.type = (chrome, safari, edge : defines browser, only chromedriver.exe is included, for safari and edge set driver.manager=true)
    element.wait.timout.seconds=60
    initial.url=http://automationpractice.com/index.php
    take.instantpic.condition=failingScenario
    #take.instantpic.condition=[failingScenario, endOfScenario,everyStep ]
    remote.type=saucelabs
    remote.user=pe_tae (saucelabs paramenters)
    remote.key=09e916f2-5c5f-4416-84bf-615f0d030866 (saucelabs paramenters)

run command: 
*mvn clean test*

test case scenario:
src/test/resources/features/accountCreation.feature


    
    


