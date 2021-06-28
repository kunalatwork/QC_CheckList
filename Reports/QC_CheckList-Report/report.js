$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./Features/QC_CheckList.feature");
formatter.feature({
  "line": 1,
  "name": "QC check list",
  "description": "",
  "id": "qc-check-list",
  "keyword": "Feature"
});
formatter.before({
  "duration": 13692795500,
  "status": "passed"
});
formatter.scenario({
  "line": 37,
  "name": "Verify all section of First Level Sales Manager(FLSM) Dashboard",
  "description": "",
  "id": "qc-check-list;verify-all-section-of-first-level-sales-manager(flsm)-dashboard",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 36,
      "name": "@step3"
    }
  ]
});
formatter.step({
  "line": 38,
  "name": "To check menu items-Tabs for FLSM. It should work properly.",
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "check standard report tab with all graph \u0026 Sales Call type options and MAT \u0026 YTD",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "check standard report tab with all graph \u0026 Transactional Call type options and MAT \u0026 YTD",
  "keyword": "Then "
});
formatter.step({
  "line": 41,
  "name": "check Graph ploter and generate report",
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "check LRC and downloadable and user guide",
  "keyword": "Then "
});
formatter.step({
  "line": 43,
  "name": "Check Sales Rep Performance Tab.",
  "keyword": "Then "
});
formatter.step({
  "line": 44,
  "name": "Check Manager/Coach Summary Tab.",
  "keyword": "Then "
});
formatter.step({
  "line": 45,
  "name": "Check Sales Team Performance Tab.",
  "keyword": "Then "
});
formatter.match({
  "location": "TestSteps.to_check_menu_items_Tabs_for_FLSM_It_should_work_properly()"
});
formatter.result({
  "duration": 2642097900,
  "status": "passed"
});
formatter.match({
  "location": "TestSteps.check_standard_report_tab_with_all_graph_Sales_Call_type_options_and_MAT_YTD()"
});
formatter.result({
  "duration": 87528292900,
  "status": "passed"
});
formatter.match({
  "location": "TestSteps.check_standard_report_tab_with_all_graph_Transactional_Call_type_options_and_MAT_YTD()"
});
formatter.result({
  "duration": 82287837900,
  "status": "passed"
});
formatter.match({
  "location": "TestSteps.check_Graph_ploter_and_generate_report()"
});
formatter.result({
  "duration": 7265365900,
  "status": "passed"
});
formatter.match({
  "location": "TestSteps.check_LRC_and_downloadable_and_user_guide()"
});
formatter.result({
  "duration": 4143908700,
  "status": "passed"
});
formatter.match({
  "location": "TestSteps.check_Sales_Rep_Performance_Tab()"
});
formatter.result({
  "duration": 19840804700,
  "status": "passed"
});
formatter.match({
  "location": "TestSteps.check_Manager_Coach_Summary_Tab()"
});
formatter.result({
  "duration": 5741108000,
  "status": "passed"
});
formatter.match({
  "location": "TestSteps.check_Sales_Team_Performance_Tab()"
});
formatter.result({
  "duration": 20282983400,
  "status": "passed"
});
});