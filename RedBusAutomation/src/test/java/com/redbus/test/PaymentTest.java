package com.redbus.test;

import org.testng.annotations.Test;

public class PaymentTest extends BaseTest{
	
	@Test
	public void performLogin(){
	}
	
	
  @Test(dependsOnMethods={"performLogin"})
  public void composeAndSendMessage() {
	
  }
  
  @Test
  public void getOptions() {
	  
  }
}
