package dev.codethat.retail;

import static dev.codethat.retail.MyRetailServiceConstants.PRODUCT_PATH;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MyRetailServiceApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getProduct() throws Exception {
		// +ve
		this.mvc.perform(get(PRODUCT_PATH + "/138604281")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.currentPrice.value").value("13.49"));
		// -ve
		this.mvc.perform(get(PRODUCT_PATH + "/138604282")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.currentPrice").hasJsonPath());
		// +ve
		this.mvc.perform(get(PRODUCT_PATH + "/13860428")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.currentPrice.value").value("10.49"));
	}

	@Test
	public void updateProduct() throws Exception {
		// +ve
		this.mvc.perform(put(PRODUCT_PATH).contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\":\"13860428\",\"currentPrice\":{\"value\":10.49,\"currencyCode\":\"USD\"}}"))
				.andExpect(status().isOk());
		// -ve
		this.mvc.perform(put(PRODUCT_PATH).contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\":\"138604285\",\"currentPrice\":{\"value\":10.49,\"currencyCode\":\"USD\"}}"))
				.andExpect(status().isOk());
	}

}
