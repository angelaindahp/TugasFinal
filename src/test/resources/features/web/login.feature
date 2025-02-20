Feature: Login ke website Demoblaze

  @web
  Scenario: Login berhasil dengan kredensial valid
    Given Saya berada di halaman login
    When Saya memasukkan username "testuser"
    And Saya memasukkan password "testpassword"
    And Saya mengklik tombol login
    Then Saya berhasil login dan melihat tombol logout
