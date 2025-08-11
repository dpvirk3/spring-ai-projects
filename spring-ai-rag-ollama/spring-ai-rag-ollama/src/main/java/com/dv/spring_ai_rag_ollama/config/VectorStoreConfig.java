package com.dv.spring_ai_rag_ollama.config;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ai.vectorstore.SimpleVectorStore;

import java.io.File;
import java.util.List;

@Slf4j
@Configuration
public class VectorStoreConfig {

    private static final Logger log = LoggerFactory.getLogger(VectorStoreConfig.class);

    @Bean
    public SimpleVectorStore simpleVectoreStore(EmbeddingModel embeddingModel,
                                                 VectorStoreProperties vectorStoreProperties) {
        var vectorStore = SimpleVectorStore.builder(embeddingModel).build();

        File vectorStorefile = new File(vectorStoreProperties.getVectorStorePath());

        if (vectorStorefile.exists()) {
            vectorStore.load(vectorStorefile);
        }
        else {
            log.debug("Loading documents into vector store");
            vectorStoreProperties.getDocumentsToLoad().forEach(document -> {
               System.out.println("Loading documents: " + document.getFilename());

                TikaDocumentReader documentReader = new TikaDocumentReader(document);
                //this gets the metadata about documents
                List<Document> docs = documentReader.get();
                TextSplitter textSplitter = new TokenTextSplitter();
                //document is split into pieces before loading into vector store
                List<Document> splitDocs = textSplitter.apply(docs);
                //this add functions embeds the documents and then stored
                vectorStore.add(splitDocs);
            });

            vectorStore.save(vectorStorefile);
        }

        return vectorStore;
    }
}
