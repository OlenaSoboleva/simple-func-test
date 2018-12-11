package my.tests.simplefunctest

import geb.Page

class FunctionalTestingWikiPageTest extends Page {

  static at = { $().text().contains("Функциональное тестирование — это тестирование ПО в целях проверки реализуемости функциональных требований") }
}
