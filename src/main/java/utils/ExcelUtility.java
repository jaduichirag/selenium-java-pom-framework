package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private Workbook workbook;
	private Sheet sheet;
	private DataFormatter formatter;

	// ============================================
	// Constructor
	// ============================================

	public ExcelUtility(String filePath) {

		try {

			FileInputStream fis = new FileInputStream(filePath);

			workbook = new XSSFWorkbook(fis);

			formatter = new DataFormatter();

		}

		catch (IOException e) {

			throw new RuntimeException("Unable to open Excel File : " + filePath, e);

		}

	}

	// ============================================
	// Select Sheet
	// ============================================

	public void selectSheet(String sheetName) {

		sheet = workbook.getSheet(sheetName);

		if (sheet == null) {

			throw new RuntimeException("Sheet Not Found : " + sheetName);

		}

	}

	// ============================================
	// Get Current Sheet
	// ============================================

	public Sheet getCurrentSheet() {

		return sheet;

	}

	// ============================================
	// Read Cell
	// ============================================

	public String getCellData(int row, int column) {

		Row currentRow = sheet.getRow(row);

		if (currentRow == null) {

			return "";

		}

		Cell cell = currentRow.getCell(column);

		if (cell == null) {

			return "";

		}

		return formatter.formatCellValue(cell);

	}

	// ============================================
	// Read Entire Row
	// ============================================

	public List<String> getRowData(int row) {

		List<String> data = new ArrayList<>();

		Row currentRow = sheet.getRow(row);

		if (currentRow == null) {

			return data;

		}

		for (Cell cell : currentRow) {

			data.add(formatter.formatCellValue(cell));

		}

		return data;

	}

	// ============================================
	// Read Entire Column
	// ============================================

	public List<String> getColumnData(int column) {

		List<String> data = new ArrayList<>();

		for (Row row : sheet) {

			Cell cell = row.getCell(column);

			if (cell == null) {

				data.add("");

			}

			else {

				data.add(formatter.formatCellValue(cell));

			}

		}

		return data;

	}

	// ============================================
	// Row Count
	// ============================================

	public int getRowCount() {

		return sheet.getLastRowNum();

	}

	// ============================================
	// Column Count
	// ============================================

	public int getColumnCount() {

		Row firstRow = sheet.getRow(0);

		if (firstRow == null) {

			return 0;

		}

		return firstRow.getLastCellNum();

	}

	// ============================================
	// Sheet Count
	// ============================================

	public int getSheetCount() {

		return workbook.getNumberOfSheets();

	}

	// ============================================
	// Sheet Names
	// ============================================

	public List<String> getSheetNames() {

		List<String> sheets = new ArrayList<>();

		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {

			sheets.add(workbook.getSheetName(i));

		}

		return sheets;

	}

	// ============================================
	// Set Cell Data
	// ============================================

	public void setCellData(int row, int column, String value) {

		Row currentRow = sheet.getRow(row);

		if (currentRow == null) {

			currentRow = sheet.createRow(row);

		}

		Cell cell = currentRow.getCell(column);

		if (cell == null) {

			cell = currentRow.createCell(column);

		}

		cell.setCellValue(value);

	}

	// ============================================
	// Create Sheet
	// ============================================

	public void createSheet(String sheetName) {

		if (workbook.getSheet(sheetName) == null) {

			workbook.createSheet(sheetName);

		}

	}

	// ============================================
	// Delete Sheet
	// ============================================

	public void deleteSheet(String sheetName) {

		int index = workbook.getSheetIndex(sheetName);

		if (index != -1) {

			workbook.removeSheetAt(index);

		}

	}

	// ============================================
	// Create Row
	// ============================================

	public void createRow(int rowNumber) {

		if (sheet.getRow(rowNumber) == null) {

			sheet.createRow(rowNumber);

		}

	}

	// ============================================
	// Create Cell
	// ============================================

	public void createCell(int row, int column, String value) {

		Row currentRow = sheet.getRow(row);

		if (currentRow == null) {

			currentRow = sheet.createRow(row);

		}

		Cell cell = currentRow.getCell(column);

		if (cell == null) {

			cell = currentRow.createCell(column);

		}

		cell.setCellValue(value);

	}

	// ============================================
	// Remove Row
	// ============================================

	public void removeRow(int rowNumber) {

		Row row = sheet.getRow(rowNumber);

		if (row != null) {

			sheet.removeRow(row);

		}

	}

	// ============================================
	// Clear Cell
	// ============================================

	public void clearCell(int row, int column) {

		Row currentRow = sheet.getRow(row);

		if (currentRow == null) {

			return;

		}

		Cell cell = currentRow.getCell(column);

		if (cell != null) {

			currentRow.removeCell(cell);

		}

	}

	// ============================================
	// Auto Size Column
	// ============================================

	public void autoSizeColumn(int column) {

		sheet.autoSizeColumn(column);

	}

	// ============================================
	// Save Workbook
	// ============================================

	public void save(String filePath) {

		try (java.io.FileOutputStream fos = new java.io.FileOutputStream(filePath)) {

			workbook.write(fos);

		}

		catch (IOException e) {

			throw new RuntimeException("Unable to save workbook.", e);

		}

	}

	// ============================================
	// Close Workbook
	// ============================================

	public void close() {

		try {

			if (workbook != null) {

				workbook.close();

			}

		}

		catch (IOException e) {

			throw new RuntimeException("Unable to close workbook.", e);

		}

	}
	// ============================================
	// Check Sheet Exists
	// ============================================

	public boolean isSheetExists(String sheetName) {

	    return workbook.getSheet(sheetName) != null;

	}

	// ============================================
	// Check Row Exists
	// ============================================

	public boolean isRowExists(int row) {

	    return sheet.getRow(row) != null;

	}

	// ============================================
	// Check Cell Exists
	// ============================================

	public boolean isCellExists(int row,
	                            int column) {

	    Row currentRow = sheet.getRow(row);

	    if (currentRow == null) {

	        return false;

	    }

	    return currentRow.getCell(column) != null;

	}

	// ============================================
	// Get Last Row Index
	// ============================================

	public int getLastRowIndex() {

	    return sheet.getLastRowNum();

	}

	// ============================================
	// Get Cell Type
	// ============================================

	public String getCellType(int row,
	                          int column) {

	    Row currentRow = sheet.getRow(row);

	    if (currentRow == null) {

	        return "";

	    }

	    Cell cell = currentRow.getCell(column);

	    if (cell == null) {

	        return "";

	    }

	    return cell.getCellType().name();

	}

	// ============================================
	// Read Entire Sheet
	// ============================================

	public Object[][] getTestData() {

	    int rows = getRowCount();
	    int cols = getColumnCount();

	    Object[][] data =
	            new Object[rows][cols];

	    for (int i = 1; i <= rows; i++) {

	        for (int j = 0; j < cols; j++) {

	            data[i - 1][j] =
	                    getCellData(i, j);

	        }

	    }

	    return data;

	}

	// ============================================
	// Read Sheet By Name
	// ============================================

	public Object[][] getTestData(String sheetName) {

	    selectSheet(sheetName);

	    return getTestData();

	}

	// ============================================
	// Get Workbook
	// ============================================

	public Workbook getWorkbook() {

	    return workbook;

	}

	// ============================================
	// Get Active Sheet Name
	// ============================================

	public String getCurrentSheetName() {

	    return sheet.getSheetName();

	}

	// ============================================
	// Formula Cell Value
	// ============================================

	public String getFormulaValue(int row,
	                              int column) {

	    Row currentRow = sheet.getRow(row);

	    if (currentRow == null) {

	        return "";

	    }

	    Cell cell = currentRow.getCell(column);

	    if (cell == null) {

	        return "";

	    }

	    return formatter.formatCellValue(cell);

	}

	// ============================================
	// Numeric Value
	// ============================================

	public double getNumericValue(int row,
	                              int column) {

	    return sheet.getRow(row)
	            .getCell(column)
	            .getNumericCellValue();

	}

	// ============================================
	// Boolean Value
	// ============================================

	public boolean getBooleanValue(int row,
	                               int column) {

	    return sheet.getRow(row)
	            .getCell(column)
	            .getBooleanCellValue();

	}

}
