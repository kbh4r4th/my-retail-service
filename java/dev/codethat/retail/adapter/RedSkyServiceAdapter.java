/**
 * 
 */
package dev.codethat.retail.adapter;

import java.net.URI;
import java.net.URISyntaxException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import dev.codethat.retail.MyRetailServiceConstants;
import dev.codethat.retail.bean.RedSkyProductResponse;

/**
 * @author Bharath
 *
 */
@Service
public class RedSkyServiceAdapter implements ServiceAdapterI<String, RedSkyProductResponse> {

	private RestTemplate restTemplate;

	@Value("${dev.codethat.retail.redsky.service.baseurl}")
	private String baseUrl;

	@Value("${dev.codethat.retail.redsky.service.product.uri}")
	private String productUri;

	@Value("${dev.codethat.retail.redsky.service.product.uri.qparams}")
	private String productQParam;

	public RedSkyServiceAdapter(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	@Override
	public RedSkyProductResponse get(String id) {
		RedSkyProductResponse response = null;
		try {
			String json = restTemplate.getForObject(new URI(baseUrl
					.concat(this.productUri.replace(MyRetailServiceConstants.PATH_VARIABLE_ID, String.valueOf(id)))
					.concat(this.productQParam)), String.class);
			response = new RedSkyProductResponse();
			response.setName(getProductTitle(json));
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
		}
		return response;
	}

	private String getProductTitle(String json) {
		String title = null;
		JSONObject jo = null;
		try {
			jo = (JSONObject) new JSONParser().parse(json);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
		}
		if (jo != null) {
			jo = (JSONObject) jo.get("product");
		}
		if (jo != null) {
			jo = (JSONObject) jo.get("item");
		}
		if (jo != null) {
			jo = (JSONObject) jo.get("product_description");
			title = (String) jo.get("title");
		}
		return title;
	}

}
