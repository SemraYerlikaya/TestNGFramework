package com.techproed.tests;
import com.techproed.pages.AmazonPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonAramaTest extends TestBaseFinal{
    @Test
    public void amazonTest() throws InterruptedException {
        extentTest = extentReports.createTest("Amazon Test", "Amazondan camera secme");
        extentTest.info("Amazon.com a gidiyoruz");
        Driver.getDriver().get(ConfigurationReader.getProperty("amazon_link"));

        extentTest.info("AmazonPage den nesne uretiyoruz");
        AmazonPage amazonPage = new AmazonPage();

        extentTest.info("Arama kutusuna " + ConfigurationReader.getProperty("aranilacak_kelime") + " kelimesini yaz");
        amazonPage.aramaKutusu.sendKeys(ConfigurationReader.getProperty("aranilacak_kelime")+ Keys.ENTER);

        extentTest.info("sonucBolumu'nun icerisindeki yazilari alalim");
        String yazilar = amazonPage.sonucBolumu.getText();

        extentTest.info("Assert islemi yapiyoruz");

        Assert.assertTrue(yazilar.contains(ConfigurationReader.getProperty("aranilacak_kelime")));
        System.out.print;n("Denene");
        extentTest.pass("Testimiz PASSED !");
    }

}
