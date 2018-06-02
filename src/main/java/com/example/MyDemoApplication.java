package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, JdbcTemplateAutoConfiguration.class})
//@EnableAutoConfiguration
public class MyDemoApplication extends SpringBootServletInitializer implements CommandLineRunner, EnvironmentAware {
    private static Logger logger = LoggerFactory.getLogger(MyDemoApplication.class);
    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(MyDemoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        return builder.sources(MyDemoApplication.class);
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("==============================================");
        logger.info("----\t启动完成");
        logger.info("----\t当服务名:{}", this.environment.getProperty("server.servlet-path"));
        logger.info("----\t当服务端口:{}", this.environment.getProperty("server.port"));
        logger.info("----\t当应用为:{}", this.environment.getProperty("spring.application.name"));
        logger.info("----\t当前环境为:{}", this.environment.getProperty("spring.profiles.active"));
        logger.info("----\t时区:{}", this.environment.getProperty("user.timezone"));
        logger.info("----------------------------------------------");
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

}
