package com.dv.spring_ai_prompt_engr_ollama;


import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BaseTestClass {

    @Autowired
    OllamaChatModel chatmodel;

    String chat (String prompt) {
        PromptTemplate promptTemplate = new PromptTemplate(prompt);
        Prompt promptToSend = promptTemplate.create();

        ChatResponse response = chatmodel.call(promptToSend);

        return response.getResult().getOutput().getText();
    }
}
