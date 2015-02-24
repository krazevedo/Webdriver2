package com.ciandt.selenium.helpers;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.ciandt.selenium.regressao.CreateCND;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class DataDriven {
	static WritableSheet writesheet;
	static Sheet readsheet;
	static Workbook readbook;
	static Workbook readbook2;
	static WritableWorkbook writebook;
	static Geral geral = new Geral();
	static File myfile = new File("C:\\Users\\kaior\\workspace\\testCreate\\resources\\cnds_criadas.xls");


	public static void writereport(String []nomeCND, String []emailCND ) 
	{ 
		try
		{				
				File myfile = new File("C:\\Users\\kaior\\workspace\\testCreate\\resources\\cnds_criadas.xls");
				FileOutputStream fi = new FileOutputStream(myfile);
				writebook = Workbook.createWorkbook(fi); 
				writesheet = writebook.createSheet("output", 0);				
										
			for (int i = 0; i < CreateCND.i; i++){
				
				Label l = new Label(0, i, nomeCND[i]);
				Label l2 = new Label(1, i, emailCND[i]);
				writesheet.addCell(l);
				writesheet.addCell(l2);						
			}
			writebook.write(); 
			writebook.close(); 			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void readreport() 
	{ 
		try
		{	
			File myfile = new File("C:\\Users\\kaior\\workspace\\testCreate\\resources\\cnds_criadas.xls");
			FileInputStream fis = new FileInputStream(myfile);
			readbook = Workbook.getWorkbook(fis); 
			readsheet = readbook.getSheet(0);
			String a[][] = new String[readsheet.getRows()][readsheet.getColumns()];
			for (int i = 0; i < readsheet.getRows(); i++){
				for (int j = 0; j < readsheet.getColumns(); j++){
					a[i][j] = readsheet.getCell(j, i).getContents();
				}
			}			
		}	
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static int rowCount()
	{
		return readsheet.getRows();
	}

	public static String readCell(int column,int row)
	{
		return readsheet.getCell(column,row).getContents();
	}

	public void deleteExcel(){
		File fis = new File("C:\\Users\\kaior\\workspace\\testCreate\\resources\\cnds_criadas.xls");
		fis.isFile();
		System.gc();
		fis.delete();

	}
}
