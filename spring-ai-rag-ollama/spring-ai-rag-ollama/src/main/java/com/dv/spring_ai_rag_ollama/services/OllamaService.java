package com.dv.spring_ai_rag_ollama.services;

import com.dv.spring_ai_rag_ollama.model.Answer;
import com.dv.spring_ai_rag_ollama.model.Question;

public interface OllamaService {

    Answer getAnswer(Question question);
}
