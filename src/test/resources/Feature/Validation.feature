Feature: List of scenarios
Scenario: Business rule through list of steps with arguments
Given user open "chrome" browser
Then launch url "https://adactinhotelapp.com/" 
When enter text "reyaz0310" using xpath "//*[@name='username']"
When enter password "reyaz123" using xpath "//*[@name='password']"
And click button "//*[@name='login']"
Then close


@rr
Scenario Outline: validate invelidate values

Given user open "chrome" browser
Then launch url "https://adactinhotelapp.com/" 
When enter text '<uesrname>' using xpath "//*[@name='username']"
When enter password '<passwors>' using xpath "//*[@name='password']"
And click button "//*[@name='login']"
Then close

Examples:
| uesrname | passwors |
| reraz0310 | reyaz132 |
| reyaz321 | reyaz123 |