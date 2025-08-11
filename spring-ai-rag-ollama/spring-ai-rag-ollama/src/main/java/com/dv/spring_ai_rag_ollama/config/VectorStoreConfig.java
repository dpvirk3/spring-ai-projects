package com.dv.spring_ai_rag_ollama.config;


import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ai.vectorstore.SimpleVectorStore;

import java.io.File;

@Configuration
public class VectorStoreConfig {

    @Bean
    public SimpleVectorStore simpleVectoreStore(EmbeddingModel embeddingModel,
                                                 VectorStoreProperties vectorStoreProperties) {
        SimpleVectorStore simpleVectorStore = SimpleVectorStore.builder(embeddingModel).build();

        File vectorStorefile = new File(vectorStoreProperties.getVectorStorePath());

        return simpleVectorStore;
    }
}
