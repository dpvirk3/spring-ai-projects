package com.dv.spring_ai_rag_ollama;


import org.springframework.ai.observation.conventions.VectorStoreProvider;
import org.springframework.ai.ollama.OllamaEmbeddingModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OllamaConfig {

    @Bean
    public OllamaEmbeddingModel ollamaEmbeddingModel() {
        OllamaApi ollamaApi = OllamaApi.builder().build();



        OllamaEmbeddingModel embeddingModel = OllamaEmbeddingModel.builder()
                .ollamaApi(ollamaApi)
                .defaultOptions(
                        OllamaOptions.builder()
                                .model("llama2")
                                .build()
                ).build();

        return embeddingModel;

    }
}
