package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public  static String getData(String p,String s,int r,int c) {
		String v="";
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(p));
			v=wb.getSheet(s).getRow(r).getCell(c).toString();
		}
		catch(Exception e) {}
		return v;
	}
	public static int getRowCount(String p,String s) {
		int rc=0;
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(p));
			rc=wb.getSheet(s).getLastRowNum();	
		}
		catch(Exception e){}
		return rc;	
	}
	public static int getColumnCount(String p,String s,int r) {
		int cc=0;
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(p));
			cc=wb.getSheet(s).getRow(r).getLastCellNum();	
		}
		catch(Exception e){}
		return cc;	
	}
}

