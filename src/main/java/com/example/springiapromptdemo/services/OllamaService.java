package com.example.springiapromptdemo.services;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OllamaService {

    @Autowired
    OllamaChatModel ollamaChatModel;
    public String callOllama(){

        SystemPromptTemplate systemPromptTemplate= new SystemPromptTemplate(
                """
                        I need you to give me the best movie on the given category: {category}
                        on the given year : {year}.
                        the outpout shourld be in json format including the following fields :
                         - category <The given category>
                         - year <The year of the movie>
                         - title <The title of the movie>
                         - producer <The producer of the movie>
                         - actors < A list of the main actors of the movie>
                         - summary <a very small summary of the movie>
                        """
        );

        Prompt prompt= systemPromptTemplate.create(Map.of("category","action","year",2020));
        ChatResponse chatResponse = ollamaChatModel.call(prompt);
        System.out.println("chatResponse = " + chatResponse);
        return chatResponse.getResult().getOutput().getContent();
    }
}
