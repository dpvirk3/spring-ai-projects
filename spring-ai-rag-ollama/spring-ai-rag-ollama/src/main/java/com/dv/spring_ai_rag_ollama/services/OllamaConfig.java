package com.dv.spring_ai_rag_ollama.services;


import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.OllamaEmbeddingModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OllamaConfig {

    @Bean
    public OllamaChatModel OllamaChatModep() {
        OllamaApi ollamaApi = OllamaApi.builder().build();

        OllamaChatModel chatModel = OllamaChatModel.builder()
                .ollamaApi(ollamaApi)
                .defaultOptions(
                        OllamaOptions.builder()
                                .model("gemma3")
                                .temperature(0.9)
                                .build())
                .build();

        return chatModel;
    }

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
