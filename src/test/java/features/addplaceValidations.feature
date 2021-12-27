Feature: Add a new Place feature

@pvt
Scenario: To Test adding a new place using the api
Given add place payload
When user calls "AddPlaceAPI" with post http request
Then API call should get status code as 200
And "status" Of API response body has "OK"
And "scope" Of API response body has "APP"

@pvt
Scenario Outline: To Test adding a new place using the api
Given add place payload  with <name> <language> <address>
When user calls "AddPlaceAPI" with post http request
Then API call should get status code as 200
And "status" Of API response body has "OK"
And "scope" Of API response body has "APP"
Examples:
|name|language|address|
|n1|lang-1|ad1|
|n2|lang-2|ad2|

@pvtenum
Scenario Outline: To Test adding a new place using the api
Given add place payload  with <name> <language> <address>
When user calls "AddPlaceAPI" with "POST" http request
Then API call should get status code as 200
And "status" Of API response body has "OK"
And "scope" Of API response body has "APP"
Examples:
|name|language|address|
|n1|lang-1|ad1|
|n2|lang-2|ad2|