package com.test.steps;

import com.test.PojoStudentClass;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APISteps2 {
    String id;

    // @Test(priority = 1)
    public void createStudentWithHashMap() {
        HashMap data = new HashMap();
        data.put("name", "Emeli");
        data.put("location", "Paris");
        data.put("phone", "123456");

        String coursesArr[] = {"Music", "Reading"};
        data.put("courses", coursesArr);

        id = given().contentType("application/json").body(data)
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name", equalTo("Emeli"))
                .body("location", equalTo("Paris"))
                .body("phone", equalTo("123456"))
                .body("courses[0]", equalTo("Music"))
                .body("courses[1]", equalTo("Reading"))
                .header("Content-Type", "application/json")
                .log().all()
                .extract()
                .path("id");
    }

    @Test(priority = 2)
    public void deleteStudent() {
        given()
                .when().delete("http://localhost:3000/students/" + id)
                .then().statusCode(200).log().all();

    }

    //@Test(priority = 2)
    public void createStudentWithOrgJson() {
        JSONObject data = new JSONObject();
        data.put("name", "Lora");
        data.put("location", "Roma");
        data.put("phone", "464532541");

        String cursesArr[] = {"Drawing", "Dansing"};
        data.put("courses", cursesArr);

        id = given().contentType("application/json")
                .body(data.toString())
                .when()
                .post("http://localhost:3000/students")
                .then().statusCode(201)
                 .body("name", equalTo("Lora"))
                .body("location", equalTo("Roma"))
                .body("phone", equalTo("464532541"))
                .body("courses[0]", equalTo("Drawing"))
                .body("courses[1]", equalTo("Dansing"))
                .log().all()
                .extract()
                .path("id");
    }

    //    @Test(priority = 2)
    public void createStudentWithPojoClass() {
        PojoStudentClass data = new PojoStudentClass();
        data.setName("Mirabell");
        data.setLocation("Paris");
        data.setPhone("355452");
        String coursesArr[] = {"Magic", "Bloger"};
        data.setCourses(coursesArr);

        id = given().contentType("application/json")
                .body(data)
                .when().post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name", equalTo("Mirabell"))
                .body("location", equalTo("Paris"))
                .body("phone", equalTo("355452"))
                .body("courses[0]", equalTo("Magic")) 
                .body("courses[1]", equalTo("Bloger"))
                .log().all()
                .extract()
                .path("id");
    }

    @Test(priority = 2)
    public void createUserWithExternalJson() throws FileNotFoundException {
        File f = new File(".\\body.json");
        FileReader fileReader = new FileReader(f);
        JSONTokener jsonTokener = new JSONTokener(fileReader);
        JSONObject data = new JSONObject(jsonTokener);

        id = given().contentType("application/json")
                .body(data.toString())
                .when().post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name", equalTo("Elvina"))
                .body("location", equalTo("Israel"))
                .body("phone", equalTo("123456"))
                .body("courses[0]", equalTo("Java"))
                .body("courses[1]", equalTo("Selenium"))
                .log().all()
                .extract()
                .path("id");
    }


}
