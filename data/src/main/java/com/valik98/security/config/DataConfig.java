package com.valik98.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:data.yaml"}, factory = YamlPropertySourceFactory.class)
public class DataConfig {
}
