Feature: Checkout produk di website Demoblaze

  @web
  Scenario: Checkout berhasil dengan produk dalam keranjang
    Given Saya sudah login di website Demoblaze
    And Saya menambahkan produk ke dalam keranjang
    When Saya membuka halaman keranjang
    And Saya mengklik tombol checkout
    Then Saya melihat halaman pembayaran
