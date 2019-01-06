package ReadingWritingExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("D:\\Eclipse-Workspace\\SeleniumProject\\Book1.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		//XSSFSheet sheet = wb.getSheetAt(0);
		XSSFSheet sheet = wb.getSheetAt(1);
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		System.out.println("The Total No of Rows: "+rowCount);
//===========================================================================	
//		for(int i=0; i<rowCount+1; i++)
//		{
//			Row row = sheet.getRow(i);
//			
//			for(int j=0; j<row.getLastCellNum(); j++)
//			{
//				System.out.print(row.getCell(j).getStringCellValue()+"||");
//			}
//			
//			System.out.println();
//		}
//==============================================================================
		Iterator rows = sheet.iterator();
		while(rows.hasNext())
		{
			XSSFRow row = (XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			while(cells.hasNext())
			{
				XSSFCell cell = (XSSFCell) cells.next();
				CellType type = cell.getCellType();
				if(type==CellType.STRING)
				{
					System.out.println("[" + cell.getRowIndex() + ", "
                            + cell.getColumnIndex() + "] = STRING; Value = "
                            + cell.getRichStringCellValue().toString());
				}
				else if(type==CellType.NUMERIC)
				{
					System.out.println("[" + cell.getRowIndex() + ", "
                            + cell.getColumnIndex() + "] = NUMERIC; Value = "
                            + cell.getNumericCellValue());
				}
				else if(type==CellType.BOOLEAN)
				{
					System.out.println("[" + cell.getRowIndex() + ", "
                            + cell.getColumnIndex() + "] = Bulean; Value = "
                            + cell.getBooleanCellValue());
				}
				else if(type==CellType.BLANK)
				{
					System.out.println("[" + cell.getRowIndex() + ", "
                            + cell.getColumnIndex() + "] = BLANK; Value = ");
				}
				
				
			}
			
		}
		
	}

}
