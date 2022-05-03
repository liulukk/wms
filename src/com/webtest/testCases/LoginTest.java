package com.webtest.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;
import com.webtest.utils.ReadProperties;

@Listeners(com.webtest.freemarker.GenerateReporter.class)
public class LoginTest extends BaseTest {

	@Test(priority = 1)
	public void test_login() throws InterruptedException, IOException {

		// 登录
		webtest.open(ReadProperties.getPropertyValue("base_url1"));
		Thread.sleep(2000);

		webtest.type("id=username", ReadProperties.getPropertyValue("usname"));
		webtest.type("id=passwd", ReadProperties.getPropertyValue("upasswd"));
		webtest.click("class=fa-lock");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("欢迎使用"));
	}

////	系统管理*****************
//	@Test(priority = 2, dataProvider = "status_search", dataProviderClass = NSDataProvider.class)
	public void test_status_search(String name, String sn, int index1, int index2, int index3) {
//      系统管理
		webtest.click("class=has-sub");
//		员工管理
		webtest.click("xpath=//a[@href='/user/index']");
//		检索
//		名称
		webtest.type("name=truename", name);
//		编号
		webtest.type("name=sn", sn);
//		状态
		webtest.selectByIndex("name=status", index1);
//		角色
		webtest.selectByIndex("name=role", index2);
//		所属公司
		webtest.selectByIndex("name=company", index3);
		webtest.click("xpath=//*[text()='搜 索']");
	}

//	1 sn 1 1
//	@Test(priority = 3)
	public void test_status_delete_success() {

//		删除
		webtest.click("xpath=//a[@onclick()='del('3')']");
	}

//	@Test(priority = 4, dataProvider = "status", dataProviderClass = NSDataProvider.class)
	public void test_status_add(String name, int role) throws InterruptedException {
//		添加
		webtest.click("xpath=//button[@class='btn btn-default btn-primary']");
		Thread.sleep(2000);
//		添加姓名
		webtest.type("xpath=//input[@placeholder='员工姓名']", name);
//		角色
		webtest.selectByIndex("name=role", role);
//		确定
		webtest.click("xpath=//button[text()='确定']");
	}

//	角色管理
//	@Test(priority = 5)
	public void test_roles_delete_cancel() {
//		角色
		webtest.click("xpath=//a[@href='/role/index']");
//		删除第一个****
		webtest.click("xpath=//a[@href='javascript:;']");
//		取消删除
		webtest.alertDismiss();
	}

//	@Test(priority = 6)
	public void test_roles_delete_success() {
//		角色
//		webtest.click("xpath=//a[@href='/role/index']");
//		删除第一个****
		webtest.click("xpath=//a[@href='javascript:;']");
//		确定删除
		webtest.alertAccept();
	}

//	@Test(priority = 7, dataProvider = "roles_update", dataProviderClass = NSDataProvider.class)
	public void test_roles_update(String name, String desc) {
//		编辑****
		webtest.click("xpath=//a[@href='/Role/edit/id/3']");
//		角色名称
		webtest.typeAndClear("name=name", name);
		webtest.click("id=2_anchor");
		webtest.type("name=desc", desc);
//		提交
		webtest.click("xpath=//button[text()='提交']");
//		取消
		webtest.click("xpath=//a[@href='/role/index']");

	}

//	@Test(priority = 8, dataProvider = "roles_add", dataProviderClass = NSDataProvider.class)
	public void test_roles_add_success(String name, String desc) {
//		新增****
		webtest.click("xpath=//a[@href='/role/create']");
//		角色名称
		webtest.typeAndClear("name=name", name);
		webtest.click("id=1_anchor");
		webtest.type("name=desc", desc);
//		提交
		webtest.click("xpath=//button[text()='提交']");

	}

	// 基本设置******************
//	成功chenggong 
	@Test(priority = 12)
	public void test_delete_success() throws InterruptedException {
//		driver.findElements(By.className("has-sub")).get(2).click();
//		仓库管理****************

//		webtest.click("xpath=//a[@href='/storage/index']");
//		List<WebElement> numElement = driver.findElements(By.className("title"));
//		System.out.println("0000000"+numElement.size());
//		删除第二个****
		Thread.sleep(2000);
		driver.findElements(By.xpath("//a[@ref='javascript:;']")).get(1).click();
//		取消删除
		Thread.sleep(2000);
//		webtest.alertDismiss();
//		确定删除
		webtest.alertAccept();
	}
	
