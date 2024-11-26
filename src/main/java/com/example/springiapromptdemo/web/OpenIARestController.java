package com.example.springiapromptdemo.web;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OpenIARestController {


  OpenIARestController(){
   OpenAiApi openAiApi= new OpenAiApi("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");
   OpenAiChatOptions openAiChatOptions= OpenAiChatOptions.builder()
           .withModel("gpt-4o")
           .withTemperature(0D)
           .withMaxTokens(2000)
           .build();

   OpenAiChatModel openAiChatModel= new OpenAiChatModel(openAiApi,openAiChatOptions);

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
      ChatResponse chatResponse = openAiChatModel.call(prompt);
      System.out.println("chatResponse = " + chatResponse);
  }
}
