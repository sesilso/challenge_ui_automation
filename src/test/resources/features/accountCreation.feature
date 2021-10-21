Feature: New Account Creation
  @AccountCreation @RegressionTest
  Scenario: Verify Successful Account Creation
    Given A client wants to create an account in the platform
    When the client completes the creation process
    Then the account should be created successfully
