package my.tests.simplefunctest

import geb.Page

class MainWikiPageTest extends Page {
  static url = "http://ru.wikipedia.org/"
  static at = {title == "Википедия — свободная энциклопедия"}
  static content = {
    searchField { $("input", id: "searchInput")}
    searchButton (to: FunctionalTestingWikiPageTest) { $("button", id: "searchButton")}
  }
}
