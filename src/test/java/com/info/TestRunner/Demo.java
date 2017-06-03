package com.info.TestRunner;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Demo {
  @Test
  public void f() {
  }
  @BeforeMethod
  public void beforeMethod() 
  {  
	  System.out.println("Welcome");
  }

  @AfterMethod
  public void afterMethod() {
  }

}
