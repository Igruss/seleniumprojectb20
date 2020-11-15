package com.cybertek.tests.day14_excel_IO;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

public class ReadExelFile2 {

    public static void main(String[] args) throws IOException {

        String filePath = "vytrack_testusers.xlsx";
        File file = new File(filePath);
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet("QA3-short");

        int rowNum = sheet.getLastRowNum();
        int colNum = sheet.getRow(0).getLastCellNum();

        for(int rowIndex =0; rowIndex <= rowNum ; rowIndex ++){
            for(int columnIndex =0; columnIndex < colNum ; columnIndex++){
                String value = sheet.getRow(rowIndex).getCell(columnIndex).getStringCellValue();
                System.out.printf("%10s  ",value + " ");
            }
            System.out.println();
        }

        System.out.println("================================ ==================================");

        for(Row row : sheet){
            for(Cell cell : row){
                System.out.printf("%15s ",cell.getStringCellValue() + " ");
            }
            System.out.println();
        }


    }

}
