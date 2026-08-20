package com.orangeHRMcucumber.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

    String path = System.getProperty("user.dir")+ "/src/test/resources/testData/UserData.xlsx";
	FileInputStream fs;
	Workbook wb;
    
    public void WriteExcel(List<Map<String,String>> data) throws EncryptedDocumentException, IOException {
		fs = new FileInputStream(path);
		wb = WorkbookFactory.create(fs);
		Sheet sheet = wb.getSheet("Sheet1");
		int rownum = 0;
		Row header = sheet.createRow(rownum++);
		
		int cellnum = 0;
		for (String key : data.get(0).keySet()) {
			 header.createCell(cellnum++).setCellValue(key);
		}
		
		  for(Map<String,String> map : data){

		        Row row = sheet.createRow(rownum++);
		        cellnum = 0;

		        for(String value : map.values()){
		            row.createCell(cellnum++).setCellValue(value);
		        }
		    }
		  FileOutputStream fos = new FileOutputStream(path);
		    wb.write(fos);

		    fos.close();
		    wb.close();
	}

    public List<Map<String,String>>  readexceldata() throws EncryptedDocumentException, IOException {
		fs = new FileInputStream(path);
		wb = WorkbookFactory.create(fs);
		Sheet sheet = wb.getSheet("Sheet2");
		List<Map<String,String>> data = new ArrayList<>();
		Row headerRow = sheet.getRow(0);
		
		  for(int i=1;i<=sheet.getLastRowNum();i++){
		        Row row = sheet.getRow(i);
		        Map<String,String> map = new HashMap<>();

		        for(int j=0;j<headerRow.getLastCellNum();j++){
		            String key = headerRow.getCell(j).toString();
		            Cell cell = row.getCell(j);
		            String value = "";

		            if(cell != null) {
		                value = cell.toString();
		            }

		            map.put(key,value);
		        }
		        data.add(map);
	}
		  System.out.println(data);
		    return data;

	}

}
