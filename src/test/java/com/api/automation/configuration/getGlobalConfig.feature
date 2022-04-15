Feature: To get the variables set by Karate-config.js file

  Background: To get the value of myVarName
    * def localMyVarName = myVarName
    Given print "Background Variable value ==> ", localMyVarName

  Scenario: To get the value of username and password from karate-config.js
    * def localUserName = username
    Given print "Scenario Variable value ==> ", localUserName
    And print "Scenario Variable value ==> ", password
    * def baseUrl = baseUrl
    And print "Base URL from karate-config.js file ==> ", baseUrl
