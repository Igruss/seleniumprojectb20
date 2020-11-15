package com.cybertek.tests.day14_excel_IO;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ReadExelFile {

    public static void main(String[] args) throws IOException {

        String path = "vytrack_testusers.xlsx";
        File file = new File(path);
        Workbook workbook = WorkbookFactory.create(file);
        int numOfSheets = workbook.getNumberOfSheets();
        System.out.println("Number of sheets: " + numOfSheets);

        Sheet sheet = workbook.getSheet("QA3-short");

        Row row1 = sheet.getRow(0);

        Cell cell1 = row1.getCell(0);

        String value1 = cell1.getStringCellValue();

        System.out.println("Value of 1st row 1st column: " + value1);

        Iterator<Cell> cellIterator = row1.cellIterator();
        while (cellIterator.hasNext()){
            String value = cellIterator.next().getStringCellValue();
            System.out.print(value + " ");
        }
        System.out.println("======================================");


        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Iterator<Cell> tempCellIterator = rowIterator.next().cellIterator();
            while (tempCellIterator.hasNext()) {
                String value = tempCellIterator.next().getStringCellValue();
                System.out.print(value + " ");
            }
            System.out.println();
        }

    }
}
