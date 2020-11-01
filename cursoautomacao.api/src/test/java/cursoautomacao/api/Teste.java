package cursoautomacao.api;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;


public class Teste extends BaseTest{

	@Test
	
	public void teste() {
		
		Response resp;
		int code;
		String corpo;
		test = extent.createTest("Meu primeiro teste");
		resp = RestAssured.get("http://www.meutimao.com.br");
		code = resp.getStatusCode();
		corpo = resp.asString();
		Assert.assertEquals(code, 200);
		int convertStatus = code;
		test.info("Status Code: "+ String.valueOf(convertStatus));
		test.info("Corpo: "+ corpo);
		
		
		
	}
	
// @Test
	
	public void teste2() {
		
		Response resp;
		int code;
		String corpo;
		test = extent.createTest("Meu primeiro teste");
		resp = RestAssured.get("http://www.meutimao.com.br");
		code = resp.getStatusCode();
		corpo = resp.asString();
		Assert.assertEquals(code, 301);
		int convertStatus = code;
		test.info("Status Code: "+ String.valueOf(convertStatus));
		test.info("Corpo: "+ corpo);
}	

}
