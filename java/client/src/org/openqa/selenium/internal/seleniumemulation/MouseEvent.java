/*
Copyright 2007-2009 Selenium committers

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package org.openqa.selenium.internal.seleniumemulation;

import com.thoughtworks.selenium.webdriven.SeleneseCommand;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MouseEvent extends SeleneseCommand<Void> {
  private final ElementFinder elementFinder;
  private final JavascriptLibrary js;
  private final String type;
  private final String fire;

  public MouseEvent(ElementFinder elementFinder, JavascriptLibrary js, String type) {
    this.elementFinder = elementFinder;
    this.js = js;
    fire = "return (" + js.getSeleniumScript("fireEvent.js") + ").apply(null, arguments);";
    this.type = type;
  }

  @Override
  protected Void handleSeleneseCommand(WebDriver driver, String locator, String value) {
    WebElement element = elementFinder.findElement(driver, locator);

    js.executeScript(driver, fire, element, type);

    return null;
  }
}
