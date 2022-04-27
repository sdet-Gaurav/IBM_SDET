package Resources;

import java.io.IOException;

import org.junit.Assert;

public class WebPage extends TestBase{
	
	public static void verifySuccessMessage() throws IOException
	{
		String text= getText(readDataFromProp("coupons.successMessage"));
		String[]text1=text.split("!"); 
		Assert.assertEquals(text1[0],TestData.couponsSuccessMessage );	
	}

	
}
