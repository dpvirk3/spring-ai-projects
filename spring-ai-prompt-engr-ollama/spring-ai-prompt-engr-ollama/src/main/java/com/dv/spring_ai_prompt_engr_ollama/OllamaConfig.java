package com.dv.spring_ai_prompt_engr_ollama;


import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OllamaConfig {
    @Bean
    public OllamaChatModel OllamaChatModel() {
        OllamaApi ollamaApi = OllamaApi.builder().build();

        OllamaChatModel chatModel = OllamaChatModel.builder()
                .ollamaApi(ollamaApi)
                .defaultOptions(
                        OllamaOptions.builder()
                                .model("gemma3")
                                .temperature(0.9)
                                .build()
                )
                .build();

        return chatModel;
    }
}
