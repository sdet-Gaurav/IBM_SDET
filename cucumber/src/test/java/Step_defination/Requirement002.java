package Step_defination;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

import Resources.Configure;
import Resources.TestBase;
import Resources.TestData;
import Resources.WebPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.utility.RandomString;

public class Requirement002 extends TestBase{
	
	
	
	@Given("User login to the Application with valid usname and pwd")
	public void User_login_to_the_Application_with_valid_usname_and_pwd() throws IOException {
	    
	    driver.get(Configure.url);
	    driver.findElement(By.xpath(readDataFromProp("login.username"))).sendKeys(Configure.username);
	    driver.findElement(By.xpath(readDataFromProp("login.pwd"))).sendKeys(Configure.password);
	    driver.findElement(By.xpath(readDataFromProp("login.signin"))).click();
	    System.out.println("user has logged in successfully to app");
	}

	@When("User click on add new coupon icon on page.")
	public void user_click_on_add_new_coupon_icon_on_page() throws IOException {
	    
		driver.findElement(By.xpath(readDataFromProp("dashboard.sourcelink"))).click();
		driver.findElement(By.xpath(readDataFromProp("dashboard.couponlink"))).click();
		driver.findElement(By.xpath(readDataFromProp("dashboard.addnewCouponbutton"))).click();
	    
	}

	@When("Enter the mandatory fields and click on save button")
	public void enter_the_mandatory_fields_and_click_on_save_button() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		StringBuilder S=new StringBuilder("ASDET");
		StringBuilder S1=new StringBuilder("21");
		TestData.couponName= getRandomString(S);
		TestData.couponCode=getRandomString(S1);
		
	    driver.findElement(By.xpath(readDataFromProp("coupons.couponName"))).sendKeys(TestData.couponName);
	    driver.findElement(By.xpath(readDataFromProp("coupons.couponCode"))).sendKeys(TestData.couponCode);
	    selectFromDropdown(readDataFromProp("coupons.type"),"Fixed Amount");
	    driver.findElement(By.xpath(readDataFromProp("coupons.save"))).click();
	}

	@Then("Verify coupon has added successfully to the coupon list page.")
	public void verify_coupon_has_added_successfully_to_the_coupon_list_page() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    
	    
		WebPage.verifySuccessMessage();
		System.out.println("Coupon "+TestData.couponCode+ " has added successfully");

		
	}

	@Given("Select the newly created coupon code")
	public void Select_the_newly_created_coupon_code() {
	    // Write code here that turns the phrase above into concrete actions
		
	    driver.findElement(By.xpath("//tr[td[text()='"+TestData.couponName+"']]//a[@data-original-title='Edit']")).click();
	}

	@When("click on edit button and Edit the coupon discount type and save the coupon")
	public void click_on_edit_button_and_Edit_the_coupon_discount_type_and_save_the_coupon() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
        selectFromDropdown(readDataFromProp("coupons.type"),"Percentage");
        driver.findElement(By.xpath(readDataFromProp("coupons.save"))).click();
	}

	@Then("Verify the details has been updated for the coupon")
	public void verify_the_details_has_been_updated_for_the_coupon() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		WebPage.verifySuccessMessage();
		System.out.println("Coupon "+TestData.couponCode+" has modified successfully");
	}

	@Given("select the modified coupon code from the coupon list")
	public void select_the_modified_coupon_code_from_the_coupon_list() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("Select the coupon and delete it")
	public void select_the_coupon_and_delete_it() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath(readDataFromProp("coupons.delete"))).click();
	    driver.switchTo().alert().accept();
	    
	}

	@Then("Verify coupon has deleted from coupon list page.")
	public void verify_coupon_has_deleted_from_coupon_list_page() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		WebPage.verifySuccessMessage();
		System.out.println("Coupon "+TestData.couponCode+ " has deleted successfully");
	}



}
