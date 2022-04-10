Feature: My javascript

  Scenario: Execute Java Script Multiply
    * def getIntValue = function(arg1, arg2) {return arg1 * arg2;}
    Then print "function value:", getIntValue(12,12)

