$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/java/features/search.feature");
formatter.feature({
  "name": "Search Test for Salesforce",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Search Test Scenario",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on Login Page and enters credentials",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchStepDefinition.user_is_on_Login_Page_and_enters_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User logs in",
  "keyword": "When "
});
formatter.match({
  "location": "SearchStepDefinition.user_logs_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User searches for the Writing Tests",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchStepDefinition.user_searches_for_the_Writing_Tests()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "List with the link for Writing Tests should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchStepDefinition.list_of_with_the_link_for_Writing_Tests_article_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should navigate to Writing Tests page",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchStepDefinition.user_User_should_navigate_to_Writing_Tests_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User finds the Testing Apex link",
  "keyword": "And "
});
formatter.match({
  "location": "SearchStepDefinition.user_finds_the_Testing_Apex_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Navigates to Testing Apex page and verifies page is open",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchStepDefinition.user_Navigates_to_Testing_Apex_page()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});