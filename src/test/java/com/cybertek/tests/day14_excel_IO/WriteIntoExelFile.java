package com.cybertek.tests.day14_excel_IO;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteIntoExelFile {

    public static void main(String[] args) throws IOException {
        //whenever you are writing data back to excel file, do not open it!
        String path = "vytrack_testusers.xlsx";
        FileInputStream file = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet("QA2-short");
        Row row1 = sheet.getRow(2);
        //let's change N/A to FAILED
        Cell cell5 = row1.getCell(4);

        System.out.println("before value: " + cell5);
        //to change value
        cell5.setCellValue("PASSED");
        cell5 = row1.getCell(4);

        System.out.println("value after: " + cell5);

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        workbook.close();
        fileOutputStream.close();
        file.close();




    }
}

