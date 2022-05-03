package www.ourhouse.testng_xslt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.xml.XmlSuite;

import com.webtest.freemarker.ReporterData;
import com.webtest.mail.MailUtil;
import com.webtest.utils.ReadProperties;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
@SuppressWarnings("unchecked")
public class Generate implements IReporter{

	private String getHtmlByPageName(String pageName) throws IOException {
	    // /BOOT-INF/classes/templates/dashboard.html
	    String path = "D:\\java\\wms\\target\\" + pageName + ".html";
	    // 返回读取指定资源的输入流
//	    InputStream is = this.getClass().getResourceAsStream(path);
	    FileInputStream is=new FileInputStream(path);
	    BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
	    String s = "";
	    StringBuffer stringBuffer = new StringBuffer();
	    while ((s = br.readLine()) != null) {
	        stringBuffer.append(s).append("\n");
	    }
	    return stringBuffer.toString();
	   
	}
	@Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
                               String outputDirectory)  {
		String string;
		try {
			string = getHtmlByPageName("index1");
			System.out.println(string);
			MailUtil.TOmail(string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
   
	
