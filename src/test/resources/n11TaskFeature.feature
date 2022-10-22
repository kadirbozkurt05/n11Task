Feature: N11 Favori Ürün Senaryosu

             -	www.n11.com sitesi açılır.
            -	Ana sayfanın açıldığı kontrol edilir.
            -	Siteye login olunur.
            -	Login işlemi kontrol edilir.
            -	Iphone kelimesi aranır.
            -	Iphone kelimesi aratıldığı kontrol edilir.
            -	Arama sonuçları sayfasından 2. sayfa açılır.
            -	2. sayfanın açıldığı kontrol edilir.
            -	Sayfadaki 3. ürün favorilere eklenir.
            -	Hesabım -> Favorilerim / Listelerim sayfasına gidilir.
            -	“Favorilerim” sayfası açıldığı kontrol edilir.
            -	Eklenen ürün favorilerden silinir ve silme işlemi kontrol edilir.
            -	Üye çıkış işlemi yapılır.
@wip
      Scenario: Go to Login Pgae
        When user goes to n11 page
        Then verify n11 page is opened
  @wip
      Scenario Outline: Log In
        When user click login button
        When user types "<valid user email>" into user input
        And user types "<valid user password>" into password input
        And user click login button on Sign In Page
        Then verify that user is logged in
        Examples:
          |valid user email  | valid user password|
          |valid@email.com|validPassword123|
          |valid2@email.com|validPassword456|


      Scenario: Search Given Input
        When user types "Iphone" into search box and press enter
        Then verify that "Iphone" is searched

      Scenario: Go to second page of search result
        When user open the second page of search results
        Then verify that second page of search results is shown

      Scenario: Add third product to Favourites
        When user add to favorites the third product of the page
        And user goes the My Favourites and My Lists
        Then verify that My Favourites page is opened

      Scenario: Remove product from Favourites
        When user delete the product from the favourites list
        Then verify that the product is deleted from favourites list

      Scenario: Log out
        When user clicks the logout
        Then verify that user is logged out






