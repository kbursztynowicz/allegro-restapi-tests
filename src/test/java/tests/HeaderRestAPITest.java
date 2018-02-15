package tests;

import com.jayway.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class HeaderRestAPITest extends AbstractRestAPITest {

//  this test checks if a header element contains desired value
    @Test
    public void should_emails_have_correct_format() throws Exception {

        given(restAPIConfig.spec)
            .accept(ContentType.JSON)
        .when()
            .head("/posts")
        .then()
            .statusCode(200)
            .header("Content-Type", CoreMatchers.equalTo("application/json; charset=utf-8"));

    }

}
