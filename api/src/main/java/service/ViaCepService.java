package service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import model.Endereco;

public class ViaCepService {

	public Endereco getEndereco(String cep) throws IOException {

		Endereco end = null;
		HttpGet request = new HttpGet("https://brasilapi.com.br/api/cep/v1/"+cep+"");

		try (CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
				CloseableHttpResponse response = httpClient.execute(request)) {

			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String result = EntityUtils.toString(entity);
				Gson gson = new Gson();
				end = gson.fromJson(result, Endereco.class);
			}

		}

		return end;
	}

}