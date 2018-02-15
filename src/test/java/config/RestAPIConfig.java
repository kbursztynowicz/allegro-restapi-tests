package config;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;

public class RestAPIConfig {

    public RequestSpecification spec;

    public RestAPIConfig() {
        this.spec = new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .build();
    }

}
