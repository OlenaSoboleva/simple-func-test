package my.tests.simplefunctest

import geb.spock.GebSpec

class MyFirstSpecTest extends GebSpec {

  def "test search functional testing wiki page"() {
    given: "we are at main wiki page"
    to MainWikiPageTest

    when: "try to search functional testing page"
    searchField.value("Функциональное тестирование")
    searchButton.click()

    then: "check we are on functional testing page"
    at FunctionalTestingWikiPageTest
  }
}