//成功
	@Test(priority = 11, dataProvider = "warehourse_update", dataProviderClass = NSDataProvider.class)

	public void test_warehourse_update(String name, String contact, String phone, String desc)
			throws InterruptedException {
		Thread.sleep(2000);
//		编辑****
		driver.findElements(By.xpath("//a[@href='javascript:;']")).get(1).click();
		Thread.sleep(2000);
//		仓库名称
		driver.findElements(By.name("name")).get(1).clear();
		driver.findElements(By.name("name")).get(1).sendKeys(name);
//		联系人
		driver.findElements(By.name("contact")).get(1).clear();
		driver.findElements(By.name("contact")).get(1).sendKeys(contact);
//		手机号
		driver.findElements(By.name("phone")).get(1).clear();
		driver.findElements(By.name("phone")).get(1).sendKeys(phone);

//		仓库状态
//		driver.findElements(By.cssSelector("status")).get(1);
//		webtest.selectByIndex("status", 1);
//		备注
		driver.findElements(By.name("desc")).get(0).clear();
		driver.findElements(By.name("desc")).get(0).sendKeys(desc);
//		确定
		Thread.sleep(3000);
		driver.findElements(By.tagName("button")).get(9).click();
//		取消
//		driver.findElements(By.tagName("button")).get(8).click();
	}
//	成功
	@Test(priority = 10, dataProvider = "warehourse_add", dataProviderClass = NSDataProvider.class)
	public void test_warehourse_add(String name, String contact, String phone, String desc)
			throws InterruptedException {
//		driver.findElements(By.className("has-sub")).get(2).click();
////		仓库管理****************
		Thread.sleep(2000);
		driver.findElements(By.tagName("button")).get(1).click();
		Thread.sleep(2000);
//			仓库名称
		driver.findElements(By.name("name")).get(1).clear();
		driver.findElements(By.name("name")).get(1).sendKeys(name);
//			联系人
		driver.findElements(By.name("contact")).get(1).clear();
		driver.findElements(By.name("contact")).get(1).sendKeys(contact);
//			手机号
		driver.findElements(By.name("phone")).get(1).clear();
		driver.findElements(By.name("phone")).get(1).sendKeys(phone);
//			备注
		driver.findElements(By.name("desc")).get(0).clear();
		driver.findElements(By.name("desc")).get(0).sendKeys(desc);
//			确定
		Thread.sleep(2000);
//			取消
//		driver.findElements(By.tagName("button")).get(5).click();
//			确认
		driver.findElements(By.tagName("button")).get(6).click();
//		String mString = driver.findElement(By.className("toast toast")).getText();
//		System.out.println("----------"+mString);
	}
