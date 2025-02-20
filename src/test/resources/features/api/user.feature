Feature: API Testing - User
  @api
  Scenario: Get User by ID
    Given API endpoint untuk mendapatkan user tersedia
    When Saya mengirim GET request untuk user dengan ID "60d0fe4f5311236168a109ca"
    Then Response status harus 200
    And Response harus mengandung informasi user

  @api
  Scenario: Create User
    Given API endpoint untuk membuat user tersedia
    When Saya mengirim POST request dengan data user baru
    Then Response status harus 200
    And Response harus mengandung informasi user yang dibuat

  @api
  Scenario: Update User
    Given API endpoint untuk mengupdate user tersedia
    When Saya mengirim PUT request dengan ID "60d0fe4f5311236168a109ca" dan data baru
    Then Response status harus 200
    And Response harus mengandung informasi user yang diperbarui

  @api
  Scenario: Delete User
    Given API endpoint untuk menghapus user tersedia
    When Saya mengirim DELETE request untuk user dengan ID "60d0fe4f5311236168a109ca"
    Then Response status harus 200
    And Response harus menunjukkan user telah dihapus
