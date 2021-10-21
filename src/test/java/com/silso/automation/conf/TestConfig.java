package com.silso.automation.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@ComponentScan(basePackages = "com.silso.automation")//Where to look for components
@PropertySource("classpath:/application-${environment:qa}.properties")
public class TestConfig {

}
