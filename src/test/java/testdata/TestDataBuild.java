package testdata;

import java.util.ArrayList;
import java.util.List;

import pojo.Location;
import pojo.LocationPOJO;

public class TestDataBuild {

	public LocationPOJO addPlacePayload(String name,String language,String address) {
		LocationPOJO locpojo = new LocationPOJO();
		locpojo.setAccuracy(10);
		locpojo.setAddress(address);
		locpojo.setLanguage(language);
		locpojo.setPhone_number("1313");
		locpojo.setWebsite("www.theqaautomation.com");
		locpojo.setName(name);

		Location l = new Location();
		l.setLat(12.34);
		l.setLat(-11.34);

		locpojo.setLocation(l);
		// locpojo.setLocation(null);

		List<String> mylist = new ArrayList<String>();
		mylist.add("asd");
		mylist.add("zxf");
		locpojo.setTypes(mylist);

		return locpojo;
	}
}
