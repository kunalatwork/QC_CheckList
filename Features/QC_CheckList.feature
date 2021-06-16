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
Scenario: Dashboard Icons/Buttons
	Then The Dashboard icons/buttons should redirect properly.
	Then Redirect MAT button.
	Then Redirect YTD button
	Then Form Icons - on click should go to related form whether it's scoring or coaching form.
	Then Export Buttons should download the data accordingly.
	Then NEXT and PREVIOUS buttons in standard report.
	Then Managers/Coach Names should appear according to filter on SLSM.
	
@step3	
Scenario: Menu Item: Tabs/Modules for SLSM
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
	
@step4	
Scenario: Menu Item: Tabs/Modules for FLSM
	Then To check menu items-Tabs for FLSM. It should work properly.
	Then check standard report tab with all graph & Sales Call type options and MAT & YTD
	Then check standard report tab with all graph & Transactional Call type options and MAT & YTD
	Then check Graph ploter and generate report
	Then check LRC and downloadable and user guide
	Then Check Sales Rep Performance Tab.
	Then Check Manager/Coach Summary Tab.
	Then Check Sales Team Performance Tab.
	
@step5	
Scenario: Menu Item: Modules for SLSM/FLSM/REP
	Then To check menu items-Modules for Rep. It should work properly.
	Then Check Dashboard Module.
	Then check change password
	Then check all tabs scoring/Non-scoring tabs
	Then Export Excel sheet and click on form key icon
	Then Check Self Assessement form & fill the form And Add comment
	Then Check Graph ploter and click on download excel icon
	Then Check LRC
	Then click on homebutton and add feedback
