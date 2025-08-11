package com.dv.spring_ai_rag_ollama.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "com.dv.aiapp")
public class VectorStoreProperties {

    private String vectorStorePath;

    public String getVectorStorePath() {
        return this.vectorStorePath;
    }

    public void setVectorStorePath(String vectorStorePath1) {
        this.vectorStorePath=vectorStorePath1;
    }
}
