Narrative:
As a user
I want to consume a service
So that I can acces the users list

Scenario: get user list
Given a user service <service>
When I submit the user list call
Then I get the <result> list

Examples:
|service|result|
|/app/users/getAll|test-response/get_all_users.json|