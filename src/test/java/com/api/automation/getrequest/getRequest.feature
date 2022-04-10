Feature: To test the get end point of the application
  To test different get end point with different data formate supported by the application

  Background: Setup the Base path
    Given url 'https://jobportalkarate.herokuapp.com'
    And print '****************************** This is Background Keyword ******************************'

  Scenario: To get all the data from application in JSON format
    Given url 'https://jobportalkarate.herokuapp.com/normal/webapi/all'
    When method get # Send the get request
    Then status 200 # the status code response should be 200

  Scenario: To get all the data from application in JSON format using path variable
    And path '/normal/webapi/all'
    And header Accept = 'application/json'
    When method get # Send the get request
    Then status 200 # the status code response should be 200

  Scenario: To get all the data from application in XML format using path variable
    And path '/normal/webapi/all'
    And header Accept = 'application/xml'
    When method get # Send the get request
    Then status 200 # the status code response should be 200
