package com.dv.spring_ai_rag_ollama.controllers;


import com.dv.spring_ai_rag_ollama.model.Answer;
import com.dv.spring_ai_rag_ollama.model.Question;
import com.dv.spring_ai_rag_ollama.services.OllamaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    private final OllamaService ollamaService;

    public QuestionController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @PostMapping("/ask")
    public Answer getAnswer (@RequestBody Question question) {
        return ollamaService.getAnswer(question);
    }
}
