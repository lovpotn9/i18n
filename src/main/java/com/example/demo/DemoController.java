package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;


@RestController
public class DemoController {
    
    @Autowired
	private  ResourceLoader resourceLoader;

    
    
    @RequestMapping("/i18n")
    public JsonNode getMenu18n() throws Exception {
        Resource resource = resourceLoader.getResource("classpath:/menu.yaml");
	
		// Create ObjectMapper for YAML
		ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());

		// Read YAML and convert to JSON
		return yamlMapper.readTree(resource.getInputStream());

    }

}
