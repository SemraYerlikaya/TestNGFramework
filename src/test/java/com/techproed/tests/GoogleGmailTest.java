package com.techproed.tests;

import com.techproed.pages.GooglePage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleGmailTest extends TestBaseFinal {

    @Test
    public void gmailTest() throws InterruptedException{
        extentTest=extentReports.createTest("Gmail Test","Gmail e google uxerinden erisim testi");
        extentTest.info("Google.com a gidiyoruz");
        Driver.getDriver().get(ConfigurationReader.getProperty("google_link"));
        extentTest.info("GooglePage den nesne uretiyoruz");
        GooglePage googlePage= new GooglePage();

        extentTest.info("gmailLinki webelementine tikliyoruz");
        googlePage.gmailLinki.click();

        extentTest.info("3 saniye bekliyoriuz");
        Thread.sleep(3000);

        extentTest.info("Assert islemi yap");
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Gmail"));
        extentTest.pass("Testimiz PASSED !");

    }
}