//成功
	@Test(priority = 9, dataProvider = "warehourse_search", dataProviderClass = NSDataProvider.class)
	public void test_warehourse_search(String name, String sn, String contact, String phone) throws InterruptedException {
//			搜索****
		driver.findElements(By.className("has-sub")).get(2).click();
		webtest.click("xpath=//a[@href='/storage/index']");
//		仓库管理****************
		Thread.sleep(2000);
		webtest.type("name=name", name);
		webtest.type("name=sn", sn);
		webtest.type("name=contact", contact);
		webtest.type("name=phone", phone);
//			仓库状态
//			webtest.selectByIndex("status", 0);
//			检索确认
		Thread.sleep(2000);
//		List<WebElement> list=driver.findElements(By.tagName("button"));
//		System.out.println(list.size());
		driver.findElements(By.tagName("button")).get(3).click();
	}
	
	/*
//		库位管理***********成功
//	成功
	@Test(priority = 16, dataProvider = "strongeSpace_search", dataProviderClass = NSDataProvider.class)
	public void test_storageSpace_search(String name, String sn) throws InterruptedException {
		
		
//			搜索
		webtest.type("name=name", name);
		webtest.type("name=sn", sn);
//			检索确认
		Thread.sleep(3000);
//		List<WebElement> list=driver.findElements(By.tagName("button"));
//		System.out.println(list.size());
		driver.findElements(By.tagName("button")).get(3).click();
//			false
	}

	@Test(priority = 13, dataProvider = "strongeSpace_add", dataProviderClass = NSDataProvider.class)
	public void test_storageSpace_add(String name, String desc) throws InterruptedException {
		webtest.click("xpath=//a[@href='/location/index']");
//			添加
		driver.findElements(By.tagName("button")).get(1).click();
//			库位名称
		Thread.sleep(2000);
		driver.findElements(By.name("name")).get(1).clear();
		driver.findElements(By.name("name")).get(1).sendKeys(name);
//			备注
		driver.findElements(By.name("desc")).get(0).clear();
		driver.findElements(By.name("desc")).get(0).sendKeys(desc);

		Thread.sleep(2000);
//			取消
//		webtest.click("xpath=//button[text()='取消']");
//			确认
			webtest.click("xpath=//button[@onclick='add_from()']");		
	}

	@Test(priority = 15)
	public void test_strongSpace_delete() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElements(By.xpath("//a[@ref='javascript:;']")).get(2).click();
//			取消删除
//		webtest.alertDismiss();
//			确定删除
			webtest.alertAccept();
	}
	
	@Test(priority = 14, dataProvider = "strongeSpace_update", dataProviderClass = NSDataProvider.class)
	public void test_strongSpace_update(String name, String textarea) throws InterruptedException {
//			编辑****

		driver.findElements(By.xpath("//a[@href='javascript:;']")).get(2).click();
//		List<WebElement> numElement = driver.findElements(By.name("name"));
//		System.out.println("name" + numElement.size());
//			库位名称
		Thread.sleep(3000);
		driver.findElements(By.name("name")).get(1).clear();
		driver.findElements(By.name("name")).get(1).sendKeys(name);
//			备注
		driver.findElement(By.xpath("//textarea[@placeholder='备注']")).sendKeys(textarea);
		Thread.sleep(3000);
//			取消
//			webtest.click("xpath=//button[text()='取消']");	
//			false
//			确认
		webtest.click("xpath=//button[@onclick='edit_from()']");

	}
	
	
	@Test(priority = 20, dataProvider = "Suppliers_search", dataProviderClass = NSDataProvider.class)
	public void test_Suppliers_search(String name, String sn, String contact, String phone, String email)
			throws InterruptedException {
	
//			搜索****
		webtest.type("name=name", name);// 供应商名称
		webtest.type("name=sn", sn);// 供应商编号
		webtest.type("name=contact", contact);// 联系人
		webtest.type("name=phone", phone);// 手机号
		webtest.type("name=email", email);// 邮箱

//			检索确认
		Thread.sleep(3000);
		driver.findElements(By.tagName("button")).get(3).click();
	}
//	nameSearch 99999编号 contact 129099 123@qq.com
	
	@Test(priority = 17, dataProvider = "Suppliers_add", dataProviderClass = NSDataProvider.class)
	public void test_Suppliers_add(String name, String address, String contact, String phone, String email, String fax,
			String desc) throws InterruptedException {
		Thread.sleep(2000);
//		供应商管理
	webtest.click("xpath=//a[@href='/supplier/index']");
//			添加
		driver.findElements(By.tagName("button")).get(1).click();
//			供应商名称
		Thread.sleep(3000);
		driver.findElements(By.name("name")).get(1).clear();
		driver.findElements(By.name("name")).get(1).sendKeys(name);
		driver.findElements(By.name("address")).get(0).clear();
		driver.findElements(By.name("address")).get(0).sendKeys(address);
		driver.findElements(By.name("contact")).get(1).clear();
		driver.findElements(By.name("contact")).get(1).sendKeys(contact);
		driver.findElements(By.name("phone")).get(1).clear();
		driver.findElements(By.name("phone")).get(1).sendKeys(phone);
		driver.findElements(By.name("email")).get(1).clear();
		driver.findElements(By.name("email")).get(1).sendKeys(email);
		driver.findElements(By.name("fax")).get(0).clear();
		driver.findElements(By.name("fax")).get(0).sendKeys(fax);
		driver.findElement(By.xpath("//textarea[@placeholder='备注']")).sendKeys(desc);
		Thread.sleep(3000);
//			取消
//			webtest.click("xpath=//button[text()='取消']");	
//			false
//			确认
		webtest.click("xpath=//button[@onclick='add_from()']");

	}
	
//	"添加供应商test" "添加供应商地址test" "添加供应商联系人test" "111111" "123@qq.com" "传真" "beizhu"
	@Test(priority = 18, dataProvider = "Suppliers_update", dataProviderClass = NSDataProvider.class)
	public void test_Suppliers_update(String desc) throws InterruptedException {
//			编辑
		driver.findElements(By.xpath("//a[@href='javascript:;']")).get(3).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@placeholder='备注']")).sendKeys(desc);
		Thread.sleep(3000);
//			取消
//			webtest.click("xpath=//button[text()='取消']");	
//			**
//			确认
		webtest.click("xpath=//button[@onclick='edit_from()']");

	}
	
	@Test(priority = 19)
	public void test_Suppliers_delete() throws InterruptedException {
//			删除
		Thread.sleep(2000);
//			删除第二个****
		driver.findElements(By.xpath("//a[@ref='javascript:;']")).get(3).click();
//			取消删除
//		webtest.alertDismiss();
//			确定删除
		Thread.sleep(2000);
		webtest.alertAccept();
	}
	
	
	@Test(priority = 24, dataProvider = "unit_search", dataProviderClass = NSDataProvider.class)
	public void test_Unit_search(String name, String sn) throws InterruptedException {
//			计量单位(********
		
		webtest.type("name=name", name);// 单位名称
		webtest.type("name=sn", sn);// 单位编号
//			检索确认
		Thread.sleep(3000);
		driver.findElements(By.tagName("button")).get(3).click();
	}

	@Test(priority = 21, dataProvider = "unit_add", dataProviderClass = NSDataProvider.class)
	public void test_Unit_add(String name, String desc) throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//a[@href='/unit/index']");
		driver.findElements(By.tagName("button")).get(1).click();
		Thread.sleep(2000);
		driver.findElements(By.name("name")).get(1).clear();
		driver.findElements(By.name("name")).get(1).sendKeys(name);
		driver.findElement(By.xpath("//textarea[@placeholder='备注']")).sendKeys(desc);
		Thread.sleep(3000);
//			取消
//			webtest.click("xpath=//button[text()='取消']");	
//			**
//			确认
		webtest.click("xpath=//button[@onclick='add_from()']");
	}
	
	@Test(priority = 22, dataProvider = "unit_update", dataProviderClass = NSDataProvider.class)
	public void test_Unit_alert(String desc) throws InterruptedException {
		driver.findElements(By.xpath("//a[@href='javascript:;']")).get(5).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@placeholder='备注']")).sendKeys(desc);
		Thread.sleep(3000);
//			取消
//			webtest.click("xpath=//button[text()='取消']");	
//			false
//			确认
		webtest.click("xpath=//button[@onclick='edit_from()']");
	}

//		客户管理*********
//		webtest.click("xpath=//a[@href='/customer/index']");

	@Test(priority = 23)
	public void test_Unit_delete() {
//			删除第二个****
		driver.findElements(By.xpath("//a[@ref='javascript:;']")).get(5).click();
//			取消删除
//		webtest.alertDismiss();
//			确定删除
		webtest.alertAccept();
	}
	
	
	@Test(priority = 28, dataProvider = "Category_search", dataProviderClass = NSDataProvider.class)
	public void test_productCategory_search(String name, String sn) throws InterruptedException {

//			搜索****

		webtest.type("name=name", name);// 产品类别名称
		webtest.type("name=sn", sn);// 编号
//			检索确认
		Thread.sleep(3000);
		driver.findElements(By.tagName("button")).get(3).click();

	}

	@Test(priority = 25, dataProvider = "Category_add", dataProviderClass = NSDataProvider.class)
	public void test_productCategory_add(String name, String desc) throws InterruptedException {
//			添加****
//			产品类别
		webtest.click("xpath=//a[@href='/category/index']");
		Thread.sleep(2000);
		driver.findElements(By.tagName("button")).get(1).click();
		Thread.sleep(2000);
		driver.findElements(By.name("name")).get(1).clear();
		driver.findElements(By.name("name")).get(1).sendKeys(name);
		driver.findElement(By.xpath("//textarea[@placeholder='备注']")).sendKeys(desc);
		Thread.sleep(3000);
//			取消
//			webtest.click("xpath=//button[text()='取消']");	
//			确认
		webtest.click("xpath=//button[@onclick='add_from()']");
	}

	@Test(priority = 26, dataProvider = "Category_update", dataProviderClass = NSDataProvider.class)
	public void test_productCategory_update(String desc) throws InterruptedException {
		driver.findElements(By.xpath("//a[@href='javascript:;']")).get(3).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@placeholder='备注']")).sendKeys(desc);
		Thread.sleep(3000);
//			取消
//			webtest.click("xpath=//button[text()='取消']");	
//			
//			确认
		webtest.click("xpath=//button[@onclick='edit_from()']");
	}

	@Test(priority = 27)
	public void test_productCategory_delete() {
//			删除第二个****
		driver.findElements(By.xpath("//a[@ref='javascript:;']")).get(3).click();
//			取消删除
//		webtest.alertDismiss();
//			确定删除
		webtest.alertAccept();
	}
	
	
	@Test(priority = 29, dataProvider = "Management_search", dataProviderClass = NSDataProvider.class)
	public void test_productManagement_search(String name, String sn) throws InterruptedException {
		webtest.click("xpath=//a[@href='/product/index']");
//			搜索****

		webtest.type("name=name", name);// 产品名称
		webtest.type("name=sn", sn);// 编号
//			检索确认
		Thread.sleep(3000);
		driver.findElements(By.tagName("button")).get(4).click();

	}

	@Test(priority = 30, dataProvider = "Management_add", dataProviderClass = NSDataProvider.class)
	public void test_productManagement_add(String name, String desc) throws InterruptedException {
//			添加****

		driver.findElements(By.tagName("button")).get(1).click();
		Thread.sleep(2000);
		driver.findElements(By.name("name")).get(1).clear();
		driver.findElements(By.name("name")).get(1).sendKeys(name);
		driver.findElement(By.xpath("//textarea[@placeholder='备注']")).sendKeys(desc);
		Thread.sleep(3000);
//			取消
//			webtest.click("xpath=//button[text()='取消']");	
//			**
//			确认
		webtest.click("xpath=//button[@onclick='add_from()']");
	}

	@Test(priority = 31, dataProvider = "Management_update", dataProviderClass = NSDataProvider.class)
	public void test_productManagement_update(String desc) throws InterruptedException {
		driver.findElements(By.xpath("//a[@href='javascript:;']")).get(2).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@placeholder='备注']")).sendKeys(desc);
		Thread.sleep(3000);
//			取消
//			webtest.click("xpath=//button[text()='取消']");	
//			
//			确认
		webtest.click("xpath=//button[@onclick='edit_from()']");
	}

	@Test(priority = 32)
	public void test_productManagement_delete() throws InterruptedException {
//			删除第二个****
		driver.findElements(By.xpath("//a[@ref='javascript:;']")).get(2).click();
		Thread.sleep(2000);
//			取消删除
//		webtest.alertDismiss();
//			确定删除
		webtest.alertAccept();
	}
	
	
	@Test(priority = 36, dataProvider = "companyManagent_search", dataProviderClass = NSDataProvider.class)
	public void test_companyManagent_search(String name, String sn, String tel, String email)
			throws InterruptedException {

//			搜索****
		webtest.type("name=name", name);// 企业名称
		webtest.type("name=sn", tel);// 企业编号
		webtest.type("name=tel", tel);// 企业电话
		webtest.type("name=eamil", email);// 企业邮箱
		Thread.sleep(3000);
		driver.findElements(By.tagName("button")).get(3).click();
	}

	@Test(priority = 33, dataProvider = "companyManagent_add", dataProviderClass = NSDataProvider.class)
	public void test_companyManagent_add(String name, String tel, String email, String address)
			throws InterruptedException {
			//			企业管理**************
		webtest.click("xpath=//a[@href='/company/index']");
//			添加********

		driver.findElements(By.tagName("button")).get(1).click();

		Thread.sleep(2000);
		driver.findElements(By.name("name")).get(1).clear();
		driver.findElements(By.name("name")).get(1).sendKeys(name);// 企业名称
		driver.findElements(By.name("tel")).get(1).clear();
		driver.findElements(By.name("tel")).get(1).sendKeys(tel);// 企业电话
		driver.findElements(By.name("email")).get(0).clear();
		driver.findElements(By.name("email")).get(0).sendKeys(email);// 企业邮箱
		driver.findElements(By.name("address")).get(0).clear();
		driver.findElements(By.name("address")).get(0).sendKeys(address);// 企业地址

		driver.findElement(By.xpath("//textarea[@placeholder='备注']")).sendKeys("企业beizhu");
		Thread.sleep(3000);
//			取消
//			webtest.click("xpath=//button[text()='取消']");	
//			**
//			确认
		webtest.click("xpath=//button[@onclick='add_from()']");

	}

	@Test(priority = 34, dataProvider = "companyManagent_update", dataProviderClass = NSDataProvider.class)
	public void test_companyManagent_update(String name, String tel, String email, String address, String desc)
			throws InterruptedException {
//			修改****
		driver.findElements(By.xpath("//a[@href='javascript:;']")).get(5).click();
		Thread.sleep(2000);
		driver.findElements(By.name("name")).get(1).clear();
		driver.findElements(By.name("name")).get(1).sendKeys(name);// 企业名称
		driver.findElements(By.name("tel")).get(1).clear();
		driver.findElements(By.name("tel")).get(1).sendKeys(tel);// 企业电话
		driver.findElements(By.name("email")).get(0).clear();
		driver.findElements(By.name("email")).get(0).sendKeys(email);// 企业邮箱
		driver.findElements(By.name("address")).get(0).clear();
		driver.findElements(By.name("address")).get(0).sendKeys(address);// 企业地址
		driver.findElement(By.xpath("//textarea[@placeholder='备注']")).sendKeys(desc);
		Thread.sleep(3000);
//			取消
//			webtest.click("xpath=//button[text()='取消']");	
//			
//			确认
		webtest.click("xpath=//button[@onclick='edit_from()']");
	}

	@Test(priority = 35)
	public void test_companyManagent_delete() throws InterruptedException {
//			删除第二个****
		driver.findElements(By.xpath("//a[@ref='javascript:;']")).get(5).click();
//			取消删除
//		webtest.alertDismiss();
//			确定删除
		Thread.sleep(2000);
		webtest.alertAccept();
	}
	
	
	@Test(priority = 37, dataProvider = "shelvesManagent_search", dataProviderClass = NSDataProvider.class)
	public void test_shelvesManagent_search(String name, String sn, String index1, String index2) throws InterruptedException {
//			货架管理***********
		webtest.click("xpath=//a[@href='/shelve/index']");
//			搜索****
		Thread.sleep(2000);
		webtest.type("name=name", name);// 货架名称
		webtest.type("name=sn", sn);// 货架编号
		System.out.println(Integer.parseInt(index1)+""+Integer.parseInt(index2));
//		webtest.selectByIndex("location", Integer.parseInt(index1));
//		webtest.selectByIndex("status", Integer.parseInt(index2));
		
		driver.findElements(By.tagName("button")).get(3).click();
		
	}

	@Test(priority = 38, dataProvider = "shelvesManagent_add", dataProviderClass = NSDataProvider.class)
	public void test_shelvesManagent_add(String name, String desc) throws InterruptedException {
//			新增*******

		driver.findElements(By.tagName("button")).get(1).click();

		Thread.sleep(2000);
		driver.findElements(By.name("name")).get(1).clear();
		driver.findElements(By.name("name")).get(1).sendKeys(name);// 企业名称
		driver.findElement(By.xpath("//textarea[@placeholder='备注']")).sendKeys(desc);
		Thread.sleep(3000);
//			取消
//			webtest.click("xpath=//button[text()='取消']");	
//			
//			确认
		webtest.click("xpath=//button[@onclick='add_from()']");

	}

	@Test(priority = 39, dataProvider = "shelvesManagent_update", dataProviderClass = NSDataProvider.class)
	public void test_shelvesManagent_update(String name, String desc) throws InterruptedException {
//			编辑****

		driver.findElements(By.xpath("//a[@href='javascript:;']")).get(2).click();
		Thread.sleep(2000);
		driver.findElements(By.name("name")).get(1).clear();
		driver.findElements(By.name("name")).get(1).sendKeys(name);// 货架名称

		driver.findElement(By.xpath("//textarea[@placeholder='备注']")).sendKeys(desc);
		Thread.sleep(3000);
//			取消
//			webtest.click("xpath=//button[text()='取消']");	
//			
//			确认
		webtest.click("xpath=//button[@onclick='edit_from()']");

	}

	@Test(priority = 40)
	public void test_shelvesManagent_delete() {
//			删除第二个****
		driver.findElements(By.xpath("//a[@ref='javascript:;']")).get(2).click();
//			取消删除
//		webtest.alertDismiss();
//			确定删除
		webtest.alertAccept();
	}
	*/

}
