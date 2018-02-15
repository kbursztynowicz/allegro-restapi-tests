package tests;

import com.jayway.restassured.response.Response;
import config.RestAPIConfig;
import org.junit.Before;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public abstract class AbstractRestAPITest {

    public RestAPIConfig restAPIConfig;

    @Before
    public void testSetup() {
        this.restAPIConfig = new RestAPIConfig();
    }

//  mechanism that validates correctness of an email address
    public boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }


}
