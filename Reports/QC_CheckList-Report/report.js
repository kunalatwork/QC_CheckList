$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./Features/QC_CheckList.feature");
formatter.feature({
  "line": 1,
  "name": "QC check list",
  "description": "",
  "id": "qc-check-list",
  "keyword": "Feature"
});
formatter.before({
  "duration": 36108199500,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Basic QC List",
  "description": "",
  "id": "qc-check-list;basic-qc-list",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@step1"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "SSL Certificate Expiry",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "Forgot Password module for email functioning related.",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Login through multiple users like REP/FLSM/SLSM/ADMIN",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "UI/UX wise proper testing",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Scores colour should change according to the CMS functioning",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "Scores count should be there as per logic",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "Language change should work perfectly",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "Forms icon and colour should be test",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "Regular QC of active clients",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "Data Dump quality check (Data that we download from export button)",
  "keyword": "Then "
});
formatter.match({
  "location": "TestSteps.ssl_Certificate_Expiry()"
});
formatter.result({
  "duration": 1679493100,
  "status": "passed"
});
formatter.match({
  "location": "TestSteps.forgot_Password_module_for_email_functioning_related()"
});
formatter.result({
  "duration": 37089809400,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//div[@aria-label\u003d\u0027Refresh\u0027]//div[@class\u003d\u0027asa\u0027]\"}\n  (Session info: chrome\u003d91.0.4472.106)\nFor documentation on this error, please visit: https://selenium.dev/exceptions/#no_such_element\nBuild info: version: \u00274.0.0-beta-3\u0027, revision: \u00275d108f9a67\u0027\nSystem info: host: \u0027LAKHAN\u0027, ip: \u0027192.168.1.5\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_211\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCommand: [31e8991cd01c84acc7fea92268979e7d, findElement {using\u003dxpath, value\u003d//div[@aria-label\u003d\u0027Refresh\u0027]//div[@class\u003d\u0027asa\u0027]}]\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 91.0.4472.106, chrome: {chromedriverVersion: 90.0.4430.24 (4c6d850f087da..., userDataDir: C:\\Users\\lakhan\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:52078}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), se:cdp: ws://localhost:52078/devtoo..., se:cdpVersion: 91.0.4472.106, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:largeBlob: true, webauthn:virtualAuthenticators: true}\nSession ID: 31e8991cd01c84acc7fea92268979e7d\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:198)\r\n\tat org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:131)\r\n\tat org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:52)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:184)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.invokeExecute(DriverCommandExecutor.java:153)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:128)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:619)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver$Mechanism$2.findElement(RemoteWebDriver.java:1258)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:386)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:380)\r\n\tat Steps.TestSteps.forgot_Password_module_for_email_functioning_related(TestSteps.java:100)\r\n\tat ✽.Then Forgot Password module for email functioning related.(./Features/QC_CheckList.feature:7)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "TestSteps.login_through_multiple_users_like_REP_FLSM_SLSM_ADMIN()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TestSteps.ui_UX_wise_proper_testing()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TestSteps.scores_colour_should_change_according_to_the_CMS_functioning()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TestSteps.scores_count_should_be_there_as_per_logic()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TestSteps.language_change_should_work_perfectly()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TestSteps.forms_icon_and_colour_should_be_test()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TestSteps.regular_QC_of_active_clients()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TestSteps.data_Dump_quality_check_Data_that_we_download_from_export_button()"
});
formatter.result({
  "status": "skipped"
});
});