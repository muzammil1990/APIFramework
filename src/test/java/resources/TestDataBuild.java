/**
 * 
 */
package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

/**
 * This class is responsible for generating Test Data for all our test cases/scripts.
 */
public class TestDataBuild {

    public AddPlace addPlacePayload(){

//using serialization(from java object we construct json body - payload) we build json body's values        
        AddPlace ap= new AddPlace();
        ap.setAccuracy(50);  // here giving/constructing the json node's values
        ap.setName("Frontline house");
        ap.setPhone_number("(+91) 983 893 3937"); // here giving/constructing the json node's values
        ap.setAddress("29, side layout, cohen 09");
        ap.setWebsite("http://google.com");
        ap.setLanguage("english");
        
        List<String> mylist= new ArrayList<String>();
        mylist.add("shoe park");
        mylist.add("shop");
        
        ap.setTypes(mylist);
        
        Location l= new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        
        ap.setLocation(l);
        
        return ap;  //this nested class gets consumed in main parent pojo class= AddPlace; returning the java object.
        //when we return the java object, add place api is ready fully, constructed with values as given in addPlace contract details
    }
}
