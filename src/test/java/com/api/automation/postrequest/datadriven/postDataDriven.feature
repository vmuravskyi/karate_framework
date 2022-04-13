Feature: To create job description in the test application

  Background: Read the data for data driven
    * def testData = read("testData.csv")

  Scenario Outline: To create job description in the test application <method>
    Given print '<url>'
    Then print '<path>'
    When print '<method>'
    And print '<status>'

    Examples:
      | url                                   | path               | method | status |
      | https://jobportalkarate.herokuapp.com | /normal/webapi/all | get    | 200    |
      | https://jobportalkarate.herokuapp.com | /normal/webapi/add | post   | 201    |
      | https://jobportalkarate.herokuapp.com | /normal/webapi/add | put    | 201    |

  Scenario Outline: Data Driven for the job description entry - <jobId>
    Given url 'https://jobportalkarate.herokuapp.com'
    And path '/normal/webapi/add'
    And request {  "jobId": '#(jobId)',"jobTitle": '#(jobTitle)', "jobDescription": '#(jobDescription)', "experience": [ "Google", "Apple", "Mobile Iron", "Google" ], "project": [ { "projectName": "Movie App", "technology": [ "Kotlin", "SQL Lite","Gradle", "Jenkins" ] } ]}
    And headers {Accept : 'application/json', Content-Type: 'application/json'}
    When method post
    And status <status>

    Examples:
      | jobId | jobTitle          | jobDescription                 | status |
      | 9980  | Software Engg - 2 | To develop andriod application | 201    |
      | id    | Software Engg - 2 | To develop andriod application | 400    |
      | false | Software Engg - 2 | To develop andriod application | 400    |

  Scenario Outline: Data Driven for the job description entry using csv files - <jobId>
    Given url 'https://jobportalkarate.herokuapp.com'
    And path '/normal/webapi/add'
    And request { "jobId": '#(jobId)',"jobTitle": '#(jobTitle)', "jobDescription": '#(jobDescription)', "experience": [ "Google", "Apple", "Mobile Iron", "Google" ], "project": [ { "projectName": "Movie App", "technology": [ "Kotlin", "SQL Lite","Gradle", "Jenkins" ] } ]}
    And headers {Accept : 'application/json', Content-Type: 'application/json'}
    When method post
    And status <status>

    Examples: 
      #|testData| # using a variable as a function which reads a file in background section
      | read("testData.json") |
