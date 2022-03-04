Feature: Validate Add place API

Scenario: Verify if the place is successfully added using AddPlaceAPI
Given add place payload
When user calls the AddPlaceAPI with post http request
Then the API call gets success with status code 200
And status in response body is OK 