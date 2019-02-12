Narrative:
As a user
I want to get a greeting
So that I do not feel lonenly

Scenario: greet user
Given a service <service>
When I submit the call
Then I get the <result> greeting

Examples:
|service|result|
|/app/greet|Hello World!|