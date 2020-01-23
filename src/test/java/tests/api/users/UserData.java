package tests.api.users;

import org.testng.annotations.Test;

import com.shaft.api.RestActions;
import com.shaft.api.RestActions.RequestType;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.AssertionComparisonType;
import com.shaft.validation.Assertions.AssertionType;

import io.restassured.response.Response;

public class UserData {

    @Test
    public void validateUserEmail() {
	RestActions apiObject = new RestActions("https://jsonplaceholder.typicode.com");
	Response users = apiObject.performRequest(RequestType.GET, 200, "/users");

	Assertions.assertEquals("Leanne Graham", RestActions.getResponseBody(users), AssertionComparisonType.CONTAINS,
		AssertionType.POSITIVE);

	RestActions.getResponseJSONValueAsList(users, "$").forEach(user -> {
	    if (RestActions.getResponseJSONValue(user, "name").equals("Leanne Graham")) {
		Assertions.assertEquals("Sincere@april.biz", RestActions.getResponseJSONValue(user, "email"),
			AssertionComparisonType.EQUALS, AssertionType.POSITIVE);
	    }

	});
    }
}
