package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static FileInputStream file;
	public static XSSFWorkbook wb;
	private static XSSFSheet ws;
	private static XSSFRow row;
	private static XSSFCell cell;
	private static FileOutputStream fo;
	private static XSSFCellStyle style;
	String path;
	
	public ExcelUtility(String path) {
		this.path =path;
	}

	public int getRowcount(String xlsheet) throws IOException {
		
		file = new FileInputStream(path);
		wb = new XSSFWorkbook(file);
		ws = wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		file.close();
		
		return rowcount;
	}
	
	public int getCellCount(String xlsheet, int rownum) throws IOException {
		file = new FileInputStream(path);
		wb = new XSSFWorkbook(file);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		file.close();
		return cellcount;
		
	}
	public String getCellData(String xlsheet, int rownum,int colnum) throws IOException {
		file = new FileInputStream(path);
		wb = new XSSFWorkbook(file);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		String data;
		try {
			//data = cell.toString();
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);
		}
		catch (Exception e) {
			data = "";
		}
		wb.close();
		file.close();
		return data ;
	}
	public void setCellData(String xlsheet, int rownum,int colnum, String data) throws IOException {
		File xlfile = new File(path);
		if(!xlfile.exists()) { // if the file does not exists create new file
			wb = new XSSFWorkbook();
			fo= new FileOutputStream(path);
			wb.write(fo);
		}
		file = new FileInputStream(path);
		wb = new XSSFWorkbook(file);
		
		if (wb.getSheetIndex(xlsheet)==-1)
			wb.createSheet(xlsheet);
		
		ws = wb.getSheet(xlsheet);
		
		if (ws.getRow(rownum)==null) // if row does not exists create new row
			ws.createRow(rownum);
		
		row = ws.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo= new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		file.close();
		fo.close();
	}
	public static void fillGreenColor(String xlfile, String xlsheet, int rownum,int colnum) throws IOException {
		file = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(file);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo= new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		file.close();
		fo.close();
		
	}
	public static void fillRedColor(String xlfile, String xlsheet, int rownum,int colnum) throws IOException {
		file = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(file);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo= new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		file.close();
		fo.close();
		
	}

}

