/*
Copyright 2012 Selenium committers
Copyright 2012 Software Freedom Conservancy

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

public class MetaKeyUp extends SeleneseCommand<Void> {
  private final KeyState keyState;

  public MetaKeyUp(KeyState keyState) {
    this.keyState = keyState;
  }

  @Override
  protected Void handleSeleneseCommand(WebDriver driver, String locator, String value) {
    keyState.metaKeyDown = false;
    return null;
  }
}
