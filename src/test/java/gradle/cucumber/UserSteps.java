package gradle.cucumber;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cn.Application;
import com.cn.vo.Header;

import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@WebAppConfiguration
@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
@RunWith(SpringRunner.class)
public class UserSteps extends AbstractJUnit4SpringContextTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MvcResult mvcResult;

	private MockMvc mockMvc;

	@BeforeStep
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}

	@Given("I have a valid user id with me")
	public void i_have_a_valid_user_id_with_me() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("I make a request to fetch user info with id {string}")
	public void i_make_a_request_to_fetch_user_info_for_user_with_id(
			String userId) throws Exception {

		/*
		 * this.mockMvc =
		 * MockMvcBuilders.webAppContextSetup(webApplicationContext) .build();
		 */

		Header header = new Header.HeaderBuilder()
				.setContentType("application/json").setTransactionId("test")
				.build();

		HttpHeaders headers = new HttpHeaders();

		headers.add("content-type", header.getContentType());
		headers.add("transactionId", header.getTransactionId());

		mvcResult = this.mockMvc.perform(get("/users/" + userId)
				.headers(headers).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andReturn();
		
	}

	@Then("system will return user information with {int} response status")
	public void system_will_return_user_information_with_response_status(
			int status) {
		assertEquals(status, mvcResult.getResponse().getStatus());
	}

}
