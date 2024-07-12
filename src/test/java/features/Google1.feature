@Google
Feature: Navigation on Google

  @LogintoGoogle @Regression
  Scenario Outline: Logging into Google1

    Given User opens <BrowserName>
    And Goes to <ApplicationURL>
    And Enters <SearchText> in <SearchOR>
  # And Logs in using <Username> and <Password>
 # And Search using <searchCritera>
 # And Selects Employee size critera <specEmpSize>
  #For testing

    Examples:
      | BrowserName | ApplicationURL     | SearchText | SearchOR       | Username                      | Password  | searchCritera    | specEmpSize |
      | Chrome      | https://google.com | Selenium   | SearchBar_name | sangita.barnwal@smarteinc.com | Admin@123 | Firmographics_xp | 501 to 1000 |

  @Regression
  Scenario Outline: Logging into Google1

      Given User opens <BrowserName>
      And Goes to <ApplicationURL>
      And Enters <SearchText> in <SearchOR>
  # And Logs in using <Username> and <Password>
 # And Search using <searchCritera>
 # And Selects Employee size critera <specEmpSize>
  #For testing

      Examples:
        | BrowserName | ApplicationURL    | SearchText                | SearchOR   | Username                      | Password  | searchCritera    | specEmpSize |
        | Chrome      | https://gmail.com | sangita.barnwal@gmail.com | GmailId_xp | sangita.barnwal@smarteinc.com | Admin@123 | Firmographics_xp | 501 to 1000 |
