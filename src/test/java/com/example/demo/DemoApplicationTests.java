package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private  ResourceLoader resourceLoader;

	@Test
	void contextLoads() throws Exception{
		Resource resource = resourceLoader.getResource("classpath:/menu.yaml");
	
		// Create ObjectMapper for YAML
		ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());

		// Read YAML and convert to JSON
		JsonNode jsonNode = yamlMapper.readTree(resource.getInputStream());

		// Create ObjectMapper for JSON
		ObjectMapper jsonMapper = new ObjectMapper();

		// Convert JSON to String
		String jsonString = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

		System.out.println(jsonString);
		assertNotNull(jsonString);
	}

}
