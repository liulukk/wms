package com.webtest.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NSDataProvider {

	
	@DataProvider(name="warehourse_search")
	public  Object[][] getTxtData() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/test.txt");
	}
	@DataProvider(name="warehourse_add")
	public  Object[][] getTxtData1() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/warehourse_add.txt");
	}
	@DataProvider(name="warehourse_update")
	public  Object[][] getTxtData2() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/warehourse_update.txt");
	}
	@DataProvider(name="strongeSpace_search")
	public  Object[][] getTxtData3() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/strongeSpace_search.txt");
	}
	@DataProvider(name="strongeSpace_add")
	public  Object[][] getTxtData4() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/strongeSpace_add.txt");
	}
	@DataProvider(name="strongeSpace_update")
	public  Object[][] getTxtData5() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/strongeSpace_update.txt");
	}
	@DataProvider(name="Suppliers_search")
	public  Object[][] getTxtData6() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/Suppliers_search.txt");
	}
	@DataProvider(name="Suppliers_add")
	public  Object[][] getTxtData7() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/Suppliers_add.txt");
	}
	@DataProvider(name="Suppliers_update")
	public  Object[][] getTxtData8() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/Suppliers_update.txt");
	}
	@DataProvider(name="unit_search")
	public  Object[][] getTxtData9() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/unit_search.txt");
	}
	@DataProvider(name="unit_add")
	public  Object[][] getTxtData10() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/unit_add.txt");
	}
	@DataProvider(name="unit_update")
	public  Object[][] getTxtData11() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/unit_update.txt");
	}
	@DataProvider(name="Category_update")
	public  Object[][] getTxtData12() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/Category_update.txt");
	}
	@DataProvider(name="Category_add")
	public  Object[][] getTxtData13() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/Category_add.txt");
	}
	@DataProvider(name="Category_search")
	public  Object[][] getTxtData14() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/Category_search.txt");
	}
	@DataProvider(name="Management_update")
	public  Object[][] getTxtData15() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/Management_update.txt");
	}
	@DataProvider(name="Management_add")
	public  Object[][] getTxtData16() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/Management_add.txt");
	}
	@DataProvider(name="Management_search")
	public  Object[][] getTxtData17() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/Management_search.txt");
	}
	@DataProvider(name="companyManagent_update")
	public  Object[][] getTxtData18() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/companyManagent_update.txt");
	}
	@DataProvider(name="companyManagent_add")
	public  Object[][] getTxtData19() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/companyManagent_add.txt");
	}
	@DataProvider(name="companyManagent_search")
	public  Object[][] getTxtData20() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/companyManagent_search.txt");
	}
	@DataProvider(name="shelvesManagent_update")
	public  Object[][] getTxtData21() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/shelvesManagent_update.txt");
	}
	@DataProvider(name="shelvesManagent_add")
	public  Object[][] getTxtData22() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/shelvesManagent_add.txt");
	}
	@DataProvider(name="shelvesManagent_search")
	public  Object[][] getTxtData23() throws IOException{
		return new  TxtDataProvider().getTxtUser("data/shelvesManagent_search.txt");
	}
	
	
	
	
	
	@DataProvider(name="movie")
	public  Object[][] getMovieData() throws IOException{
		return new  ExcelDataProvider().getTestDataByExcel("data/movie.xlxs","Sheet1");
	}
	@Test(dataProvider="txt")
	public void getData(String a,String b) {
		System.out.println(a+" "+b);
		
	}
	@DataProvider(name="excel")
	public Object[][] getExcelDada() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("data/user.xlsx","Sheet1");
	}
	
	@DataProvider(name="mysql")
	public Object[][] getMysqlDada() throws IOException{
		return new MysqlDataProvider().getTestDataByMysql("SELECT filmname, petname\r\n" + 
				"FROM `mm_movie` ");
	}
	
	@Test(dataProvider="mysql")
	public void testDB(String a,String b) {
		System.out.println(a+" "+b);
	}
	
}
