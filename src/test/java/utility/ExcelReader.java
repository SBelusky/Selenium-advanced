package utility;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    private String excelPath;
    private Workbook excelData;

    public ExcelReader(String excelPath) throws IOException {
        this.excelPath = excelPath;

        FileInputStream input = new FileInputStream(new File(excelPath));
        this.excelData = new XSSFWorkbook(input);
    }

    public Sheet getSheetByName(String sheetName){
        return excelData.getSheet(sheetName);
    }
}
