package br.com.alelo.test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import br.com.alelo.StartSpringApp;
import br.com.alelo.dto.Vaga;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StartSpringApp.class)
@WebAppConfiguration
public class EstacionamentoControllerTest {

	protected MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
    @Test
    public void incluirVagaTestRetornoOK() throws Exception  {
    	String inputJson = retornoMockAPiJSOn();
    	   MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/estacionamento/incluirVaga")
    	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
    	   int status = mvcResult.getResponse().getStatus();
    	   assertEquals(201, status);
    }
    
    public String retornoMockAPiJSOn()  throws MalformedURLException, IOException {
        String url = "http://5fcd396c603c0c001648776a.mockapi.io/estacionamento/incluirVaga/vaga";
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            System.out.println("Erro " + conn.getResponseCode() + " ao obter dados da URL " + url);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String output = "";
        String line;
        while ((line = br.readLine()) != null) {
            output += line;
        }
        conn.disconnect();
        return output;
    }
    
    public List<Vaga> retornoMockAPI() throws MalformedURLException, IOException {
    	//Para esta tarefa foi utilizado https://mockapi.io/
        String url = "http://5fcd396c603c0c001648776a.mockapi.io/estacionamento/incluirVaga/vaga";

        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            System.out.println("Erro " + conn.getResponseCode() + " ao obter dados da URL " + url);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String output = "";
        String line;
        while ((line = br.readLine()) != null) {
            output += line;
        }

        conn.disconnect();

        Gson gson = new Gson();
        Type type = new TypeToken<List<Vaga>>() {}.getType();
        List<Vaga> vagas = (List<Vaga>) gson.fromJson(output,  type);
        
        return vagas;
    }
 }
