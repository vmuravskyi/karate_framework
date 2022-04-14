Feature: To validate the GET End response from file
  To validate the get end point response from external file

  Background: Setup the base url
    Given url 'https://jobportalkarate.herokuapp.com'

  Scenario: To get the data in JSON format and validate from file
    Given path '/normal/webapi/all'
    And header Accept = 'application/json'
    When method get
    Then status 200
    # Create a variable to store the data from external file
    * def expectedResponse = read("JsonResponse.json")
    And print "File ==> ", expectedResponse
    And match response == expectedResponse

  Scenario: To get the data in xml format
    Given path '/normal/webapi/all'
    And header Accept = 'application/xml'
    When method get
    Then status 200
    # Create the variable to read the data from xml file
    * def expectedResponse = read("XmlResponse.xml")
    And print "Xml Response ==> ", expectedResponse
    And match response == expectedResponse
