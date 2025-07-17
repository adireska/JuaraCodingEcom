package com.juaracoding.ecom.providers;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.juaracoding.ecom.utils.ExcelUtils;

public class DataTestProvider {

  // @DataProvider(name = "loginDataProvider")
  // public Object[][] loginDataProvider() {
  //   String excelPath = "src/test/resources/DataTestProvider.xlsx";
  //   ExcelUtils excel = new ExcelUtils(excelPath, "Sheet1");
  //   int rowCount = excel.getRowCount();
  //   int colCount = excel.getColCount();
  //   Object data[][] = new Object[rowCount - 1][colCount];
  //   for (int i = 1; i < rowCount; i++) {
  //     for (int j = 0; j < colCount; j++) {
  //       data[i - 1][j] = excel.getCellData(i, j);
  //     }
  //   }
  //   return data;
  // }

  @DataProvider(name = "loginDataProvider")
  public Object[][] loginDataProvider() {
    String excelPath = "src/test/resources/DataTestProvider.xlsx";
    ExcelUtils excel = new ExcelUtils(excelPath, "Sheet1");

    int rowCount = excel.getRowCount();
    int colCount = excel.getColCount();

    List<Object[]> dataList = new ArrayList<>();

    for (int i = 1; i < rowCount; i++) {
      boolean isRowEmpty = true;
      Object[] rowData = new Object[colCount];

      for (int j = 0; j < colCount; j++) {
        String cellValue = excel.getCellData(i, j);
        rowData[j] = cellValue;

        if (!cellValue.isEmpty()) {
          isRowEmpty = false;
        }
      }

      if (!isRowEmpty) {
        dataList.add(rowData);
      } else {
        System.out.println("Skipping empty row: " + i);
      }
    }

    return dataList.toArray(new Object[0][]);
  }


}
