package com.dv.spring_ai_rag_ollama.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "com.dv.aiapp")
public class VectorStoreProperties {

    private String vectorStorePath;

    public void setDocumentsToLoad(List<Resource> documentsToLoad) {
        this.documentsToLoad = documentsToLoad;
    }

    private List<Resource> documentsToLoad;


    public String getVectorStorePath() {
        return this.vectorStorePath;
    }

    public void setVectorStorePath(String vectorStorePath1) {
        this.vectorStorePath=vectorStorePath1;
    }

    public List<Resource> getDocumentsToLoad() {
        return documentsToLoad;
    }

}
