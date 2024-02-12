package utilities;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateUtilities {
	public static String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String formatedDate = sdf.format(date);
		return formatedDate;
		
	}
	public static String getCurrenttime() {
		Date date = new Date();
		SimpleDateFormat stf = new SimpleDateFormat("hh:mm:aa");
		String formatedTime = stf.format(date);
		return formatedTime;
		
		
	}
	public static LocalDate getTommarowDate(){
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);
		return tomorrow;

		// In string format
//		LocalDate today = LocalDate.now();
//		String tomorrow = (today.plusDays(1)).format(DateTimeFormatter.ISO_DATE);

	}

}
