package fr.devoxx.tia.PingService;

import java.util.Map;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class PingConfiguration extends Configuration{
	@NotNull
	@JsonProperty
	private Map<String, Object> defaultHystrixConfig;
	
	public Map<String, Object> getDefaultHystrixConfig() {
		return defaultHystrixConfig;
	}
}
