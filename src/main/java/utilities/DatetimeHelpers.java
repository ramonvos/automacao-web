package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetimeHelpers {

	
	// Metodo para retornar a data hora atual
    public static String getCurrentDateToString() {
    	 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");//dd/MM/yyyy
         Date now = new Date();
         String strDate = sdfDate.format(now);
         return strDate;
    }
}
