Feature: SDET_IBM_Assigment_001
Scenario: Verify add add , modify and delete coupon functionality.   
Given  User login to the Application with the usname "username" and pwd "password"   
When   User click on add new coupon icon on page. 
And    Enter the mandatory fields and click on save button 
Then   Verify coupon has added successfully to the coupon list page. 
Given  Select the newly created coupon code "couponCode"
When   click on edit button and Edit the coupon discount type and save the coupon
Then   Verify the details has been updated for the coupon 
Given  select the modified coupon code "couponCode "from the coupon list
When   Select the coupon and delete it 
Then   Verify coupon has deleted from coupon list page.  
