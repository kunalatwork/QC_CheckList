Feature: QC check list
 
@step1
Scenario: Basic QC List

    Then SSL Certificate Expiry
    Then Forgot Password module for email functioning related.
    Then Login through multiple users like REP/FLSM/SLSM/ADMIN
    Then UI/UX wise proper testing
    Then Scores colour should change according to the CMS functioning
    Then Scores count should be there as per logic
    Then Language change should work perfectly
    Then Forms icon and colour should be test
	Then Regular QC of active clients
	Then Data Dump quality check (Data that we download from export button)

	
@step2
Scenario: Verify all section of Second Level Sales Manager(SLSM) Dashboard
    Then To check menu items-Tabs for SLSM. It should work properly.
    Then check new coaching form of SLSM
    Then check Scoring form of SLSM
    Then check standard report tab of SLSM with all graph & Sales Call type options and MAT & YTD
	Then check standard report tab of SLSM with all graph & Transactional Call type options and MAT & YTD
    Then check Graph ploter and generate report of SLSM
	Then check LRC and downloadable and user guide of SLSM
	Then Check Field Visit Tab.
	Then Check Calls coached Tab.
	Then Check Call Rate Tab.
	Then Check Skill Performance Tab.
	Then Check NS FV Tab.
	Then Check Telephone Tab.
	Then Check CFC Tab.
	Then Check WOW Tab.
	
@step3
Scenario: Verify all section of First Level Sales Manager(FLSM) Dashboard
	Then To check menu items-Tabs for FLSM. It should work properly.
	Then check standard report tab with all graph & Sales Call type options and MAT & YTD
	Then check standard report tab with all graph & Transactional Call type options and MAT & YTD
	Then check Graph ploter and generate report
	Then check LRC and downloadable and user guide
	Then Check Sales Rep Performance Tab.
	Then Check Manager/Coach Summary Tab.
	Then Check Sales Team Performance Tab.
	
@step4	
Scenario: Verify all section of Representative Dashboard
	Then To check menu items-Modules for Rep. It should work properly.
	Then Check Dashboard Module.
	Then check change password
	Then check all tabs scoring/Non-scoring tabs
	Then Export Excel sheet and click on form key icon
	Then Check Self Assessement form & fill the form And Add comment
	Then Check Graph ploter and click on download excel icon
	Then Check LRC
	Then click on homebutton and add feedback
