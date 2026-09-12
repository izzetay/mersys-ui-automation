Feature: Grading - Print and Download Transcript

  Background:
    Given User Opens the website.
    And Logs into website.

  Scenario: User views and downloads their Course Grade transcript as PDF
    When User navigates to the 'Grading' page.
    Then User should see a 'Print' icon on the page.
    When User clicks the 'Print' icon.
    Then User should see the transcript document in PDF format.
    # pdf indirme adımı nasıl yapılacak?