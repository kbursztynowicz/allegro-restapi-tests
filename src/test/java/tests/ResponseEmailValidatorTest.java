package tests;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import static com.jayway.restassured.RestAssured.given;


public class ResponseEmailValidatorTest extends AbstractRestAPITest {

    public Response response;

//  this test extracts all email addresses from /comments endpoint and validates their correctness
    @Test
    public void should_emails_have_correct_format() throws Exception {

        response =  given(restAPIConfig.spec)
                        .accept(ContentType.JSON)
                    .when()
                        .get("/comments")
                    .then()
                        .statusCode(200)
                        .extract().response();

        List<String> emailsFromResponse = response.path("email");


        for (String email : emailsFromResponse)
        {
            assertThat(isValidEmailAddress(email)).isTrue();
        }
    }

}
