package driver;

import java.io.FileReader;
import java.util.ArrayList;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;


public class DriverReport {

	public DriverReport() {
		
	}
	public static void main(String args[])  {
		
		readDataLineByLine("coordinatesTest.csv");
	}

	public static void readDataLineByLine(String file)
	{
	  
	    try {
	  
	        FileReader filereader = new FileReader(file);
	        CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(0)
                    .build();
	        String[] nextRecord;
	        
	        ArrayList<String> appendArray = new ArrayList<String>();
	        DateTimeZone defaultZone = DateTimeZone.getDefault();
	        DateTime dt = new DateTime();
	        DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
	        String dateTime = dt.toString(fmt);
	        String dateTimetrunc = dateTime.substring(0, dateTime.length() - 10);
	        
	        int count = 0;
	        while ((nextRecord = csvReader.readNext()) != null) {
	            for (String cell : nextRecord) {
	            	if(count == 0) {
	            		String[] parts = cell.split("\"");
	            		String appendDate = "";
	            		appendDate += parts[1] +","+defaultZone +","+ dateTimetrunc;
	            		appendArray.add(appendDate);
	            	}
	            	else {
	            		 cell += ","+defaultZone +","+ dateTimetrunc;
	            		 appendArray.add(cell);
	            	}
	            	
	                System.out.print(appendArray.get(count)  + "\t");
	                count++;
	            }
	            System.out.println();
	        }
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
