package driver;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.jupiter.api.Test;

class readDataUnitTest {

	@Test
	void test() {
		DateTimeZone pacific = DateTimeZone.forID("Pacific/Auckland");
		DateTimeZone aussie = DateTimeZone.forID("Australia/Sydney");
		DateTime dt = new DateTime();
        DateTime dtAucklandZone = dt.withZone(DateTimeZone.forID("Pacific/Auckland"));
        DateTime dtSydneyZone = dt.withZone(DateTimeZone.forID("Australia/Sydney"));
        String dtAuckland = dtAucklandZone.toString();
        String dtSydney = dtSydneyZone.toString();
        String aucklandDateTimetrunc = dtAuckland.substring(0, dtAuckland.length() - 10);
        String sydneylandDateTimetrunc = dtSydney.substring(0, dtSydney.length() - 10);
        
		System.out.println(","+pacific+","+aucklandDateTimetrunc);
		System.out.println(","+aussie+","+sydneylandDateTimetrunc);
		
	}

}
