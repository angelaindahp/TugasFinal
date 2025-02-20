Feature: API Testing - Tags
  @api
  Scenario: Get List of Tags
    Given API endpoint untuk mendapatkan daftar tags tersedia
    When Saya mengirim GET request ke endpoint tags
    Then Response status harus 200
    And Response harus mengandung daftar tags
