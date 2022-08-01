import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class prueba_técnica {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abdis\\Downloads\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		try {
			//Login-------------------------------
			driver.get("http://ksms.mx/libertadqa/login/auth?format=");
			driver.manage().window().maximize();
			System.out.println("1.- Se accedió correctamente a la página");
			Thread.sleep(2000);
			WebElement user = driver.findElement(By.xpath("//input[@class=\"inputs emailInput lightGray letterspacing1 font14\"]"));
			WebElement pass = driver.findElement(By.xpath("//input[@class=\"inputs passwordInput lightGray letterspacing1 font14\"]"));
			WebElement login = driver.findElement(By.xpath("//button[@class=\"loginButton blueButton letterspacing2 font14\"]"));
			user.sendKeys("tester");
			//Thread.sleep(1000);
			pass.sendKeys("Mexico.2079");
			//Thread.sleep(1000);
			login.click();
			System.out.println("2.- Login correcto");
			Thread.sleep(1000);
			
			//Perfilador----------------------------------------
			WebElement perfilador = driver.findElement(By.xpath("(//div[@class=\"icon-item init\"])"));
			perfilador.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id=\"clienteNo\"]")).click();
			//Thread.sleep(1000);
			WebElement combo1 = driver.findElement(By.xpath("//select[@id='tipoDeDocumento']"));
			org.openqa.selenium.support.ui.Select c = new org.openqa.selenium.support.ui.Select (combo1);
			int num1 = (int) (Math.random() * 11) + 1;
			c.selectByIndex(num1);
			//Thread.sleep(1000);
			WebElement next = driver.findElement(By.xpath("//input[@id='avanzarPerfilador']"));
			next.click();
			System.out.println("3.- Perfilador completado correctamente");
			Thread.sleep(1000);
			
			
			//Ingresar datos personales-------------------------------------------------------
			WebElement name            = driver.findElement(By.xpath("(//input[@class='form-control validate campoFormulario required only-letters'])[1]"));
			WebElement second_name     = driver.findElement(By.xpath("//input[@class='form-control validate campoFormulario nonRequired only-letters']"));
			WebElement last_name1      = driver.findElement(By.xpath("(//input[@class='form-control validate campoFormulario required only-letters'])[2]"));
			WebElement last_name2      = driver.findElement(By.xpath("(//input[@class='form-control validate campoFormulario required only-letters'])[3]"));
			WebElement mail            = driver.findElement(By.xpath("(//input[@class='form-control validate campoFormulario required'])[1]"));
			WebElement phone           = driver.findElement(By.xpath("(//input[@class='form-control validate campoFormulario required'])[2]"));
			WebElement phone_home      = driver.findElement(By.xpath("//input[@class='form-control validate campoFormulario nonRequired']"));
			WebElement combo_day       = driver.findElement(By.xpath("(//select)[1]"));
			WebElement combo_month     = driver.findElement(By.xpath("(//select)[2]"));
			WebElement combo_year      = driver.findElement(By.xpath("(//select)[3]"));
			WebElement combo_gender    = driver.findElement(By.xpath("(//select)[4]"));
			WebElement combo_country   = driver.findElement(By.xpath("(//select)[5]"));
			WebElement combo_state     = driver.findElement(By.xpath("(//select)[6]"));
			//WebElement curp            = driver.findElement(By.xpath("(//input[@class='form-control validate campoFormulario required '])[2]"));
			//WebElement rfc             = driver.findElement(By.xpath("(//input[@class='form-control validate campoFormulario required '])[3]"));
			WebElement sms_code        = driver.findElement(By.xpath("(//input[@class='form-control validate campoFormulario required '])[1]"));
			
			name.sendKeys("Test");
			second_name.sendKeys("Test");
			last_name1.sendKeys("Test");
			last_name2.sendKeys("Test");
			mail.sendKeys("test@test.com");
			//Selección aleatoria de opciones de combobox
			
			int num2 = (int) (Math.random() * 9) + 1;
			
			/*
			phone_home.sendKeys(phone1);
			*/
			for(int i=0;i<11;i++) {
				String phone1 = Integer.toString(num2);
				phone_home.sendKeys(phone1);
				num2 = (int) (Math.random() * 9) + 1;
				//System.out.println(num2);
				Thread.sleep(500);
			}
			
			org.openqa.selenium.support.ui.Select dias = new org.openqa.selenium.support.ui.Select (combo_day);
			int days = (int) (Math.random() * 28) + 1;
			dias.selectByIndex(days);
			org.openqa.selenium.support.ui.Select meses = new org.openqa.selenium.support.ui.Select (combo_month);
			int months = (int) (Math.random() * 12) + 1;
			meses.selectByIndex(months);
			org.openqa.selenium.support.ui.Select años = new org.openqa.selenium.support.ui.Select (combo_year);
			int years = (int) (Math.random() * 40) + 1;
			años.selectByIndex(years);
			org.openqa.selenium.support.ui.Select genero = new org.openqa.selenium.support.ui.Select (combo_gender);
			int gender = (int) (Math.random() * 2) + 1;
			genero.selectByIndex(gender);
			org.openqa.selenium.support.ui.Select pais = new org.openqa.selenium.support.ui.Select (combo_country);
			int country = (int) (Math.random() * 193) + 1;
			pais.selectByIndex(country);
			org.openqa.selenium.support.ui.Select estado = new org.openqa.selenium.support.ui.Select (combo_state);
			int state = (int) (Math.random() * 32) + 1;
			estado.selectByIndex(state);
			Thread.sleep(1000);
			//Selección de número telefónico
			//phone.sendKeys(phone1);
			//System.out.println("Ingreso de número telefónico");
			for(int i=0;i<11;i++) {
				String phone1 = Integer.toString(num2);
				phone.sendKeys(phone1);
				num2 = (int) (Math.random() * 9) + 1;
				//System.out.println(num2);
				Thread.sleep(500);
			}
			sms_code.click();
			Thread.sleep(10000);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			Thread.sleep(10000);
			//driver.findElement(By.xpath("//button[@class=\"confirm\"]")).click();
			sms_code.click();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Hubo un problema");
		} finally {
			driver.findElement(By.xpath("//button[@id=\"userOptionsBtn\"]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//a[@class=\"link\"])[3]")).click();
			Thread.sleep(1000);
			driver.close();
		}

	}

}
